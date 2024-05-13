# spring cloud 版本关系
> https://github.com/alibaba/spring-cloud-alibaba/wiki/版本说明

| Spring Cloud Alibaba Version	 | Spring Cloud Version	  | Spring Boot Version |
|-------------------------------|------------------------|---------------------|
| 2022.0.0.0*                   | Spring Cloud 2022.0.0  | 3.0.2               |

| Spring Cloud Alibaba Version	 | Sentinel Version	 | Nacos Version | RocketMQ Version | Seata Version |
|-------------------------------|-------------------|---------------|------------------|---------------|
| 2022.0.0.0                    | 1.8.6             | 2.2.1         | 4.9.4            | 1.7.0         |

# Spring Cloud OpenFeign
> 前提: 相关服务都已经注册到注册中心

1、引入依赖
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
```

2、启动类添加注解，开启 feign
```yaml
@EnableFeignClients
```

3、编写 feign client
```java
@FeignClient(name = "my-order", path = "/order")
public interface OrderFeign {

    @PostMapping("/add")
    Map<String,Object> add(@RequestBody Map<String, Integer> map);
}
```

4、调用测试