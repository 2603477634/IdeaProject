package com.springcloud.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    String port;


    @RequestMapping("/{id}")
    public String get(@PathVariable Integer id){
        System.out.println("select product"+id);
        return "select product"+id+":"+port;
    }
}
