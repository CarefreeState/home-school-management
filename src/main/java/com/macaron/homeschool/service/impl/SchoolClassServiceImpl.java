package com.macaron.homeschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macaron.homeschool.model.dao.mapper.SchoolClassMapper;
import com.macaron.homeschool.model.entity.SchoolClass;
import com.macaron.homeschool.service.SchoolClassService;
import org.springframework.stereotype.Service;

/**
* @author 马拉圈
* @description 针对表【school_class(班级表)】的数据库操作Service实现
* @createDate 2024-11-05 21:06:05
*/
@Service
public class SchoolClassServiceImpl extends ServiceImpl<SchoolClassMapper, SchoolClass>
    implements SchoolClassService{

}




