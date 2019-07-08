package com.clouds.zh.itsop.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clouds.zh.itsop.ItsopUserApplication;
import com.clouds.zh.itsop.common.module.user.User;
import com.clouds.zh.itsop.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

/*    @Test
    public void testgetById() throws InterruptedException {
        User user = userService.getById(1);
        System.out.println(user.toString());
    }*/

    @Test
    public void testPage() throws InterruptedException {
        PageInfo<User> page= userService.getUserPage(1,10,new User());
        System.out.println(page.toString());
    }

}
