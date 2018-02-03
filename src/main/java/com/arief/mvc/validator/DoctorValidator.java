package com.arief.mvc.validator;

import com.arief.mvc.entity.Doctor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class DoctorValidator implements Validator{

    public boolean supports(Class<?> aClass) {
        return Doctor.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"doctorId","id_required","Id must not be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"doctorName","name_required","name must not be empty");
    }
}
