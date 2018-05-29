package com.imooc.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /*公众平台ID*/
    private String mpAppId;

    /*公众平台密钥*/
    private String mpAppSecret;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 商户密钥
     */
    private String mchKey;

    /**
     * 商户证书路径
     */
    private String keyPath;

    /**
     * 微信支付异步通知地址
     * 若不填无法发起支付
     */
    private String notifyUrl;

    /*开放平台ID*/
    private String openAppId;

    /*开放平台密钥*/
    private String openAppSerect;

    /*推送模板ID*/
    private Map<String,String> templateId;

}
