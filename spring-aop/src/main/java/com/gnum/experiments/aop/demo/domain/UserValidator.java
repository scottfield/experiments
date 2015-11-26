package com.gnum.experiments.aop.demo.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author jackie
 * @date 2015/10/23
 */
public class UserValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name","user.name");
        ValidationUtils.rejectIfEmpty(errors,"password","user.password");
    }
}
