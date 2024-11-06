package com.macaron.homeschool.controller;

import com.macaron.homeschool.common.SystemJsonResponse;
import com.macaron.homeschool.common.annotation.Intercept;
import com.macaron.homeschool.common.context.BaseContext;
import com.macaron.homeschool.common.enums.GlobalServiceStatusCode;
import com.macaron.homeschool.common.enums.UserType;
import com.macaron.homeschool.common.exception.GlobalServiceException;
import com.macaron.homeschool.model.dto.SiteMessageDTO;
import com.macaron.homeschool.model.dto.SiteMessageQueryDTO;
import com.macaron.homeschool.model.vo.SiteMessageQueryVO;
import com.macaron.homeschool.service.SchoolClassService;
import com.macaron.homeschool.service.SiteMessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-07
 * Time: 1:09
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "站内信测试接口")
@RequestMapping("/api/v1/message/site")
@Intercept(permit = {UserType.TEACHER, UserType.GUARDIAN})
public class SiteMessageController {

    private final SiteMessageService siteMessageService;

    private final SchoolClassService schoolClassService;

    @PostMapping("/release")
    @Operation(summary = "发布站内信")
    public SystemJsonResponse<Long> releaseSiteMessage(@Valid @RequestBody SiteMessageDTO siteMessageDTO) {
        Long userId = BaseContext.getCurrentUser().getUserId();
        Long classId = siteMessageDTO.getClassId();
        // 判断班级是否有效
        schoolClassService.checkSchoolClassApproved(classId);
        // 判断是否是班级的人
        schoolClassService.checkPartnerOfSchoolClass(classId, userId);
        schoolClassService.checkPartnerOfSchoolClass(classId, siteMessageDTO.getRecipientId());
        // 发布
        Long messageId = siteMessageService.releaseSiteMessage(userId, siteMessageDTO);
        return SystemJsonResponse.SYSTEM_SUCCESS(messageId);
    }

    @DeleteMapping("/remove/{messageId}")
    @Operation(summary = "删除站内信")
    public SystemJsonResponse<?> removeSiteMessage(@PathVariable("messageId") @NotNull(message = "班级通知 id 不能为空") Long messageId) {
        Long senderId = siteMessageService.checkAndGetSiteMessage(messageId).getSenderId();
        if(!BaseContext.getCurrentUser().getUserId().equals(senderId)) {
            throw new GlobalServiceException(GlobalServiceStatusCode.USER_NO_PERMISSION);
        }
        siteMessageService.removeSiteMessage(messageId);
        return SystemJsonResponse.SYSTEM_SUCCESS();
    }

    @GetMapping("/query")
    @Operation(summary = "查看站内信列表")
    public SystemJsonResponse<SiteMessageQueryVO> querySystemMessageList(@Valid @RequestBody(required = false) SiteMessageQueryDTO siteMessageQueryDTO) {
        Long userId = BaseContext.getCurrentUser().getUserId();
        SiteMessageQueryVO siteMessageQueryVO = siteMessageService.querySiteMessageList(userId, siteMessageQueryDTO);
        return SystemJsonResponse.SYSTEM_SUCCESS(siteMessageQueryVO);
    }
}
