package com.myboy;

import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.myboy.mapper.OrderMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackageClasses = OrderMapper.class)
@EnableMethodCache(basePackages = "com.myboy.service")
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
