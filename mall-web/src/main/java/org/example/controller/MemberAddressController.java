package org.example.controller;

import org.example.model.ShoppingAddress;
import org.example.model.ShoppingUser;
import org.example.service.MemberAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午4:01
 * Project: shopping-mall
 * Package: org.example.controller
 */

@Controller
public class MemberAddressController {
    @Autowired
    private MemberAddressService memberAddressService;

    @RequestMapping(value = "/createaddress", method = RequestMethod.POST)
    public String createMemberAddress(ShoppingAddress shoppingAddress, HttpSession session){
        Object user = session.getAttribute("user");
        if (user == null){
            return "login";
        }

        shoppingAddress.setMemberId(((ShoppingUser)user).getId());

        memberAddressService.createMemberAddress(shoppingAddress);
        return "redirect:/usercenter";
    }

    @RequestMapping(value = "/usercenter", method = RequestMethod.GET)
    public String gotoMemberAddress(HttpSession session, Model model) {
        return "redirect:orders/inputaddress";
    }
}
