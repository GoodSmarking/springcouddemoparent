package com.smarking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/helloCustomer")
public class HelloCustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping("hello")
    public Object hello(){
        String serviceName = "peer2-service";
        String interfaceName = "hello/hello";
        String url = "http://" + serviceName + "/" + interfaceName;
        ResponseEntity<String> helloResponseEntity = restTemplate.getForEntity(url, String.class);
        System.out.println("statusCode:" + helloResponseEntity.getStatusCode());
        System.out.println("body:" + helloResponseEntity.getBody());
        System.out.println("headers:" + helloResponseEntity.getHeaders());
        return helloResponseEntity;
    }
}
