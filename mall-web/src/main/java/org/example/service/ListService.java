package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.model.ShoppingProduct;

import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/12/20 下午6:40
 * Project: shopping-mall
 * Package: org.example.service
 */

public interface ListService {
    List<ShoppingProduct> selectByPage(int start, int length);
}
