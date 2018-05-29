package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {

    /*查询所有在架的商品列表*/
    List<ProductInfo> findUpAll();


    /*Pageable 分页查询*/
    Page<ProductInfo> findAll(Pageable pageable);

    // List<ProductInfo> findByProductStatus(Integer productStatus);

    ProductInfo save(ProductInfo productInfo);

    ProductInfo findOne(String productId);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void deceaseStock(List<CartDTO> cartDtoList);

    //商品上架
    ProductInfo onsale(String productId);

    //商品下架
    ProductInfo offsale(String productId);

    //按type查询
    List<ProductInfo> findTypeAll(Integer categoryType);

}
