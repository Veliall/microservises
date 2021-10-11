package com.example.aggregator.client;

import com.example.aggregator.dto.UsersRequestDto;
import com.example.aggregator.dto.UsersResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "users")
public interface UserClient {
    @PostMapping("/api/users")
    List<UsersResponseDto> getUsers(@RequestBody UsersRequestDto ids);
}
