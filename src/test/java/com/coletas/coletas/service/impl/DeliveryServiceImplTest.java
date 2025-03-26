package com.coletas.coletas.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coletas.coletas.dao.DeliveryDAO;
import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.util.CreateKey;

public class DeliveryServiceImplTest {

    @Mock
    private DeliveryDAO deliveryDAO;

    @Mock
    private CreateKey key; // Adiciona o mock para CreateKey

    @InjectMocks
    private DeliveryServiceImpl deliveryServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        // Arrange
        Delivery delivery = new Delivery();
        when(key.createDeliveryKey(delivery)).thenReturn("DELIVERY123"); // Configura o mock para retornar uma chave

        // Act
        deliveryServiceImpl.save(delivery);

        // Assert
        verify(deliveryDAO, times(1)).save(delivery);
        verify(key, times(1)).createDeliveryKey(delivery); // Verifica se o método createDeliveryKey foi chamado
    }
}