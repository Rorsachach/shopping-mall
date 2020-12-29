package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.model.ShoppingProduct;

import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午7:16
 * Project: shopping-mall
 * Package: org.example.dao
 */

public interface ListMapper {
    public List<ShoppingProduct> selectByPage(@Param("start")int start, @Param("length")int length);
}
