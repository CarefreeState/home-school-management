package com.macaron.homeschool.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.macaron.homeschool.common.base.BaseIncrIDEntity;
import com.macaron.homeschool.common.enums.AuditStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName class_teacher_link
 */
@TableName(value ="class_teacher_link")
@Data
public class ClassTeacherLink extends BaseIncrIDEntity implements Serializable {

    private Long classId;

    private Long userId;

    private AuditStatus auditStatus;

    private static final long serialVersionUID = 1L;
}