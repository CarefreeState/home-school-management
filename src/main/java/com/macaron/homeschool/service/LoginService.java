package com.macaron.homeschool.service;

import com.macaron.homeschool.model.dto.UserLoginDTO;
import com.macaron.homeschool.model.vo.UserLoginVO;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 11:22
 */
public interface LoginService {

    String BASE_NAME = "LoginService";

    UserLoginVO login(UserLoginDTO userLoginDTO);

}
