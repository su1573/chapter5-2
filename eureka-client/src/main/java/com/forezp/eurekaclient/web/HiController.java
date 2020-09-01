package com.forezp.eurekaclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: chapter5-2
 * @Date: 2020/7/19 18:16
 * @Author: Mr.SU
 * @Description:
 */
@RestController
public class HiController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }
}
