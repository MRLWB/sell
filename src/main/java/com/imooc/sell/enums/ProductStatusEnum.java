package com.imooc.sell.enums;
/*商品上下架状态枚举*/
import com.sun.xml.internal.fastinfoset.sax.SAXDocumentSerializerWithPrefixMapping;
import lombok.Getter;

import java.security.UnresolvedPermission;

@Getter
public enum ProductStatusEnum implements CodeEnum{

    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
