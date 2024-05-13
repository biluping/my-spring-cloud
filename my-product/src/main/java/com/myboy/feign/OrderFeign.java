package com.myboy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "my-order", path = "/order", configuration = FeignConfiguration.class, fallback = OrderFeignFallback.class)
public interface OrderFeign {

    @PostMapping("/add")
    Map<String,Object> add(@RequestBody Map<String, Integer> map);
}
