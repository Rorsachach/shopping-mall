package org.example.service.impl;

import org.example.dao.ListMapper;
import org.example.model.ShoppingProduct;
import org.example.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午6:41
 * Project: shopping-mall
 * Package: org.example.service.impl
 */
@Service("listService")
public class ListServiceImpl implements ListService {

    @Autowired
    private ListMapper listMapper;

    @Override
    public List<ShoppingProduct> selectByPage(int start, int length) {
        return listMapper.selectByPage(start, length);
    }
}
