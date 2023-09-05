package com.gis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gis.dto.UserDto;
import com.gis.entity.UserEntity;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(UserEntity userEntity);

    UserEntity mapToUser(UserDto userDto);
}