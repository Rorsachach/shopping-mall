package org.example.controller;

import io.swagger.models.auth.In;
import org.example.model.*;
import org.example.service.MemberAddressService;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午4:52
 * Project: shopping-mall
 * Package: org.example.controller
 */

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private MemberAddressService memberAddressService;

    @RequestMapping(value="/orderpage",method = RequestMethod.GET)
    public String orderPage(Integer[] selectedpid, HttpSession session, Model model){
        Object user = session.getAttribute("user");
        if (user == null){
            return "login";
        }
        for (Integer id : selectedpid) {
            System.out.println(id);
        }
        List<ShoppingProduct> productList = orderService.queryProductByIds(selectedpid);
        List<ShoppingProduct> sessionProducts = (List<ShoppingProduct>)session.getAttribute("productList");
        for (ShoppingProduct shoppingProduct : productList) {
            for (ShoppingProduct sessionProduct : sessionProducts) {
                if (shoppingProduct.getId() == sessionProduct.getId()){
                    shoppingProduct.setCount(sessionProduct.getCount());
                }
            }
        }

        double totalMoney = 0.0;
        double totalCount = 0;

        for (ShoppingProduct product : productList) {
            totalMoney += product.getCount()*product.getPrice();
            totalCount += product.getCount();
        }

        List<ShoppingAddress> addresses = memberAddressService.getAllMemberAddresses(((ShoppingUser) user).getId());
        if(session.getAttribute("defaultAddress") == null){
            session.setAttribute("defaultAddress", addresses.get(0));
        }

        model.addAttribute("productList", productList);
        model.addAttribute("totalMoney", new DecimalFormat().format(totalMoney));
        model.addAttribute("totalCount", new DecimalFormat().format(totalCount));
        model.addAttribute("addresses", addresses);
        return "place_order";
    }

    @RequestMapping(value="/myorder",method = RequestMethod.GET)
    public String myOrder(Integer[] selectedpid, HttpSession session, Model model){
        if (selectedpid != null){
            //1.根据商品编号获取商品信息
            List<ShoppingProduct> shoppingProductList =
                    orderService.queryProductByIds(selectedpid);
            //2.添加订单（用户地址设置默认值，支付方式设置为默认值，后续完善此功能）
            //2.1 添加订单明细
            //2.2 获取当前登录用户的编号
            ShoppingUser user=(ShoppingUser)session.getAttribute("user");
            ShoppingAddress address = (ShoppingAddress)session.getAttribute("defaultAddress");
            int paymentid = selectedpid[selectedpid.length - 1];

            //3.调用业务逻辑层中的添加方法
            orderService.createOrders(user.getId(), address.getId(), paymentid, shoppingProductList);
            session.removeAttribute("productList");
        }


        return "redirect:gotomyorder/1/3";
    }

    @RequestMapping(value = "/gotomyorder/{page}/{length}", method = RequestMethod.GET)
    public String gotoMyOrder(@PathVariable Integer page, @PathVariable Integer length, HttpSession session, Model model){
        ShoppingUser user=(ShoppingUser) (session.getAttribute("user"));
        if (user == null){
            return "login";
        }
        int start = (page-1)*length;
        List<ShoppingOrder> orders = orderService.getOrdersByPage(user.getId(), start, length);

        Map<Integer, List<ShoppingProduct>> itemsMap = new HashMap<>();
        for (ShoppingOrder order : orders) {
            itemsMap.put(order.getId(), orderService.getOrderItems(order.getId()));
        }


        model.addAttribute("orders", orders);
        model.addAttribute("orderMap", itemsMap);

        return "user_center_order";
    }


    /**
     * 编辑用户收货地址
     * @return
     */
    @RequestMapping(value="/inputaddress",method = RequestMethod.GET)
    public String inputAddresspage(HttpSession session, Model model){
        Object user = session.getAttribute("user");
        if (user == null){
            return "login";
        }

        List<ShoppingAddress> addresses = memberAddressService.getAllMemberAddresses(((ShoppingUser) user).getId());
        if(session.getAttribute("defaultAddress") == null){
            session.setAttribute("defaultAddress", addresses.get(0));
        }
        model.addAttribute("addresses", addresses);
        return "user_center_site";

    }

    @RequestMapping(value = "/DefaultAddress/{id}", method = RequestMethod.GET)
    public String changeDefaultAddress(@PathVariable Integer id, HttpSession session, Model model){
        Object user = session.getAttribute("user");
        if (user == null){
            return "login";
        }

        List<ShoppingAddress> addresses = memberAddressService.getAllMemberAddresses(((ShoppingUser) user).getId());
        for (ShoppingAddress address : addresses) {
            if (address.getId() == (int)id){
                session.setAttribute("defaultAddress", address);
                break;
            }
        }
        System.out.println(((ShoppingAddress)session.getAttribute("defaultAddress")).getId());

        model.addAttribute("addresses", addresses);
        return "user_center_site";
    }

    @RequestMapping(value = "/gotomyinfo", method = RequestMethod.GET)
    public String gotoMyInfo(HttpSession session, Model model){
        ShoppingUser user=(ShoppingUser) (session.getAttribute("user"));
        if (user == null){
            return "login";
        }
        model.addAttribute("user", user);
        return "user_center_info";
    }
}
