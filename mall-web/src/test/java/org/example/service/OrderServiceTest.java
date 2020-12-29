package org.example.service;

import org.example.model.ShoppingOrder;
import org.example.model.ShoppingProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testGetItems(){
        List<ShoppingOrder> orders = orderService.getOrders(5);

//        Map<Integer, List<ShoppingProduct>> itemsMap = new HashMap<>();
        for (ShoppingOrder order : orders) {
            List<ShoppingProduct> orderItems = orderService.getOrderItems(order.getId());
            for (ShoppingProduct orderItem : orderItems) {
                System.out.println(orderItem);

            }
            System.out.println("-----------------");
//            itemsMap.put(order.getId(), orderService.getOrderItems(order.getId()));
        }
    }

}