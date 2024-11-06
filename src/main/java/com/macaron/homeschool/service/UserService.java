package com.macaron.homeschool.service;

import com.macaron.homeschool.model.dto.UserRegisterDTO;
import com.macaron.homeschool.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Optional;

/**
* @author 马拉圈
* @description 针对表【user(用户基本信息表)】的数据库操作Service
* @createDate 2024-11-05 21:06:05
*/
public interface UserService extends IService<User> {

    Optional<User> getUserByUsername(String username);

    User register(UserRegisterDTO userRegisterDTO);

}
