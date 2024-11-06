package com.macaron.homeschool.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 11:22
 */
@Getter
@ToString
@Builder
@Schema(description = "用户登录响应数据")
public class UserLoginVO {

    @Schema(description = "用户登录令牌")
    private String token;

}
