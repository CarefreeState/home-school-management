package com.macaron.homeschool.model.dto;

import lombok.Data;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 22:40
 */
@Data
public class ClassMessageQueryDTO {

    private Integer current;

    private Integer pageSize;

    private Long classId;

}
