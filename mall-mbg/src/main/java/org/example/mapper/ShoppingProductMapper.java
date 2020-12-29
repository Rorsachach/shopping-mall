package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.model.ShoppingProduct;

import java.util.List;

public interface ShoppingProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingProduct record);

    int insertSelective(ShoppingProduct record);

    ShoppingProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingProduct record);

    int updateByPrimaryKey(ShoppingProduct record);

    List<ShoppingProduct> selectShoppingProductByIds(@Param("array") Integer[] productIds);

    int getProductNum();
}