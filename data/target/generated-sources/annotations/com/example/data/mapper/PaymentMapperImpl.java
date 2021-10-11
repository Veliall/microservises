package com.example.data.mapper;

import com.example.data.dto.PaymentDto;
import com.example.data.entity.PaymentEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public List<PaymentDto> fromEntities(List<PaymentEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PaymentDto> list = new ArrayList<PaymentDto>( entities.size() );
        for ( PaymentEntity paymentEntity : entities ) {
            list.add( paymentEntityToPaymentDto( paymentEntity ) );
        }

        return list;
    }

    protected PaymentDto paymentEntityToPaymentDto(PaymentEntity paymentEntity) {
        if ( paymentEntity == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setId( paymentEntity.getId() );
        paymentDto.setSenderId( paymentEntity.getSenderId() );
        paymentDto.setSenderCardNumber( paymentEntity.getSenderCardNumber() );
        paymentDto.setAddresseeCardNumber( paymentEntity.getAddresseeCardNumber() );
        paymentDto.setAmount( paymentEntity.getAmount() );
        paymentDto.setComment( paymentEntity.getComment() );

        return paymentDto;
    }
}
