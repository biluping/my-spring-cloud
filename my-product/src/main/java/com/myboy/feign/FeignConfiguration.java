package com.myboy.feign;

import org.springframework.context.annotation.Bean;

class FeignConfiguration {
    @Bean
    public OrderFeignFallback echoServiceFallback() {
        return new OrderFeignFallback();
    }
}

