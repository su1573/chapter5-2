package com.forezp.web;

import com.forezp.config.ApplicationContextRegister;
import com.forezp.service.ComputeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class ComputeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private ComputeService computeService;

    @Value("${foo1}")
    private String foo1;

    @Value("${foo2}")
    private String foo2;
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        List<ServiceInstance> instances = client.getInstances("service-A");
        ServiceInstance instance = instances.get(0);

        int r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return "From Service-A, Result is " + r+"\nPort:"+instance.getPort()+". foo1 is:"+foo1+". foo2 is:"+foo2;
    }

    //call service-B
    @RequestMapping(value="/testServiceB",method=RequestMethod.GET)
    public String testServiceB(@RequestParam Integer a,@RequestParam Integer b){
//        ComputeService computeService = ApplicationContextRegister.getBean(ComputeService.class);
        return computeService.dealSub(a, b);
    }


}
