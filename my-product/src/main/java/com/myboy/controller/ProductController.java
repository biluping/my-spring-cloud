package com.myboy.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping("/add")
    public String getById(@RequestBody Map<String, String> map) {
        System.out.println(map);
        return map.toString();
    }
}
