package com.seata.order.mapper;

import com.seata.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

     void insert(Order order);
}
