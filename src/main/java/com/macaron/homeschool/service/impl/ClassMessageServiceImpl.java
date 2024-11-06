package com.macaron.homeschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macaron.homeschool.model.dao.mapper.ClassMessageMapper;
import com.macaron.homeschool.model.entity.ClassMessage;
import com.macaron.homeschool.service.ClassMessageService;
import org.springframework.stereotype.Service;

/**
* @author 马拉圈
* @description 针对表【class_message(班级消息表)】的数据库操作Service实现
* @createDate 2024-11-05 21:06:05
*/
@Service
public class ClassMessageServiceImpl extends ServiceImpl<ClassMessageMapper, ClassMessage>
    implements ClassMessageService{

}




