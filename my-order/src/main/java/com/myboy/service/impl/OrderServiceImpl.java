package com.myboy.service.impl;

import com.myboy.domain.entity.MyOrderEntity;
import com.myboy.mapper.OrderMapper;
import com.myboy.service.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Map<String, Integer> getById(Long id) {
        log.info("缓存刷新 getById");
        return Map.of("aaa", 111);
    }

    @Override
    public void addOrder(String orderSn) {
//        MyOrderEntity myOrderEntity = new MyOrderEntity();
//        myOrderEntity.setOrderSn(orderSn);
//        orderMapper.insert(myOrderEntity);
        orderMapper.add(orderSn);
    }
}
