package org.example.service.impl;

import org.example.mapper.ShoppingUserMapper;
import org.example.model.ShoppingUser;
import org.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 卑微小冯
 * Date: 2020/12/11 下午4:11
 * Project: shopping-mall
 * Package: org.example.service.impl
 */

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private ShoppingUserMapper shoppingUserMapper;

    @Override
    public void createMember(ShoppingUser shoppingUser) {
        shoppingUserMapper.insert(shoppingUser);
    }

    @Override
    public ShoppingUser validateUser(String username) {
        return shoppingUserMapper.selectByUserName(username);
    }
}
