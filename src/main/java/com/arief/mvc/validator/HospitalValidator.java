package com.arief.mvc.validator;

import com.arief.mvc.entity.Hospital;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class HospitalValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return Hospital.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"hospitalId","required_id","id must not be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"hospitalName","required_name","name must not be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"hospitalAddress","required_address","address must not be empty");
    }
}
