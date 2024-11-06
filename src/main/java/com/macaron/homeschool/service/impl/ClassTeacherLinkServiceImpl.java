package com.macaron.homeschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macaron.homeschool.model.dao.mapper.ClassTeacherLinkMapper;
import com.macaron.homeschool.model.entity.ClassTeacherLink;
import com.macaron.homeschool.service.ClassTeacherLinkService;
import org.springframework.stereotype.Service;

/**
* @author 马拉圈
* @description 针对表【class_teacher_link(班级-用户关联表)】的数据库操作Service实现
* @createDate 2024-11-05 21:06:05
*/
@Service
public class ClassTeacherLinkServiceImpl extends ServiceImpl<ClassTeacherLinkMapper, ClassTeacherLink>
    implements ClassTeacherLinkService{

}




