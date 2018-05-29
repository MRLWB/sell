package com.imooc.sell.VO;
/*商品（包含类目）视图对象*/
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {

    /*返回给前端显示name*/
    @JsonProperty("name")
    private  String categoryName;

    @JsonProperty("type")
    private Integer categorytype;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
