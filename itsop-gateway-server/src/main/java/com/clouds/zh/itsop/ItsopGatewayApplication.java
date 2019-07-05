package com.clouds.zh.itsop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @Author zhuqi
 * @Date 2019-07-05
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ItsopGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItsopGatewayApplication.class, args);
    }

}
