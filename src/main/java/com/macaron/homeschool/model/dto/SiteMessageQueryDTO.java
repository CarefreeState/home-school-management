package com.macaron.homeschool.model.dto;

import lombok.Data;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 23:20
 */
@Data
public class SiteMessageQueryDTO {

    private Integer current;

    private Integer pageSize;

    private Long classId;

    private Long oppositeId; // 消息的对方

}
