package com.seata.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.seata.order.mapper.StockMapper;
import com.seata.order.service.StockService;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockMapper stockMapper;
    @Autowired
    RestTemplate restTemplate;

    @Transactional
    @Override
    public void reduct(Integer productId){
        System.out.println("sdsdsd");
        stockMapper.update(productId);
//        int a = 1/0;
    }



}

