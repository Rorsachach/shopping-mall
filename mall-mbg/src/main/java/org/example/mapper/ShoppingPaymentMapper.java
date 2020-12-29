package org.example.mapper;

import org.example.model.ShoppingPayment;

public interface ShoppingPaymentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingPayment record);

    int insertSelective(ShoppingPayment record);

    ShoppingPayment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingPayment record);

    int updateByPrimaryKey(ShoppingPayment record);
}