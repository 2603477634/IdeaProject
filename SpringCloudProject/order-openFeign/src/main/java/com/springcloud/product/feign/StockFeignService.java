package com.springcloud.product.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="stock-service",path = "/stock",qualifier = "stockFeignService")
public interface StockFeignService {

    @RequestMapping("/reduct")
    public String reduct();

}
