package com.macaron.homeschool.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macaron.homeschool.model.dto.SiteMessageDTO;
import com.macaron.homeschool.model.dto.SiteMessageQueryDTO;
import com.macaron.homeschool.model.entity.SiteMessage;
import com.macaron.homeschool.model.vo.SiteMessageQueryVO;

import java.util.Optional;

/**
* @author 马拉圈
* @description 针对表【site_message(站内信表)】的数据库操作Service
* @createDate 2024-11-05 21:06:05
*/
public interface SiteMessageService extends IService<SiteMessage> {

    Optional<SiteMessage> getSiteMessage(Long messageId);

    Long releaseSiteMessage(Long userId, SiteMessageDTO siteMessageDTO);

    void removeSiteMessage(Long messageId);

    SiteMessageQueryVO querySiteMessageList(Long userId, SiteMessageQueryDTO siteMessageQueryDTO);

    SiteMessage checkAndGetSiteMessage(Long messageId);

}
