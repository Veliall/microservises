package com.example.aggregator;

import com.example.aggregator.client.DataClient;
import com.example.aggregator.client.UserClient;
import com.example.aggregator.dto.PaymentWithUsernameResponseDto;
import com.example.aggregator.dto.PaymentsResponseDto;
import com.example.aggregator.dto.UsersRequestDto;
import com.example.aggregator.util.PaymentAndUserUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableFeignClients
@RestController
@RequiredArgsConstructor
@CommonsLog
public class AggregatorApplication {
    private final UserClient userClient;
    private final DataClient dataClient;


    @GetMapping("/api/payments")
    public List<PaymentWithUsernameResponseDto> getPayments() {
        final var payments = dataClient.getPayments(0, 10);
        final var collect = payments.stream().map(PaymentsResponseDto::getSenderId).collect(Collectors.toList());
        final var users = userClient.getUsers(new UsersRequestDto(collect));
        final Map<Long, String> usernames = new HashMap<>();
        users.forEach(user -> usernames.put(user.getId(), user.getName()));

        return payments.stream()
                .map(o -> PaymentAndUserUtils.bind(o, usernames.get(o.getSenderId())))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication.run(AggregatorApplication.class, args);
    }
}
