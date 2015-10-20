package com.gnum.experiments.aop.demo.form;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author jackie
 * @date 2015/10/18
 */
public class UserDtoValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "form.user.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "form.user.password.empty");
    }
}
