package com.macaron.homeschool.model.vo;

import com.macaron.homeschool.common.enums.AuditStatus;
import com.macaron.homeschool.common.enums.UserType;
import lombok.Data;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 14:59
 */
@Data
public class UserVO {

    private Long id;

    private String username;

    private String nickname;

    private String phoneNumber;

    private Integer userType;

    private Integer auditStatus;

}