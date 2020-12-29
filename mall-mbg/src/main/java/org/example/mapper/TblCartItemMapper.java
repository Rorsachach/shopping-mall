package org.example.mapper;

import org.example.model.TblCartItem;

public interface TblCartItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TblCartItem record);

    int insertSelective(TblCartItem record);

    TblCartItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TblCartItem record);

    int updateByPrimaryKey(TblCartItem record);
}