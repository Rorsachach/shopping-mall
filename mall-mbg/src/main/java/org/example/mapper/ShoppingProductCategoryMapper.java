package org.example.mapper;

import org.example.model.ShoppingProductCategory;

import java.util.List;

public interface ShoppingProductCategoryMapper {
    List<ShoppingProductCategory> selectShoppingProductCategoryall();

    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingProductCategory record);

    int insertSelective(ShoppingProductCategory record);

    ShoppingProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingProductCategory record);

    int updateByPrimaryKey(ShoppingProductCategory record);
}