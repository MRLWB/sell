package com.imooc.sell.constant;

/*Redis常量*/
public interface RedisConstant {

    /*存储的key是以token_开头*/
    String TOKEN_PREFIX = "token_%s";

    /*token存储时间*/
    Integer EXPIRE = 7200; //2小时
}
