package com.seata.order.controller;

import com.seata.order.service.impl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
   StockServiceImpl stockService;

    @RequestMapping("/reduct")
    public String add(@RequestParam(value="productId") Integer productId){
        Integer b = productId;
        stockService.reduct(productId);
        return "扣减库存";
    }
}
