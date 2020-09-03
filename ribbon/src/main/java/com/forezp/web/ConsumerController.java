package com.forezp.web;

import com.forezp.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: chapter5-2
 * @Date: 2020/9/1 18:48
 * @Author: Mr.SU
 * @Description:
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/sub" ,method = RequestMethod.GET)
    public String sub(@RequestParam Integer a, @RequestParam Integer b) {
//        RestTemplate restTemplate=new RestTemplate();
//        return restTemplate.getForObject("http://localhost:7078/sub?a="+a+"&b="+b, String.class);

        return consumerService.dealSub(a, b);
    }

}
