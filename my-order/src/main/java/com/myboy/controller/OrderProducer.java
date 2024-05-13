package com.myboy.controller;

import com.myboy.service.OrderService;
import jakarta.annotation.Resource;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/order")
@RestController
public class OrderProducer {

    @GetMapping("/send")
    public void send() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setSendMsgTimeout(6000);
        producer.start();

        try {
            Message msg = new Message("order",
                    "TagA",
                    "OrderID188",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        } catch (Exception e) {
            e.printStackTrace();
            producer.shutdown();
        }
    }

    @PostMapping("/add")
    public Map<String, Integer> add(@RequestBody Map<String, Integer> map) {
        map.put("feign", 100);
        return map;
    }


    @Resource
    private OrderService orderService;

    @GetMapping("/cache")
    public void cache() {
        Map<String, Integer> byId = orderService.getById(123L);
        System.out.println(byId);
    }
}
