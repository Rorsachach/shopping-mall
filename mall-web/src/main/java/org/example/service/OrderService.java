package org.example.service;

import org.example.model.ShoppingOrder;
import org.example.model.ShoppingOrderItem;
import org.example.model.ShoppingProduct;

import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午4:53
 * Project: shopping-mall
 * Package: org.example.service
 */

public interface OrderService {
    public List<ShoppingProduct> queryProductByIds(Integer[] productIds);

    public void createOrders(Integer memberId, Integer addressId, Integer paymentId, List<ShoppingProduct> shoppingProductList);

    public List<ShoppingOrder> getOrders(Integer id);

    public List<ShoppingOrder> getOrdersByPage(Integer id, Integer start, Integer length);

    public List<ShoppingProduct> getOrderItems(Integer id);
}
