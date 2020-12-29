package org.example.dao;

import org.example.model.ShoppingProduct;

import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/11 下午4:13
 * Project: shopping-mall
 * Package: org.example.dao
 */

public interface ProductMapper {
    List<ShoppingProduct> queryShoppingProductIndex();

    List<ShoppingProduct> queryAllShoppingProduct();
}
