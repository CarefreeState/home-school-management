package com.macaron.homeschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macaron.homeschool.model.dao.mapper.SystemMessageMapper;
import com.macaron.homeschool.model.entity.SystemMessage;
import com.macaron.homeschool.service.SystemMessageService;
import org.springframework.stereotype.Service;

/**
* @author 马拉圈
* @description 针对表【system_message(系统消息表)】的数据库操作Service实现
* @createDate 2024-11-05 21:06:05
*/
@Service
public class SystemMessageServiceImpl extends ServiceImpl<SystemMessageMapper, SystemMessage>
    implements SystemMessageService{

}




