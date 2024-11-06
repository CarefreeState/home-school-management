package com.macaron.homeschool.model.dto;

import com.macaron.homeschool.common.enums.AuditStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 21:45
 */
@Data
public class AuditClassUserDTO {

    @NotNull(message = "班级 id 不能为空")
    Long classId;

    @NotNull(message = "用户 id 不能为空")
    Long userId;

    @NotNull(message = "审核状态不能为空")
    Integer auditStatus;

}