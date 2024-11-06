package com.macaron.homeschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macaron.homeschool.model.dao.mapper.SiteMessageMapper;
import com.macaron.homeschool.model.entity.SiteMessage;
import com.macaron.homeschool.service.SiteMessageService;
import org.springframework.stereotype.Service;

/**
* @author 马拉圈
* @description 针对表【site_message(站内信表)】的数据库操作Service实现
* @createDate 2024-11-05 21:06:05
*/
@Service
public class SiteMessageServiceImpl extends ServiceImpl<SiteMessageMapper, SiteMessage>
    implements SiteMessageService{

}




