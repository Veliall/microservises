package com.example.users.mapper;

import com.example.users.dto.UserDto;
import com.example.users.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDto> fromEntities(List<UserEntity> entities);
}
