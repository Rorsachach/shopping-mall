package org.example.service;

import org.example.model.ShoppingProductCategory;

import java.util.List;

/**
 * 业务逻辑层--商品分类操作
 */
public interface ProductCategoryService {

    /**
     * 查询所有商品分类
     * @return
     */
    public List<ShoppingProductCategory> listAllProductCategory();

    /**
     * 添加商品分类
     * @param category
     * @return
     */
    public int createProductCategory(ShoppingProductCategory category);

    /**
     * 根据商品编号修改商品信息
     * @param category
     * @return
     */
    public int updateProductCategory(ShoppingProductCategory category);

    /**
     * 根据商品编号删除商品信息
     * @param id
     * @return
     */
    public int deleteProductCategory(Integer id);

    /**
     * 分页查询商品分类信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<ShoppingProductCategory> listProductCategory(int pageNum, int pageSize);

    /**
     * 根据商品分类编号获取商品分类信息
     * @param id
     * @return
     */
    public ShoppingProductCategory getProductCategory(Integer id);
}
