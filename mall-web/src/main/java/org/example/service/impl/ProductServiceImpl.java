package org.example.service.impl;

import org.example.dao.ProductMapper;
import org.example.mapper.ShoppingProductMapper;
import org.example.model.ShoppingProduct;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/11 下午4:12
 * Project: shopping-mall
 * Package: org.example.service.impl
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ShoppingProductMapper shoppingProductMapper;

    @Override
    public List<ShoppingProduct> queryShoppingProductIndex() {
        return productMapper.queryShoppingProductIndex();
    }

    @Override
    public ShoppingProduct queryProductById(Integer productId) {
        return shoppingProductMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<ShoppingProduct> queryAllShoppingProduct() {
        return productMapper.queryAllShoppingProduct();
    }
}
