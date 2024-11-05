package com.macaron.homeschool.interceptor;

import com.macaron.homeschool.common.enums.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@Builder
public class UserHelper {

    Long userId;

    UserType role;
}
