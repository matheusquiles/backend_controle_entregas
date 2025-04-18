package com.coletas.coletas.service.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import com.coletas.coletas.dao.CollectPreValueDAO;
import com.coletas.coletas.dao.EdressDAO;
import com.coletas.coletas.model.CollectPreValue;
import com.coletas.coletas.model.Edress;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EdressServiceImplTest {

    @Mock
    private EdressDAO edressDAO;

    @Mock
    private CollectPreValueDAO collectPreValueDAO;

    @InjectMocks
    private EdressServiceImpl edressService;

    private Edress edress;

    @BeforeEach
    void setUp() {
        edress = new Edress("Test Description", "123 Street", true);
        edress.setCollectPreValue(Arrays.asList(new CollectPreValue(edress, null, 100.0)));
    }

    @Test
    void testSaveSuccess() {
        when(edressDAO.saveObject(any(Edress.class))).thenReturn(edress);

        assertDoesNotThrow(() -> edressService.save(edress));

        verify(edressDAO, times(1)).saveObject(any(Edress.class));
        verify(collectPreValueDAO, times(1)).save(any(CollectPreValue.class));
    }

    @Test
    void testSaveFailure() {
        when(edressDAO.saveObject(any(Edress.class))).thenThrow(new DataIntegrityViolationException("Error"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> edressService.save(edress));

        assertTrue(exception.getMessage().contains("Failed to save edress"));
        verify(edressDAO, times(1)).saveObject(any(Edress.class));
        verify(collectPreValueDAO, never()).save(any(CollectPreValue.class));
    }
}
