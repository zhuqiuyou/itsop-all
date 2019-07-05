package com.clouds.zh.itsop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @Author zhuqi
 * @Date 2019-07-05
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ItsopZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItsopZipkinApplication.class, args);
    }

}
