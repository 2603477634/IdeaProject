package com.seata.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.seata.order")
public class StockApplicationClass {
    public static void main(String[] args) {
        SpringApplication.run(StockApplicationClass.class,args);
    }
}
