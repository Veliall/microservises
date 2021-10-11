package com.example.data.rest;

import com.example.data.dto.PaymentDto;
import com.example.data.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class DataController {
    private final DataService dataService;

    @GetMapping("/payments")
    public List<PaymentDto> getPayments(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "50") @Min(10) @Max(50) int count,
            @RequestHeader Optional<String> authorization
    ) {
        return dataService.findAll(page, count);
    }
}
