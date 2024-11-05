package com.macaron.homeschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macaron.homeschool.model.entity.User;
import com.macaron.homeschool.service.UserService;
import com.macaron.homeschool.model.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 马拉圈
* @description 针对表【user(用户基本信息表)】的数据库操作Service实现
* @createDate 2024-11-05 21:06:05
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




