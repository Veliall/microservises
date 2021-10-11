package com.example.producer.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllowedCardNumberValidator implements ConstraintValidator<AllowedCardNumber, String> {
    @Override
    public void initialize(AllowedCardNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile("^[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}$");
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }
}
