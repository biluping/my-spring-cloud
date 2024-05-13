package com.myboy.feign;

import java.util.Map;

class OrderFeignFallback implements OrderFeign {

    @Override
    public Map<String, Object> add(Map<String, Integer> map) {
        return Map.of("降级了", "aaa");
    }
}