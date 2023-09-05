package com.gis.mapper;

import org.mapstruct.Mapper;

import com.gis.dto.UserDto;
import com.gis.entity.UserEntity;

@Mapper
public interface AutoUserMapper {


    UserDto mapToUserDto(UserEntity userEntity);

    UserEntity mapToUser(UserDto userDto);
}