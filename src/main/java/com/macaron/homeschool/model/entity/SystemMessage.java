package com.macaron.homeschool.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.macaron.homeschool.common.base.BaseIncrIDEntity;
import lombok.Data;

/**
 * @TableName system_message
 */
@TableName(value ="system_message")
@Data
public class SystemMessage extends BaseIncrIDEntity implements Serializable {

    private Long creatorId;

    private String title;

    private String content;

    private static final long serialVersionUID = 1L;
}