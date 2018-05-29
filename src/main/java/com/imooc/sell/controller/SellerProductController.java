package com.imooc.sell.controller;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.ProductForm;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductInfoService;
import com.imooc.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Page;

import javax.validation.Valid;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;
    /*查询商品*/
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page" , defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){

        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(pageRequest);
        map.put("productInfoPage",productInfoPage);
        map.put("currentpage",page);
        map.put("size",size);

        return new ModelAndView("product/list",map);

    }

    /*下架商品*/
    @GetMapping("/down")
    public ModelAndView Down(@RequestParam("productId") String productId,
                                  Map<String,Object> map){
        try {
            productInfoService.offsale(productId);

        }catch (SellException e){
            log.error("【卖家商品查询】result={}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.PRODUCT_DOWN_SUCCESS.getMsg());
        map.put("url","/sell/seller/product/list");

        return new ModelAndView("common/success",map);
    }

    /*上架商品*/
    @GetMapping("/up")
    public ModelAndView UP(@RequestParam("productId") String productId,
                           Map<String,Object> map){

        try {
            productInfoService.onsale(productId);

        }catch (SellException e){
            log.error("【卖家商品查询】result={}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.PRODUCT_UP_SUCCESS.getMsg());
        map.put("url","/sell/seller/product/list");

        return new ModelAndView("common/success",map);

    }

    /*修改,新增商品*/
    @GetMapping("/index")
    public ModelAndView index (@RequestParam(value="productId",required = false) String productId,

                       Map<String,Object> map){

        if(!StringUtils.isEmpty(productId)){
            ProductInfo productInfo = productInfoService.findOne(productId);
            map.put("productInfo",productInfo);
        }

        //查询所有的类目
        List<ProductCategory> productCategoryList = categoryService.findAll();
        map.put("productCategoryList",productCategoryList);
        return new ModelAndView("product/index",map);
    }

    /*保存/更新
    商品*/
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("uel","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
            if(!StringUtils.isEmpty(form.getProductId())){
                productInfo = productInfoService.findOne(form.getProductId());
            }else{
                form.setProductId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(form,productInfo);
            productInfoService.save(productInfo);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("uel","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

}


