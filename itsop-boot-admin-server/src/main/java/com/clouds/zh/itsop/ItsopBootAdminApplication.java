package com.clouds.zh.itsop;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhuqiuyou
 * spring cloud admin 管理服务
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class ItsopBootAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItsopBootAdminApplication.class, args);
    }
}
