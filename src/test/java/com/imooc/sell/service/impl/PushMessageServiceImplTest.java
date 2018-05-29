package com.imooc.sell.service.impl;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    PushMessageServiceImpl pushMessageService;

    @Autowired
    OrderService orderService;

    @Test
    public void orderStatus() throws Exception{
        OrderDTO orderDTO = orderService.findOne("15238639045553391430");

        pushMessageService.orderStatus(orderDTO);
    }
}