package com.forezp.web;

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
 * @Date: 2020/9/1 17:24
 * @Author: Mr.SU
 * @Description:
 */
@RestController
public class computeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        List<ServiceInstance> instances = client.getInstances("service-A");
        ServiceInstance instance = instances.get(0);

        int r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return "From Service-A, Result is " + r+"\nPort:"+instance.getPort();
    }

    //call service-B
    @RequestMapping(value="/testServiceB",method=RequestMethod.GET)
    public String testServiceB(@RequestParam Integer a,@RequestParam Integer b){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:7078/sub?a="+a+"&b="+b, String.class);
    }


}
