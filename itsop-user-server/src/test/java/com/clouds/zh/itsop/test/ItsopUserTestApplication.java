package com.clouds.zh.itsop.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clouds.zh.itsop.ItsopUserApplication;
import com.clouds.zh.itsop.common.module.user.User;
import com.clouds.zh.itsop.common.redis.service.IRedisService;
import com.clouds.zh.itsop.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhuqi
 * @Date 2019-07-08
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ItsopUserApplication.class})
public class ItsopUserTestApplication {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRedisService redisService;

/*    @Test
    public void testgetById() throws InterruptedException {
        User user = userService.getById(1);
        System.out.println(user.toString());
    }*/

/*    @Test
    public void testPage() throws InterruptedException {
        PageInfo<User> page= userService.getUserPage(1,10,new User());
        System.out.println(page.toString());
    }*/

    @Test
    public void testGet(){
        redisService.set("itsop-jackjson-key","itsop-jackjson",1L,TimeUnit.HOURS);
        System.out.println(redisService.get("itsop-jackjson-key"));

        User user=new User();
        user.setId(1);
        user.setName("admin");
        user.setAddDate(LocalDateTime.now());
        user.setLoginDate(LocalDateTime.now());
        redisService.set("itsop-jackjson-key-admin",user);
        System.out.println(redisService.get("itsop-jackjson-key-admin"));


    /*    List<User> list=new ArrayList<User>();

        User user=new User();
        user.setId(1);
        user.setName("admin");
        list.add(user);

        user=new User();
        user.setId(2);
        user.setName("zhangsan");
        list.add(user);

        user=new User();
        user.setId(3);
        user.setName("lisi");
        list.add(user);


        user=new User();
        user.setId(4);
        user.setName("wanger");
        list.add(user);

        user=new User();
        user.setId(5);
        user.setName("mazi");
        list.add(user);

        redisService.lPush("itsop-list-user",list);*/


    }
}
