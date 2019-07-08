package com.clouds.zh.itsop.ctrl;

import com.clouds.zh.itsop.feign.UserServerFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhuqi
 * @Date 2019-07-05
 * @Version 1.0
 **/
@Api(value = "用户", description = "用户")
@RestController
@RequestMapping("user")
public class UserCtrl {

    @Autowired
    private UserServerFeign userServerFeign;

    @ApiOperation(value = "获取用户名", notes = "输入用户名查找")
    @GetMapping("getUserName")
    public String getUserName(@RequestParam(name = "username",required = true) String username) {
        System.out.println("##webapi-user ctrl getUserName username="+username);
        return userServerFeign.getUserName(username);
    }
}
