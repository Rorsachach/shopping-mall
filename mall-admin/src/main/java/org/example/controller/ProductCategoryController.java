package org.example.controller;

import org.example.common.api.CommonPage;
import org.example.common.api.CommonResult;
import org.example.model.ShoppingProductCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端控制器--商品分类操作
 */
@Api(tags = "ProductCategoryController",
        description = "商品分类管理" )
@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;


    @ApiOperation("查询所有商品分类信息")
    @RequestMapping(value="/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ShoppingProductCategory>>
    getProductCategoryList(){
        List<ShoppingProductCategory> values =
                productCategoryService.listAllProductCategory();
        return new CommonResult(200,
                "success",values);

    }

    @ApiOperation("添加商品分类")
    @RequestMapping(value="/create",method=RequestMethod.POST)
    @ResponseBody
    public CommonResult createproductCategory(
            @RequestBody ShoppingProductCategory shoppingProductCategory){
        CommonResult commonResult = null;
        //访问业务逻辑层中的添加方法
        int count =
        productCategoryService
                .createProductCategory(shoppingProductCategory);
        if(count ==1){
            commonResult = CommonResult.success(shoppingProductCategory);
        }else{
            commonResult = CommonResult.failed("添加失败！");
        }
        return commonResult;
    }

    @ApiOperation("修改商品分类信息")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateProductCategory(
            @RequestBody ShoppingProductCategory shoppingProductCategory){
        CommonResult commonResult = null;
        int count =
        productCategoryService.updateProductCategory(shoppingProductCategory);
        if(count ==1){
            commonResult = CommonResult.success(shoppingProductCategory);
        }else{
            commonResult = CommonResult.failed("操作失败!");
        }
        return commonResult;
    }

    @ApiOperation("删除商品分类信息")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteShoppingProductCategory(@PathVariable("id") Integer id){
        CommonResult commonResult = null;
        int count =
        productCategoryService.deleteProductCategory(id);
        if(count ==1){
            return CommonResult.success("操作成功");
        }else{
            return CommonResult.failed("删除失败！");
        }

    }

    @ApiOperation("分页查询商品分类列表")
    @RequestMapping(value = "/listbypage",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ShoppingProductCategory>>
       listProductCategory(@RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                           @RequestParam(value="pageSize",defaultValue = "3") Integer pageSize){

        List<ShoppingProductCategory> shoppingProductCategoriesList=
        productCategoryService.listProductCategory(pageNum,pageSize);

        return CommonResult.success(CommonPage.restPage(shoppingProductCategoriesList));
    }

    @ApiOperation("获取指定ID的商品分类信息")
    @RequestMapping(value="/getcategroybyid/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ShoppingProductCategory> productCategoryById(@PathVariable Integer id){
        ShoppingProductCategory shoppingProductCategory =
        productCategoryService.getProductCategory(id);
        return CommonResult.success(shoppingProductCategory);

    }



}
