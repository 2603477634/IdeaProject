package com.seata.order.service.impl;

import com.seata.order.mapper.OrderMapper;
import com.seata.order.openfeign.StockService;
import com.seata.order.pojo.Order;
import com.seata.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    StockService stockService;

    @GlobalTransactional
    @Override
    public Order create(Order order){
        orderMapper.insert(order);
//        MultiValueMap<String,Object> paramMap  = new LinkedMultiValueMap<>();
//        paramMap.add("productId",order.getProductId());
        String msg =stockService.add(order.getProductId());
//        int a= 1/0;
        return order;
    }



}

