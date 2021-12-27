package com.smarking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class HelloCustomerApp {

    @Bean
    @LoadBalanced//开启负载均衡的功能
    RestTemplate getRestTemplate(){
        // RestTemplate是一个Spring框架的http请求工具类，也可以不使用这个
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloCustomerApp.class, args);
    }
}
