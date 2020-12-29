package org.example.controller;

import org.example.dao.ProductMapper;
import org.example.model.ShoppingProduct;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/11 下午4:21
 * Project: shopping-mall
 * Package: org.example.controller
 */
@Controller
public class IndexPageController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String gotoIndex(Model model){
        List<ShoppingProduct> shoppingProducts = productService.queryShoppingProductIndex();

        model.addAttribute("products" ,shoppingProducts);
        return "index";
    }

    @RequestMapping(value = "/gotologin", method = RequestMethod.GET)
    public String gotoLogin(){
        return "login";
    }

    @RequestMapping(value = "/gotoregister", method = RequestMethod.GET)
    public String gotoRegister(){
        return "register";
    }

    @RequestMapping(value = "/gotolist", method = RequestMethod.GET)
    public String gotoList(Model model){
        return "redirect:/list/";
    }

    @RequestMapping(value = "/gotoMyInfo", method = RequestMethod.GET)
    public String gotoMyInfo(){
        return "idCard";
    }
}
