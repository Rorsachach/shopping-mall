package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.example.model.ShoppingProduct;
import org.example.service.ListService;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午5:36
 * Project: shopping-mall
 * Package: org.example.controller
 */

@Controller
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ListService listService;

    @RequestMapping(value = "/{page}/{length}", method = RequestMethod.GET)
    public String getAll(@PathVariable Integer page, @PathVariable Integer length, Model model){
        int start = (page-1)*length;
        List<ShoppingProduct> productList = listService.selectByPage(start, length);
        model.addAttribute("products", productList);
        return "list";
    }
}
