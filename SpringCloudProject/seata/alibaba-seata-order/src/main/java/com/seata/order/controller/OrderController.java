package com.seata.order.controller;

import com.seata.order.pojo.Order;
import com.seata.order.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
   @Autowired
   private OrderServiceImpl orderService;

    @RequestMapping("/add")
    public String add(){
        Order order = new Order();
        order.setProductId(9);
        order.setStatus(0);
        order.setTotalAmount(100);
        orderService.create(order);
        return "下单成功";
    }
}
