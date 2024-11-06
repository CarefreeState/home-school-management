package com.macaron.homeschool.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 11:29
 */
@Data
@Schema(description = "用户登录数据")
public class UserLoginDTO {

    /**
     * 登录方式
     */
    @NotBlank(message = "登录方式不能为空")
    @Schema(description = "用户登录类型")
    private String loginType;


    /**
     * 密码登录
     */
    @Valid
    @Schema(description = "用户登录参数")
    private UserPasswordLoginDTO passwordParams;

}
