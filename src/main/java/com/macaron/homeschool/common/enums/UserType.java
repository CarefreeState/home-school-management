package com.macaron.homeschool.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.macaron.homeschool.common.exception.GlobalServiceException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-05
 * Time: 21:16
 */
@Getter
@AllArgsConstructor
public enum UserType {

    MANAGER("manager", 1),
    TEACHER("teacher", 2),
    GUARDIAN("guardian", 3),
    ;

    private final String name;

    @JsonValue
    @EnumValue
    private final Integer code;

    public static UserType get(Integer role) {
        for (UserType userType : UserType.values()) {
            if(userType.getCode().equals(role)) {
                return userType;
            }
        }
        throw new GlobalServiceException(GlobalServiceStatusCode.USER_TYPE_EXCEPTION);
    }

}
