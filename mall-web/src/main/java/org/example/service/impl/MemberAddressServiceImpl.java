package org.example.service.impl;

import org.example.mapper.ShoppingAddressMapper;
import org.example.model.ShoppingAddress;
import org.example.service.MemberAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午4:02
 * Project: shopping-mall
 * Package: org.example.service.impl
 */

@Service
public class MemberAddressServiceImpl implements MemberAddressService {

    @Autowired
    private ShoppingAddressMapper shoppingAddressMapper;

    @Override
    public void createMemberAddress(ShoppingAddress address) {
        shoppingAddressMapper.insert(address);
    }

    @Override
    public List<ShoppingAddress> getAllMemberAddresses(Integer id) {
        return shoppingAddressMapper.selectByMemberId(id);
    }
}
