package com.example.users.service;

import com.example.users.dto.UserDto;
import com.example.users.mapper.UserMapper;
import com.example.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final UserRepository repository;
    private final UserMapper mapper;

    public List<UserDto> getAll(List<Long> usersId) {
        logger.info(mapper.fromEntities(repository.findAllById(usersId)));
        return mapper.fromEntities(repository.findAllById(usersId));
    }
}