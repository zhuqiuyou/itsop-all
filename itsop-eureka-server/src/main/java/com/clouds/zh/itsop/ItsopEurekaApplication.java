package com.clouds.zh.itsop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhuqiuyou
 * 服务注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class ItsopEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItsopEurekaApplication.class, args);
    }
}
