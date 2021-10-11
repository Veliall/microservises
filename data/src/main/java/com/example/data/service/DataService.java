package com.example.data.service;

import com.example.data.data.Payment;
import com.example.data.dto.PaymentDto;
import com.example.data.entity.PaymentEntity;
import com.example.data.mapper.PaymentMapper;
import com.example.data.repository.PaymentsRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DataService {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final PaymentsRepository repository;
    private final PaymentMapper mapper;
    private final Sort sort = Sort.by(Sort.Direction.DESC, "id");

    public void save(Payment payment) {
       repository.save(new PaymentEntity(
               0L,
               payment.getSenderId(),
               payment.getSenderCardNumber(),
               payment.getAddresseeCardNumber(),
               payment.getAmount(),
               payment.getComment()
       ));
    }

    public List<PaymentDto> findAll(int page, int count) {
        return mapper.fromEntities(repository.findAll(PageRequest.of(page, count, sort)).toList());
    }
}