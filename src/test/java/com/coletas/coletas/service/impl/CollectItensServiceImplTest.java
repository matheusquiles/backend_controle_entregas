package com.coletas.coletas.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coletas.coletas.dao.CollectDAO;
import com.coletas.coletas.dao.CollectItensDAO;
import com.coletas.coletas.dao.EdressDAO;
import com.coletas.coletas.model.Collect;
import com.coletas.coletas.model.CollectItens;
import com.coletas.coletas.model.CollectType;
import com.coletas.coletas.model.Edress;
import com.coletas.coletas.model.Users;
import com.coletas.coletas.util.DeliveryStatus;

class CollectItensServiceImplTest {

    @InjectMocks
    private CollectItensServiceImpl collectItensService;

    @Mock
    private CollectItensDAO collectItensDAO;

    @Mock
    private CollectDAO collectDAO;

    @Mock
    private EdressDAO edressDAO;

    private Collect collect;
    private CollectItens collectItem;
    private Users user;
    private Edress edress;
    private CollectType collectType;

    @BeforeEach
    void setUp() {
        // Inicializa os mocks
        MockitoAnnotations.openMocks(this);

        // Configuração de objetos de teste
        user = new Users();
        user.setIdUser(1);

        edress = new Edress();
        edress.setIdEdress(5);

        collectType = new CollectType();
        collectType.setIdCollectType(1);

        collect = new Collect();
        collect.setCollectKey("COLLECT123");
        collect.setUserId(user);
        collect.setEdress(edress);
        collect.setDate(LocalDate.now());
        collect.setStatus(true);

        collectItem = new CollectItens();
        collectItem.setCollect(collect);
        collectItem.setCollectType(collectType);
        collectItem.setQuantity(2);

        collect.setItens(Collections.singletonList(collectItem));
    }

    @Test
    void testSaveCollectItens_Success() {
        // Arrange
        Collect existingCollect = new Collect();
        existingCollect.setIdCollect(1);
        existingCollect.setCollectKey("COLLECT123");

        when(collectDAO.getByCollectKey("COLLECT123")).thenReturn(existingCollect);
        when(edressDAO.getPreValue(5, 1)).thenReturn(10.0); // Valor pré-definido por unidade
        doNothing().when(collectItensDAO).save(any(CollectItens.class));

        // Act
        Boolean result = collectItensService.saveCollectItens(collect);

        // Assert
        assertTrue(result);
        assertEquals(existingCollect, collectItem.getCollect());
        assertNotNull(collectItem.getCreationDate());
        assertEquals(user, collectItem.getCreatedBy());
        assertEquals(10.0, collectItem.getValuePerUnitCollect());
        assertEquals(20.0, collectItem.getTotalToReceive()); // 2 * 10
        assertEquals(DeliveryStatus.PENDENTE.getDescricao(), collectItem.getDeliveryStatus());
        verify(collectItensDAO, times(1)).save(collectItem);
    }

    @Test
    void testSaveCollectItens_EmptyList_ReturnsFalse() {
        // Arrange
        collect.setItens(Collections.emptyList());

        // Act
        Boolean result = collectItensService.saveCollectItens(collect);

        // Assert
        assertFalse(result);
        verify(collectDAO, never()).getByCollectKey(anyString());
        verify(collectItensDAO, never()).save(any(CollectItens.class));
    }

    @Test
    void testSaveCollectItens_NullPreValue_SetsZero() {
        // Arrange
        Collect existingCollect = new Collect();
        existingCollect.setIdCollect(1);
        existingCollect.setCollectKey("COLLECT123");

        when(collectDAO.getByCollectKey("COLLECT123")).thenReturn(existingCollect);
        when(edressDAO.getPreValue(5, 1)).thenReturn(null); // Preço nulo
        doNothing().when(collectItensDAO).save(any(CollectItens.class));

        // Act
        Boolean result = collectItensService.saveCollectItens(collect);

        // Assert
        assertTrue(result);
        assertEquals(0.0, collectItem.getValuePerUnitCollect()); // Deve ser 0 quando null
        assertEquals(0.0, collectItem.getTotalToReceive()); // 2 * 0
        verify(collectItensDAO, times(1)).save(collectItem);
    }

    @Test
    void testSaveCollectItens_DAOException_ReturnsFalse() {
        // Arrange
        Collect existingCollect = new Collect();
        existingCollect.setIdCollect(1);
        existingCollect.setCollectKey("COLLECT123");

        when(collectDAO.getByCollectKey("COLLECT123")).thenReturn(existingCollect);
        when(edressDAO.getPreValue(5, 1)).thenReturn(10.0);
        doThrow(new RuntimeException("Erro no DAO")).when(collectItensDAO).save(any(CollectItens.class));

        // Act
        Boolean result = collectItensService.saveCollectItens(collect);

        // Assert
        assertFalse(result); // Agora espera false em caso de exceção
        verify(collectItensDAO, times(1)).save(collectItem);
    }

    @Test
    void testSaveCollectItens_NullCollectKey_HandlesGracefully() {
        // Arrange
        collect.setCollectKey(null);
        when(collectDAO.getByCollectKey(null)).thenReturn(null);

        // Act
        Boolean result = collectItensService.saveCollectItens(collect);

        // Assert
        assertTrue(result); // Deve continuar e usar o collect nulo (pode ser ajustado conforme requisito)
        assertNull(collectItem.getCollect()); // Collect não foi atualizado
        verify(collectItensDAO, times(1)).save(collectItem);
    }
}