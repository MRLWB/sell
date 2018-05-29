package com.imooc.sell.enums;

import com.imooc.sell.dataobject.OrderDetail;
import lombok.Getter;

@Getter
public enum  ResultEnum {

    SUCCESS(0,"成功"),

    PARAM_ERROR(1,"参数不正确"),

    PRODUCT_NOT_EXIST(10,"商品不存在"),

    PRODUCT_STOCK_ERROE(11,"商品库存不正确"),

    ORDER_NOT_EXIST(12,"订单不存在"),

    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),

    ORDER_STATUS_ERROR(14,"订单状态错误"),

    ORDER_UPDATE_ERROR(15,"订单更新错误"),

    ORDER_DETIAL_EMPTY(16,"商品不存在"),

    ORDER_PAY_STATUS_ERROR(17,"订单支付不成功"),

    CART_EMPTY(18,"购物车为空"),

    ORDER_OWENER_ERROR(19,"该订单不属于当前用户"),

    ORDER_CANCEL_SUCCESS(20,"订单取消成功"),

    ORDER_FINISH_SUCCESS(21,"订单完成成功"),

    PRODUCT_DOWN_SUCCESS(22,"商品下架成功"),

    PRODUCT_STATUS_ERROR(23,"商品状态错误"),

    PRODUCT_UP_SUCCESS(22,"商品上架成功"),

    CATEFORY_SAVE_ERROR(23,"类目已被使用，不得修改"),

    WECHAT_MP_ERROE(24,"微信授权错误"),

    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(25,"微信支付金额错误"),

    LOGIN_FAIL(26,"登陆失败"),

    LOGOUT_SUCCESS(27,"登出成功")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
