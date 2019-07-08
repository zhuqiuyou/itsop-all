package com.clouds.zh.itsop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clouds.zh.itsop.common.module.user.User;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author zhuqi
 * @since 2019-07-08
 */
public interface IUserService  extends IService<User> {

    public PageInfo<User> getUserPage(int startNum, int pageSize, User entity);
}
