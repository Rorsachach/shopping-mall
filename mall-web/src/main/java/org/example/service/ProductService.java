package org.example.service;

import org.example.model.ShoppingProduct;

import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/11 下午4:07
 * Project: shopping-mall
 * Package: org.example.service
 */

public interface ProductService {
    public List<ShoppingProduct> queryShoppingProductIndex();

    public ShoppingProduct queryProductById(Integer productId);

    public List<ShoppingProduct> queryAllShoppingProduct();
}
