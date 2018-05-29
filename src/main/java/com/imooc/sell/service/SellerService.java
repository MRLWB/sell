package com.imooc.sell.service;

import com.imooc.sell.dataobject.SellerInfo;

/*卖家端*/
public interface SellerService {

    /*查询卖家信息*/
    SellerInfo findSellerInfoByOpenid(String openid);
    /*修改卖家信息*/


}
