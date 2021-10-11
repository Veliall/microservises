package com.example.data.mapper;

import com.example.data.dto.PaymentDto;
import com.example.data.entity.PaymentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
    List<PaymentDto> fromEntities(List<PaymentEntity> entities);
}
