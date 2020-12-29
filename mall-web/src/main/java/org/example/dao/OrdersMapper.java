package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.model.ShoppingOrder;
import org.example.model.ShoppingOrderItem;

import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午4:52
 * Project: shopping-mall
 * Package: org.example.dao
 */

public interface OrdersMapper {
    int insert(ShoppingOrder record);

    int insertOrderItem(ShoppingOrderItem record);

    List<ShoppingOrder> selectOrdersByMID(@Param("id") Integer id);

    List<ShoppingOrder> selectOrdersByPage(@Param("id") Integer id, @Param("start") Integer start, @Param("length") Integer length);

    int getOrderNum(Integer id);
}
