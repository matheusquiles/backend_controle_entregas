package com.coletas.coletas.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.coletas.coletas.dao.CollectDAO;
import com.coletas.coletas.dao.CollectItensDAO;
import com.coletas.coletas.dao.EdressDAO;
import com.coletas.coletas.model.Collect;
import com.coletas.coletas.model.CollectItens;
import com.coletas.coletas.model.CollectType;
import com.coletas.coletas.model.Edress;
import com.coletas.coletas.model.Users;
import com.coletas.coletas.util.DeliveryStatus;

@ActiveProfiles("test")
@SpringBootTest
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
        when(edressDAO.getPreValue(5, 1)).thenReturn(10.0); // Valor pré-definido por unidade
        doNothing().when(collectItensDAO).save(any(CollectItens.class));

        // Act
        Boolean result = collectItensService.saveCollectItens(collect);

        // Assert
        assertTrue(result);
        assertEquals(collect, collectItem.getCollect());
        assertNotNull(collectItem.getCreationDate());
//        assertEquals(user.getIdUser(), collectItem.getCreatedBy());
        assertEquals(10.0, collectItem.getValuePerUnitCollect());
        assertEquals(20.0, collectItem.getTotalToReceive()); // Corrigido para getTotalToReceave
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
    void testSaveCollectItens_NullCollectKey_HandlesGracefully() {
        // Arrange
        collect.setCollectKey(null);
        when(edressDAO.getPreValue(5, 1)).thenReturn(10.0); // Configura o mock do edressDAO
        doNothing().when(collectItensDAO).save(any(CollectItens.class));

        // Act
        Boolean result = collectItensService.saveCollectItens(collect);

        // Assert
        assertTrue(result, "O método deve retornar true mesmo com collectKey nulo");
        assertEquals(collect, collectItem.getCollect(), "O collect no collectItem deve ser o mesmo que foi passado");
        verify(collectItensDAO, times(1)).save(collectItem);
    }
}