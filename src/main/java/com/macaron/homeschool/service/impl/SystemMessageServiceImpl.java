package com.macaron.homeschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macaron.homeschool.common.enums.GlobalServiceStatusCode;
import com.macaron.homeschool.common.exception.GlobalServiceException;
import com.macaron.homeschool.model.converter.SystemMessageConverter;
import com.macaron.homeschool.model.converter.UserConverter;
import com.macaron.homeschool.model.dao.mapper.SystemMessageMapper;
import com.macaron.homeschool.model.dto.SystemMessageDTO;
import com.macaron.homeschool.model.entity.SystemMessage;
import com.macaron.homeschool.model.entity.User;
import com.macaron.homeschool.model.vo.SystemMessageDetailVO;
import com.macaron.homeschool.model.vo.SystemMessageVO;
import com.macaron.homeschool.model.vo.UserInfoVO;
import com.macaron.homeschool.service.SystemMessageService;
import com.macaron.homeschool.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
* @author 马拉圈
* @description 针对表【system_message(系统消息表)】的数据库操作Service实现
* @createDate 2024-11-05 21:06:05
*/
@Service
@Slf4j
@RequiredArgsConstructor
public class SystemMessageServiceImpl extends ServiceImpl<SystemMessageMapper, SystemMessage>
    implements SystemMessageService{

    private final UserService userService;

    @Override
    public Optional<SystemMessage> getSystemMessage(Long id) {
        return this.lambdaQuery()
                .eq(SystemMessage::getId, id)
                .oneOpt();
    }

    @Override
    public Long releaseSystemMessage(Long managerId, SystemMessageDTO systemMessageDTO) {
        SystemMessage systemMessage = SystemMessageConverter.INSTANCE.systemMessageDTOToSystemMessage(systemMessageDTO);
        systemMessage.setCreatorId(managerId);
        this.save(systemMessage);
        log.info("管理员 {} 发布系统消息 {}", managerId, systemMessage);
        return systemMessage.getId();
    }

    @Override
    public void removeSystemMessage(Long id) {
        this.lambdaUpdate()
                .eq(SystemMessage::getId, id)
                .remove();
    }

    @Override
    public List<SystemMessageVO> querySystemMessageList() {
        return SystemMessageConverter.INSTANCE.systemMessageListToSystemMessageVOList(list());
    }

    @Override
    public SystemMessage checkAndGetSystemMessage(Long id) {
        return getSystemMessage(id).orElseThrow(() ->
                new GlobalServiceException(GlobalServiceStatusCode.SYSTEM_MESSAGE_NOT_EXISTS));
    }

    @Override
    public SystemMessageDetailVO querySystemMessageDetail(Long id) {
        SystemMessage systemMessage = checkAndGetSystemMessage(id);
        SystemMessageDetailVO systemMessageDetailVO = SystemMessageConverter.INSTANCE.systemMessageToSystemMessageDetailVO(systemMessage);
        User user = userService.checkAndGetUserById(systemMessage.getCreatorId());
        systemMessageDetailVO.setUserInfoVO(UserConverter.INSTANCE.userToUserInfoVO(user));
        return systemMessageDetailVO;
    }
}




