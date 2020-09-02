package com.forezp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: chapter5-2
 * @Date: 2020/9/2 10:50
 * @Author: Mr.SU
 * @Description:
 */
@FeignClient("SERVICE-A")
public interface ComputeService {

    @GetMapping("/add")
    String dealAdd(@RequestParam Integer a, @RequestParam Integer b);
}
