package com.imooc.sell.controller;
/*卖家商品类目*/
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.CategoryForm;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seller/category")
@Slf4j
public class SellerCategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductInfoService productInfoService;


    /*类目列表*/
    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){

        List<ProductCategory> productCategoryList = categoryService.findAll();
        map.put("productCategoryList",productCategoryList);

        return new ModelAndView("category/list",map);

    }

    /*修改*/
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                              @RequestParam(value = "categoryType",required = false) Integer categoryType,
                              Map<String,Object> map){

        List<ProductInfo> productInfoList = productInfoService.findTypeAll(categoryType);

        if(!StringUtils.isEmpty(categoryId) && productInfoList.size() != 0) {

                map.put("msg",ResultEnum.CATEFORY_SAVE_ERROR.getMsg());
                map.put("url","/sell/seller/category/list");
                return new ModelAndView("common/error",map);

            }else if (!StringUtils.isEmpty(categoryId) && productInfoList.size() == 0){
            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("productCategory",productCategory);
            return new ModelAndView("category/index",map);

        }else {

            return new ModelAndView("category/index", map);
        }
    }

    /*保存类目*/
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map){

        if(bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }


        ProductCategory productCategory = new ProductCategory();
        try {

                if(form.getCategoryId()!=null){
                    productCategory = categoryService.findOne(form.getCategoryId());

            }
            BeanUtils.copyProperties(form,productCategory);
            categoryService.save(productCategory);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/category/list");
        return new ModelAndView("common/success",map);
    }


}
