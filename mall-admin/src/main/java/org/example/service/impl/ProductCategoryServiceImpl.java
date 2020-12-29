package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import org.example.mapper.ShoppingProductCategoryMapper;
import org.example.model.ShoppingProductCategory;
import org.example.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务逻辑层实现子类--商品分类
 */
@Service
public class ProductCategoryServiceImpl
   implements ProductCategoryService {

    @Autowired
    private ShoppingProductCategoryMapper productCategoryMapper;

    @Override
    public List<ShoppingProductCategory> listAllProductCategory() {
        return productCategoryMapper.selectShoppingProductCategoryall();
    }

    @Override
    public int createProductCategory(ShoppingProductCategory category) {
        return productCategoryMapper.insertSelective(category);
    }

    @Override
    public int updateProductCategory(ShoppingProductCategory category) {
        return productCategoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public int deleteProductCategory(Integer id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<ShoppingProductCategory> listProductCategory(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return productCategoryMapper.selectShoppingProductCategoryall();
    }

    @Override
    public ShoppingProductCategory getProductCategory(Integer id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }
}
