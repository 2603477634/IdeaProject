package com.springcloud.product.controller;

import com.springcloud.product.feign.ProductFeignService;
import com.springcloud.product.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    ProductFeignService productFeignService;
    @Autowired
    StockFeignService stockFeignService;

    @RequestMapping("/add")
    public String add(){
        System.out.println("下单成功");
        String msg = stockFeignService.reduct();
        String product = productFeignService.get(1);
        return "Hello World"+msg+">>>"+product;
    }
}
