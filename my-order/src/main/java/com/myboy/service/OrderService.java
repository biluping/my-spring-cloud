package com.myboy.service;

import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.Cached;

import java.util.Map;

public interface OrderService {

    @CacheRefresh(refresh = 5)
    @Cached(name = "order-", expire = 10, key = "'hello-' + #id")
    Map<String, Integer> getById(Long id);
}
