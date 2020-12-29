package org.example.controller;

import org.example.model.ShoppingUser;
import org.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author: 卑微小冯
 * Date: 2020/12/11 下午4:45
 * Project: shopping-mall
 * Package: org.example.controller
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addMember(ShoppingUser shoppingUser, Model model){
        if(memberService.validateUser(shoppingUser.getUsername()) == null){
            memberService.createMember(shoppingUser);
            return "login";
        } else {
            model.addAttribute("msg", "用户名已存在");
            return "register";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validateUser(String username, String pwd, Model model, HttpSession session){
        ShoppingUser shoppingUser = memberService.validateUser(username);
        if(shoppingUser != null){
            if (pwd.equals(shoppingUser.getPassword())){
                session.setAttribute("user", shoppingUser);
                return "redirect:/index";
            }else {
                model.addAttribute("msg", "密码不正确");
                return "login";
            }
        }else {
            model.addAttribute("msg", "用户名不存在");
            return "login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String invalidateUser(HttpSession session){
        System.out.println("this is running");
        session.invalidate();
        return "redirect:/index";
    }
}
