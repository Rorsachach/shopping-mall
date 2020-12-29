package org.example.service.impl;

import org.example.dao.OrdersMapper;
import org.example.mapper.ShoppingProductMapper;
import org.example.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午8:39
 * Project: shopping-mall
 * Package: org.example.service.impl
 */
@Service
public class UtilsServiceImpl implements UtilsService {

    @Autowired
    private ShoppingProductMapper shoppingProductMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Integer getProductNum() {
        return shoppingProductMapper.getProductNum();
    }

    @Override
    public Integer getOrderNum(Integer id) {
        return ordersMapper.getOrderNum(id);
    }


}
