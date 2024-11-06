package com.macaron.homeschool.model.vo;

import com.macaron.homeschool.common.enums.AuditStatus;
import com.macaron.homeschool.common.enums.UserType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 13:54
 */
@Data
public class UserInfoVO {

    private String username;

    private String nickname;

    private String phoneNumber;

    private Integer userType;

}
