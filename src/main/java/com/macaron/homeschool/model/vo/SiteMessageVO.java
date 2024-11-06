package com.macaron.homeschool.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 23:29
 */
@Data
public class SiteMessageVO {

    private Long id;

    private UserInfoVO senderVO;

    private UserInfoVO recipientVO;

    private String title;

    private String content;

    protected LocalDateTime createTime;

}
