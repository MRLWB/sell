package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoImplTest {

    private static final String oprind="abc";

    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    public void findSellerInfoByOpenid() throws Exception{

        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(oprind);
        Assert.assertEquals(oprind,sellerInfo.getOpenid());

    }
}