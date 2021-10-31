package com.seata.order.service.impl;

import com.seata.order.mapper.OrderMapper;
import com.seata.order.pojo.Order;
import com.seata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    RestTemplate restTemplate;

    @Transactional
    @Override
    public Order create(Order order){
        orderMapper.insert(order);
        MultiValueMap<String,Object> paramMap  = new LinkedMultiValueMap<>();
        paramMap.add("productId",order.getProductId());
        String msg = restTemplate.postForObject("http://127.0.0.1:8096/stock/reduct",paramMap,String.class);
//        int a= 1/0;
        return order;
    }



}

