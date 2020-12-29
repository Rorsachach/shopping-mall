package org.example.controller;

import io.swagger.models.auth.In;
import org.example.mapper.ShoppingProductMapper;
import org.example.model.ShoppingProduct;
import org.example.model.ShoppingUser;
import org.example.service.UtilsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午8:04
 * Project: shopping-mall
 * Package: org.example.controller
 */
@RestController
@RequestMapping("/utils")
public class UtilsController {

    @Autowired
    private UtilsService utilsService;

    @RequestMapping(value = "/getCount")
    public String getCount(HttpSession session){
        Object user = session.getAttribute("user");
        if (user == null){
            return "0";
        }
        List<ShoppingProduct> products = (List<ShoppingProduct>)session.getAttribute("productList");
        int shoppingCount = 0;
        if(products != null){
            for (ShoppingProduct productObj : products) {
                shoppingCount += productObj.getCount();
            }
        }
        return String.valueOf(shoppingCount);
    }

    @RequestMapping(value = "/getProductNum")
    public String getProductNum(){
        return utilsService.getProductNum().toString();
    }

    @RequestMapping(value = "/setSessionProductList", method = RequestMethod.POST)
    public String setSessionProductList(
            @RequestParam("id") Integer id,
            @RequestParam("status") Boolean status ,
            @RequestParam("count") Integer count,
            HttpSession session
    ){
        System.out.println(id);
        System.out.println(status);
        System.out.println(count);
        List<ShoppingProduct> productList = (List<ShoppingProduct>)session.getAttribute("productList");
        for (ShoppingProduct shoppingProduct : productList) {
            if (shoppingProduct.getId() == id){
                shoppingProduct.setStatus((status==true?1:0));
                shoppingProduct.setCount(count);
            }
        }
        return "success";
    }

    @RequestMapping(value = "/getOrderNum")
    public String getOrderNum(HttpSession session){
        ShoppingUser user = (ShoppingUser)session.getAttribute("user");
        return Integer.toString(utilsService.getOrderNum(user.getId()));
    }
}
