package com.macaron.homeschool.model.vo;

import com.macaron.homeschool.common.enums.AuditStatus;
import lombok.Data;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 16:43
 */
@Data
public class SchoolClassVO {

    private String className;

    private Integer auditStatus;

}
