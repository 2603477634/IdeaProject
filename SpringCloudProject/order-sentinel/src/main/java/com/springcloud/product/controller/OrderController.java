package com.springcloud.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {


    @RequestMapping("/add")
    public String add(){
        System.out.println("下单成功");
        return "Hello World";
    }
    @RequestMapping("/flow")
    public String flow(){
        System.out.println("下单成功2222");
        return "Hello World";
    }
}
