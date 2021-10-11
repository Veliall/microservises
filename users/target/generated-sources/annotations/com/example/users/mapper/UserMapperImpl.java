package com.example.users.mapper;

import com.example.users.dto.UserDto;
import com.example.users.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public List<UserDto> fromEntities(List<UserEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( entities.size() );
        for ( UserEntity userEntity : entities ) {
            list.add( userEntityToUserDto( userEntity ) );
        }

        return list;
    }

    protected UserDto userEntityToUserDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( userEntity.getId() );
        userDto.setName( userEntity.getName() );

        return userDto;
    }
}
