package com.clouds.zh.itsop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author zhuqi
 * @Date 2019-07-05
 * @Version 1.0
 **/
@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
public class ItsopUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItsopUserApplication.class, args);
    }

}
