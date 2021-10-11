package com.example.users.rest;

import com.example.users.dto.UserDto;
import com.example.users.dto.UsersRequestDto;
import com.example.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {
    private final UserService service;

    @PostMapping("/users")
    public List<UserDto> getUsers(@RequestHeader Optional<String> authorization,
                                  @RequestBody UsersRequestDto usersRequestDto) {
        return service.getAll(usersRequestDto.getUsersId());
    }
}
