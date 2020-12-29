package org.example.controller;

import org.example.model.ShoppingProduct;
import org.example.model.ShoppingUser;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/11 下午4:57
 * Project: shopping-mall
 * Package: org.example.controller
 */

@Controller
@RequestMapping("/cart")
public class CarController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{productid}/{productCount}", method = RequestMethod.GET)
    public String addCarPage(@PathVariable Integer productid, @PathVariable Integer productCount, HttpSession session, Model model){
        Object user = session.getAttribute("user");
        if (user == null){
            return "login";
        }

        List<ShoppingProduct> productList = null;

        ShoppingProduct product = productService.queryProductById(productid);

        product.setCount(productCount);
        Object obj = session.getAttribute("productList");
        if (obj == null){
            productList = new ArrayList<ShoppingProduct>();
        } else {
            productList = (List<ShoppingProduct>)obj;
        }


        int index = -1;
        if((index = isExist(productList, product.getId()))!=-1){
            productList.get(index).setCount(productList.get(index).getCount()+product.getCount());
        }else {
            productList.add(product);
        }

        double totalMoney = 0.0;
        int shoppingCount = 0;

        for (ShoppingProduct productObj : productList) {
            totalMoney += productObj.getCount()*productObj.getPrice();
            shoppingCount += productObj.getCount();
        }

        session.setAttribute("productList", productList);
        model.addAttribute("totalmoney", new DecimalFormat().format(totalMoney));
        model.addAttribute("shoppingcount", shoppingCount);

        return "cart";
    }

    @RequestMapping(value="/del/{productid}",method = RequestMethod.GET)
    public String delProductFromCart(@PathVariable Integer productid, HttpSession session, Model model){
        Object user = session.getAttribute("user");
        if(user == null){
            return "login";
        }

        List<ShoppingProduct> productList = (List<ShoppingProduct>)session.getAttribute("productList");
        for (ShoppingProduct product : productList) {
            if (product.getId() == productid){
                productList.remove(product);
                break;
            }
        }

        //4.统计购买商品的总金额
        double totalMoney = 0.0;
        //统计购买商品的总数量
        int shoppingCount = 0;

        for(ShoppingProduct productobj : productList){
            totalMoney += productobj.getCount() * productobj.getPrice();
            shoppingCount += productobj.getCount();
        }
        session.setAttribute("productList", productList);
        model.addAttribute("totalmoney", totalMoney);
        model.addAttribute("shoppingcount", shoppingCount);

        return "cart";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoCarPage(HttpSession session, Model model){
        Object user = session.getAttribute("user");
        if (user == null){
            return "login";
        }

        List<ShoppingProduct> productList = null;

        Object obj = session.getAttribute("productList");
        if (obj == null){
            productList = new ArrayList<ShoppingProduct>();
        } else {
            productList = (List<ShoppingProduct>)obj;
        }

        double totalMoney = 0.0;
        int shoppingCount = 0;

        for (ShoppingProduct productObj : productList) {
            totalMoney += productObj.getCount()*productObj.getPrice();
            shoppingCount += productObj.getCount();
        }

        session.setAttribute("productList", productList);
        model.addAttribute("totalmoney", totalMoney);
        model.addAttribute("shoppingcount", shoppingCount);

        return "cart";
    }

    private int isExist(List<ShoppingProduct> list, int id){
        for (ShoppingProduct product : list) {
            if (product.getId() == id)
                return list.indexOf(product);
        }
        return -1;
    }
}
