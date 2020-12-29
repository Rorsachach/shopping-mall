package org.example.service.impl;

import org.example.dao.OrdersMapper;
import org.example.dao.ProductMapper;
import org.example.mapper.ShoppingAddressMapper;
import org.example.mapper.ShoppingOrderItemMapper;
import org.example.mapper.ShoppingProductMapper;
import org.example.model.ShoppingOrder;
import org.example.model.ShoppingOrderItem;
import org.example.model.ShoppingProduct;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午4:56
 * Project: shopping-mall
 * Package: org.example.service.impl
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ShoppingProductMapper shoppingProductMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private ShoppingOrderItemMapper shoppingOrderItemMapper;

    @Override
    public List<ShoppingProduct> queryProductByIds(Integer[] productIds) {
        return shoppingProductMapper.selectShoppingProductByIds(productIds);
    }

    @Override
    public void createOrders(Integer memberId, Integer addressId, Integer paymentId, List<ShoppingProduct> shoppingProductList) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
        //1.创建订单对象
        ShoppingOrder shoppingOrder = new ShoppingOrder();
        shoppingOrder.setMemberId(memberId);
        shoppingOrder.setPaymentId(1);
        shoppingOrder.setAddressId(1);
        shoppingOrder.setCode(sf.format(new Date()));
        //2.调用数据库访问层的添加订单方法
        ordersMapper.insert(shoppingOrder);
        //2.1 获取订单编号
        Integer orderId = shoppingOrder.getId();
        //3.创建订单明细对象
        //4.调用数据库访问层的添加订单明细的方法
        for(ShoppingProduct product : shoppingProductList){
            ShoppingOrderItem orderItemObj =
                    new ShoppingOrderItem();
            orderItemObj.setOrderId(orderId);
            orderItemObj.setProductId(product.getId());
            orderItemObj.setBuycount(product.getCount());
            orderItemObj.setSubMoney(product.getPrice()) ; //商品单价
            ordersMapper.insertOrderItem(orderItemObj);
        }
    }

    @Override
    public List<ShoppingOrder> getOrders(Integer id) {
        return ordersMapper.selectOrdersByMID(id);
    }

    @Override
    public List<ShoppingOrder> getOrdersByPage(Integer id, Integer start, Integer length) {
        return ordersMapper.selectOrdersByPage(id, start, length);
    }

    @Override
    public List<ShoppingProduct> getOrderItems(Integer id) {
        List<ShoppingOrderItem> shoppingOrderItems = shoppingOrderItemMapper.selectByOrderId(id);
        List<ShoppingProduct> productList = new ArrayList<>();
        for (ShoppingOrderItem shoppingOrderItem : shoppingOrderItems) {
            System.out.println(shoppingOrderItem);
            ShoppingProduct shoppingProduct = shoppingProductMapper.selectByPrimaryKey(shoppingOrderItem.getProductId());
            productList.add(shoppingProduct);
        }
        return productList;
    }
}
