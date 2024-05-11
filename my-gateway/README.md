# spring-cloud-gateway
> [官方文档](https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway)

## 1 功能
1. 路由转发、负载均衡
2. 鉴权
3. 限流、熔断、降级

## 2 断言因子
> [断言文档](https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway/request-predicates-factories.html)

在 gateway 中，会配置很多路由匹配，断言的意思，就是匹配你这个请求是否匹配我这个路由，
gateway 内置了很多断言，如下：

1. After
2. Before
3. Between
4. Cookie
5. Header
6. Host
7. Method
8. Path
9. Query
10. RemoteAddr
11. Weight
12. XForwarded Remote Addr

以 Method 断言作为示例：
```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: method_route
        uri: https://example.org
        predicates:
        - Method=GET,POST
```

## 3 过滤器因子
> [过滤器文档](https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway/gatewayfilter-factories.html)

过滤器可以修改 request 和 response，比如加个请求头、响应头之类的，gateway 内置了很多过滤器，如下

1. AddRequestHeader
2. AddRequestHeadersIfNotPresent
3. AddRequestParameter
4. AddResponseHeader
5. CircuitBreaker
6. CacheRequestBody
7. DedupeResponseHeader
8. FallbackHeaders
9. JsonToGrpc
10. LocalResponseCache
11. MapRequestHeader
12. ModifyRequestBody
13. ModifyResponseBody
14. PrefixPath
15. PreserveHostHeader
16. RedirectTo
17. RemoveJsonAttributesResponseBody
18. RemoveRequestHeader
19. RemoveRequestParameter
20. RemoveResponseHeader
21. RequestHeaderSize
22. RequestRateLimiter
23. RewriteLocationResponseHeader
24. RewritePath
25. RewriteRequestParameter
26. RewriteResponseHeader
27. SaveSession
28. SecureHeaders
29. SetPath
30. SetRequestHeader
31. SetResponseHeader
32. SetStatus
33. StripPrefix
34. Retry
35. RequestSize
36. SetRequestHostHeader
37. TokenRelay


## 4 全局过滤器
> [全局过滤器文档](https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway/global-filters.html)

全局过滤器会应用到所有请求，具体写法参考官方文档


## 5 微服务负载均衡
> [DiscoveryClient Route Definition Locator](https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway/the-discoveryclient-route-definition-locator.html)

根据官方文档，首先需要确保 gateway 项目中引入了负载均衡依赖
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
```
假设通过请求 /product/** 路由到 my-product 服务对应的接口上，则配置如下
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: my-product
          uri: lb://my-product/product/**
          predicates:
            - Path=/product/**
```


## 6 配置跨域
> [CORS Configuration](https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway/cors-configuration.html)

```yaml
spring:
  cloud:
    gateway:
      globalcors:
        cors-configurations:
          '[/**]':
            allowedOrigins: "https://docs.spring.io"
            allowedMethods:
            - GET
```

## 7 自定义断言、过滤器 
> [Developer Guide](https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway/developer-guide.html)