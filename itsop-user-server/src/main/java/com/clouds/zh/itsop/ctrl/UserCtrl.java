package com.clouds.zh.itsop.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhuqi
 * @Date 2019-07-05
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserCtrl {

    @Value("${server.port}")
    private String port;

    @GetMapping("/getUserName")
    public String getUserName(@RequestParam(name = "username",required = true) String username) {
        return String.format("Hi，your username is : %s i am from port : %s", username, port);
    }
}
