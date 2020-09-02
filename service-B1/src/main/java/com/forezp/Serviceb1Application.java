package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Serviceb1Application {

    public static void main(String[] args) {
        SpringApplication.run(Serviceb1Application.class, args);
    }

}
