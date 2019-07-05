package com.clouds.zh.itsop.feign.impl;

import com.clouds.zh.itsop.feign.UserServerFeign;
import org.springframework.stereotype.Component;

/**
 * @Author zhuqi
 * @Date 2019-07-05
 * @Version 1.0
 **/
@Component
public class UserServerFeignHystrixImpl implements UserServerFeign {

    @Override
    public String getUserName(String username) {
        return "Hi，your message is :\"" + username + "\" but request error.";
    }
}
