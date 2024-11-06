package com.macaron.homeschool.model.converter;

import com.macaron.homeschool.model.dto.UserRegisterDTO;
import com.macaron.homeschool.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 11:09
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mapping(target = "userType", expression = "java(com.macaron.homeschool.common.enums.UserType.get(userRegisterDTO.getUserType()))")
    User userRegisterDTOToUser(UserRegisterDTO userRegisterDTO);

}
