package org.example.service;

import org.example.model.ShoppingUser;

/**
 * @author: 卑微小冯
 * Date: 2020/12/11 下午4:10
 * Project: shopping-mall
 * Package: org.example.service
 */

public interface MemberService {
    public void createMember(ShoppingUser shoppingUser);

    public ShoppingUser validateUser(String username);
}
