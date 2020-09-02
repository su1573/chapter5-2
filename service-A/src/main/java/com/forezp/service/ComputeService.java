package com.forezp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: chapter5-2
 * @Date: 2020/9/2 10:22
 * @Author: Mr.SU
 * @Description:
 */
@FeignClient("SERVICE-B")
public interface ComputeService {

    String auth_center_proxy_prefix="";

    @GetMapping(auth_center_proxy_prefix + "/sub")
    String dealSub(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

}
