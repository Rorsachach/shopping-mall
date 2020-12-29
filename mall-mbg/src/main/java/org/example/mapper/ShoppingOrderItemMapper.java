package org.example.mapper;

import org.example.model.ShoppingOrderItem;

import java.util.List;

public interface ShoppingOrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingOrderItem record);

    int insertSelective(ShoppingOrderItem record);

    ShoppingOrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingOrderItem record);

    int updateByPrimaryKey(ShoppingOrderItem record);

    List<ShoppingOrderItem> selectByOrderId(Integer id);
}