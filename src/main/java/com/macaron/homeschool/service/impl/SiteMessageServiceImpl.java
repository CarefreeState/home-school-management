package com.macaron.homeschool.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macaron.homeschool.common.base.BasePageQuery;
import com.macaron.homeschool.common.base.BasePageResult;
import com.macaron.homeschool.common.enums.GlobalServiceStatusCode;
import com.macaron.homeschool.common.exception.GlobalServiceException;
import com.macaron.homeschool.model.converter.SiteMessageConverter;
import com.macaron.homeschool.model.dao.mapper.SiteMessageMapper;
import com.macaron.homeschool.model.dto.SiteMessageDTO;
import com.macaron.homeschool.model.dto.SiteMessageQueryDTO;
import com.macaron.homeschool.model.entity.SiteMessage;
import com.macaron.homeschool.model.vo.SiteMessageQueryVO;
import com.macaron.homeschool.model.vo.SiteMessageVO;
import com.macaron.homeschool.service.SchoolClassService;
import com.macaron.homeschool.service.SiteMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
* @author 马拉圈
* @description 针对表【site_message(站内信表)】的数据库操作Service实现
* @createDate 2024-11-05 21:06:05
*/
@Service
@Slf4j
@RequiredArgsConstructor
public class SiteMessageServiceImpl extends ServiceImpl<SiteMessageMapper, SiteMessage>
    implements SiteMessageService{

    private final SiteMessageMapper siteMessageMapper;

    private final SchoolClassService schoolClassService;

    @Override
    public Optional<SiteMessage> getSiteMessage(Long messageId) {
        return this.lambdaQuery()
                .eq(SiteMessage::getId, messageId)
                .oneOpt();
    }

    @Override
    public Long releaseSiteMessage(Long userId, SiteMessageDTO siteMessageDTO) {
        SiteMessage siteMessage = SiteMessageConverter.INSTANCE.siteMessageDTOToSiteMessage(siteMessageDTO);
        siteMessage.setSenderId(userId);
        this.save(siteMessage);
        log.info("用户 {} 发送站内信 {}", userId, siteMessage);
        return siteMessage.getId();
    }

    @Override
    public void removeSiteMessage(Long messageId) {
        this.lambdaUpdate()
                .eq(SiteMessage::getId, messageId)
                .remove();
    }

    @Override
    public SiteMessageQueryVO querySiteMessageList(Long userId, SiteMessageQueryDTO siteMessageQueryDTO) {
        // 解析分页参数获取 page
        IPage<SiteMessageVO> page = null;
        Long classId = null;
        Long oppositeId = null;
        if(Objects.isNull(siteMessageQueryDTO)) {
            page = new BasePageQuery().toMpPage();
        } else {
            page = SiteMessageConverter.INSTANCE.siteMessageQueryDTOToBasePageQuery(siteMessageQueryDTO).toMpPage();
            classId = siteMessageQueryDTO.getClassId();
            oppositeId = siteMessageQueryDTO.getOppositeId();
        }
        // 如果 classId 不为 null，userId 必须是该班级的
        if(Objects.nonNull(classId)) {
            schoolClassService.checkSchoolClassApproved(classId);
            schoolClassService.checkPartnerOfSchoolClass(classId, userId);
        }
        // 分页
        IPage<SiteMessageVO> siteMessageVOIPage = siteMessageMapper.querySiteMessageList(page, userId, classId, oppositeId);
        // 封装
        BasePageResult<SiteMessageVO> pageResult = BasePageResult.of(siteMessageVOIPage);
        // 转化
        return SiteMessageConverter.INSTANCE.basePageResultToSiteMessageQueryVO(pageResult);
    }

    @Override
    public SiteMessage checkAndGetSiteMessage(Long messageId) {
        return getSiteMessage(messageId).orElseThrow(() ->
                new GlobalServiceException(GlobalServiceStatusCode.SITE_MESSAGE_NOT_EXISTS));
    }
}




