package com.example.aggregator.client;

import com.example.aggregator.dto.PaymentsResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "data")
public interface DataClient {
  @GetMapping("/api/payments?page={page}&count={count}")
  List<PaymentsResponseDto> getPayments(@PathVariable int page, @PathVariable int count);
}
