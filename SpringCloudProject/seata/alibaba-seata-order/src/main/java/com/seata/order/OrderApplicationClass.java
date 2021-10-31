package com.seata.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.seata.order")
@EnableTransactionManagement
@EnableFeignClients
public class OrderApplicationClass {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationClass.class,args);
    }
}
