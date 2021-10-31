package com.seata.order.service;

import com.seata.order.pojo.Order;


public interface OrderService {
    Order create(Order order);
}
