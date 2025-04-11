package com.coletas.coletas.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.coletas.coletas.dao.DeliveryItemDAO;
import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.model.DeliveryItems;
import com.coletas.coletas.model.DeliveryType;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DeliveryItemServiceImplTest {

    @Mock
    private DeliveryItemDAO deliveryItemRepository;

    @InjectMocks
    private DeliveryItemServiceImpl deliveryItemService;

    private DeliveryItems deliveryItem;

    @SuppressWarnings("removal")
	@BeforeEach
    public void setUp() {
        deliveryItem = new DeliveryItems();
        deliveryItem.setIdDeliveryItems(2);
        deliveryItem.setDelivery(new Delivery());
        deliveryItem.setDeliveryType(new DeliveryType(1));
        deliveryItem.setQuantity(10);
        deliveryItem.setDeliveryStatus("Pendente");
        deliveryItem.setValuePerUnitDelivery(new Double(10));
        deliveryItem.setTotalToPay(deliveryItem.getValuePerUnitDelivery() * deliveryItem.getQuantity());
    }
    
    @Test
    public void testSave() {
        when(deliveryItemRepository.saveObject(any(DeliveryItems.class))).thenReturn(deliveryItem);

        DeliveryItems result = deliveryItemService.saveDeliveryItem(deliveryItem);
        assertNotNull(result, "The saved DeliveryItem should not be null");
        assertEquals(deliveryItem.getIdDeliveryItems(), result.getIdDeliveryItems());
    }


}