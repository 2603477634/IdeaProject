package com.seata.order.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "alibaba-stock-seata", path="/stock")
public interface StockService {

    @RequestMapping("/reduct")
    public String add(@RequestParam(value="productId") Integer productId);
}
