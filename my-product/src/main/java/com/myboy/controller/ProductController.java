package com.myboy.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.myboy.feign.OrderFeign;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    static {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("getById");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(2);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    @SentinelResource(value = "getById", blockHandler="blockHandler", fallback = "getByIdFallback")
    @PostMapping("/add")
    public String getById(@RequestBody Map<String, String> map) {
        System.out.println(map);
        if (map.get("id") == null) {
            throw new RuntimeException("aaa");
        }
        return map.toString();
    }

    public String blockHandler(Map<String, String> map, BlockException ex) {
        return "blockHandler";
    }

    public String getByIdFallback(Map<String, String> map, Throwable throwable) {
        return "fallback";
    }

    @Resource
    private OrderFeign orderFeign;

    @GetMapping("/feign")
    public void test() {
        Map<String, Object> add = orderFeign.add(new HashMap<>());
        System.out.println(add);
    }
}
