package com.imooc.sell.service.impl;

import com.imooc.sell.dao.SellerInfoDao;
import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao dao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {

        SellerInfo sellerInfo = dao.findByOpenid(openid);
        return sellerInfo;
    }
}
