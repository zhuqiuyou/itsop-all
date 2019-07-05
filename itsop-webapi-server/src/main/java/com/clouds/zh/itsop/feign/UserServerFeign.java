package com.clouds.zh.itsop.feign;

import com.clouds.zh.itsop.feign.impl.UserServerFeignHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author zhuqi
 * @Date 2019-07-05
 * @Version 1.0
 **/
@FeignClient(value = "itsop-user-server",fallback = UserServerFeignHystrixImpl.class)
public interface UserServerFeign {

    @GetMapping("/user/getUserName")
    public String getUserName(@RequestParam(value = "username") String username);

}
