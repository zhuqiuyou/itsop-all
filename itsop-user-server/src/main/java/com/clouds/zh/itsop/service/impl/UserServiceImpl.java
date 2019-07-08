package com.clouds.zh.itsop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds.zh.itsop.common.module.user.User;
import com.clouds.zh.itsop.mapper.UserMapper;
import com.clouds.zh.itsop.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author zhuqi
 * @since 2019-07-08
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public PageInfo<User> getUserPage(int startNum, int pageSize, User user){
        log.info("## getUserPage 分页方法 startNum=[{}],pageSize=[{}],user=[{}]",startNum,pageSize,user);
        //TODO分页方法查询
        QueryWrapper queryWrapper=new QueryWrapper();

        PageHelper.startPage(startNum, pageSize);
        List<User> list =this.list(queryWrapper);
        PageInfo<User> page = new PageInfo<User>(list);
        return page;
    }
}
