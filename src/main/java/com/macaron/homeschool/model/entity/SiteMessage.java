package com.macaron.homeschool.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.macaron.homeschool.common.base.BaseIncrIDEntity;
import lombok.Data;

/**
 * @TableName site_message
 */
@TableName(value ="site_message")
@Data
public class SiteMessage extends BaseIncrIDEntity implements Serializable {

    private Long senderId;

    private Long recipientId;

    private String title;

    private String content;

    private static final long serialVersionUID = 1L;
}