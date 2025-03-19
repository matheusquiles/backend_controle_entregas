package com.coletas.coletas.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coletas.coletas.dao.DeliveryDAO;
import com.coletas.coletas.model.Delivery;

public class DeliveryServiceImplTest {

    @Mock
    private DeliveryDAO deliveryDAO;

    @InjectMocks
    private DeliveryServiceImpl deliveryServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        Delivery delivery = new Delivery();
        deliveryServiceImpl.save(delivery);

        verify(deliveryDAO, times(1)).save(delivery);
    }
}