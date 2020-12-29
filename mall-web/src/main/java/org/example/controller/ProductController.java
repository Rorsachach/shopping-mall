package org.example.controller;

import org.example.model.ShoppingProduct;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 卑微小冯
 * Date: 2020/12/11 下午4:39
 * Project: shopping-mall
 * Package: org.example.controller
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/product/productdetail/{pid}")
    public String displayProductById(@PathVariable Integer pid, Model model){
        ShoppingProduct shoppingProduct = productService.queryProductById(pid);
        model.addAttribute("product", shoppingProduct);
        return "detail";
    }
}
