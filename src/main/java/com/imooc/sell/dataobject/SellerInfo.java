package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class SellerInfo {

    /*卖家id*/
    @Id
    private String sellerId;

    /*卖家用户名*/
    private String username;

    /*卖家用户密码*/
    private  String passwords;

    /*卖家微信openid*/
    private String openid;

}
