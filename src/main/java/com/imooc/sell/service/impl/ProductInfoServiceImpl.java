package com.imooc.sell.service.impl;

import com.imooc.sell.dao.ProductInfoDao;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ProductInfoServiceImpl implements ProductInfoService{

    @Autowired
    ProductInfoDao dao;

    @Override
    public List<ProductInfo> findUpAll() {
        return dao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return dao.save(productInfo);
    }

    @Override
    public ProductInfo findOne(String productId) {
        return dao.findOne(productId);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = dao.findOne(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            dao.save(productInfo);
        }



    }

    @Override
    @Transactional
    public void deceaseStock(List<CartDTO> cartDtoList) {

        for (CartDTO cartDTO : cartDtoList){
            ProductInfo productInfo = dao.findOne(cartDTO.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROE);
            }

            productInfo.setProductStock(result);
            dao.save(productInfo);
        }
    }

    @Override
    public ProductInfo onsale(String productId) {

        ProductInfo productInfo = dao.findOne(productId);
        if(productInfo == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if(productInfo.getProductStatus() == 0){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(0);
        dao.save(productInfo);

        return productInfo;
    }

    @Override
    public ProductInfo offsale(String productId) {

        ProductInfo productInfo = dao.findOne(productId);
        if(productInfo == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if(productInfo.getProductStatus() == 1){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(1);
        dao.save(productInfo);

        return productInfo;
    }

    @Override
    public List<ProductInfo> findTypeAll(Integer categoryType) {
        return dao.findByCategoryType(categoryType);
    }
}
