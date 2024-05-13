package com.myboy.service.impl;

import com.myboy.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Map<String, Integer> getById(Long id) {
        log.info("缓存刷新 getById");
        return Map.of("aaa", 111);
    }
}
