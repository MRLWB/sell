package com.imooc.sell.form;
/*表单参数对象 验证*/
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class OrderForm {

    /*买家姓名*/
    @NotEmpty(message = "姓名必添")
    private String name;

    /*买家电话*/
    @NotEmpty(message = "电话必填")
    private String phone;

    /*买家地址*/
    @NotEmpty(message = "地址必填")
    private String address;

    /*买家openid*/
    @NotEmpty(message = "opendid必填")
    private String openid;

    /*购物车*/
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
