package org.example.service;

import org.example.model.ShoppingAddress;

import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午4:01
 * Project: shopping-mall
 * Package: org.example.service
 */

public interface MemberAddressService {
    public void createMemberAddress(ShoppingAddress address);

    public List<ShoppingAddress> getAllMemberAddresses(Integer id);
}
