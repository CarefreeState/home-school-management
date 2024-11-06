package com.macaron.homeschool.model.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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
public class UserLoginVO {

    private String token;

}
