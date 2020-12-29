package org.example.mapper;

import org.example.model.ShoppingUser;

public interface ShoppingUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingUser record);

    int insertSelective(ShoppingUser record);

    ShoppingUser selectByPrimaryKey(Integer id);

    ShoppingUser selectByUserName(String username);

    int updateByPrimaryKeySelective(ShoppingUser record);

    int updateByPrimaryKey(ShoppingUser record);
}