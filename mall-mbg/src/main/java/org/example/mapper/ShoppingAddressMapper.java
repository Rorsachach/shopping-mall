package org.example.mapper;

import org.example.model.ShoppingAddress;

import java.util.List;

public interface ShoppingAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingAddress record);

    int insertSelective(ShoppingAddress record);

    ShoppingAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingAddress record);

    int updateByPrimaryKey(ShoppingAddress record);

    List<ShoppingAddress> selectByMemberId(Integer memberId);
}