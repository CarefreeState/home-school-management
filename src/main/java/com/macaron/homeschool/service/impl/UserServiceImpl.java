package com.macaron.homeschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macaron.homeschool.common.constants.UserConstants;
import com.macaron.homeschool.common.enums.AuditStatus;
import com.macaron.homeschool.common.enums.GlobalServiceStatusCode;
import com.macaron.homeschool.common.enums.UserType;
import com.macaron.homeschool.common.exception.GlobalServiceException;
import com.macaron.homeschool.model.converter.UserConverter;
import com.macaron.homeschool.model.dao.mapper.UserMapper;
import com.macaron.homeschool.model.dto.UserRegisterDTO;
import com.macaron.homeschool.model.entity.User;
import com.macaron.homeschool.redis.lock.RedisLock;
import com.macaron.homeschool.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
* @author 马拉圈
* @description 针对表【user(用户基本信息表)】的数据库操作Service实现
* @createDate 2024-11-05 21:06:05
*/
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    private final RedisLock redisLock;

    @Override
    public Optional<User> getUserByUsername(String username) {
        return this.lambdaQuery()
                .eq(User::getUsername, username)
                .oneOpt();
    }

    @Override
    public User register(UserRegisterDTO userRegisterDTO) {
        String username = userRegisterDTO.getUsername();
        return redisLock.tryLockGetSomething(UserConstants.USER_REGISTER_LOCK + username, () -> {
            getUserByUsername(username).ifPresent(account -> {
                throw new GlobalServiceException(String.format("用户 %s，账户已存在，注册失败", account), GlobalServiceStatusCode.USER_ACCOUNT_ALREADY_EXIST);
            });
            // 注册用户
            User user = UserConverter.INSTANCE.userRegisterDTOToUser(userRegisterDTO);
            // 家长无需审核
            if(UserType.GUARDIAN.equals(user.getUserType())) {
                user.setAuditStatus(AuditStatus.AUDIT_PASSED);
            }
            this.save(user);
            log.info("用户注册成功：{}", user);
            return user;
        }, () -> null);
    }
}




