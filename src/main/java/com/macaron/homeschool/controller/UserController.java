package com.macaron.homeschool.controller;

import cn.hutool.extra.spring.SpringUtil;
import com.macaron.homeschool.common.SystemJsonResponse;
import com.macaron.homeschool.model.dto.UserLoginDTO;
import com.macaron.homeschool.model.vo.UserLoginVO;
import com.macaron.homeschool.service.LoginService;
import com.macaron.homeschool.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 11:47
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "用户测试接口")
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public SystemJsonResponse<UserLoginVO> login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        String serviceName = userLoginDTO.getLoginType() + LoginService.BASE_NAME;
        LoginService service = SpringUtil.getBean(serviceName, LoginService.class);
        UserLoginVO userLoginVO = service.login(userLoginDTO);
        return SystemJsonResponse.SYSTEM_SUCCESS(userLoginVO);
    }
}
