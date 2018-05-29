package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/*微信消息推送*/
public interface PushMessageService {

    /*订单状态变更消息*/
    void orderStatus(OrderDTO orderDTO);
}
