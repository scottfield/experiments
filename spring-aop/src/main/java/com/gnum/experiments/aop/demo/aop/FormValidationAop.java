package com.gnum.experiments.aop.demo.aop;

import com.gnum.experiments.aop.demo.FormInputInvalidException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

/**
 * @author jackie
 * @date 2015/10/18
 */
@Aspect
@Component
public class FormValidationAop {
    @Before(value = "execution(* com.gnum.experiments.aop.demo.controller.*.*(@javax.validation.Valid (*),org.springframework.validation.BindingResult,..))&&args(target,error,..)")
    public void validate(Object target, BindingResult error) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(target.getClass().getName());
        String className = target.getClass().getName();
        String validatorName = className + "Validator";
        Class clazz = Class.<Validator>forName(validatorName);
        Validator validator = BeanUtils.<Validator>instantiate(clazz);
        validator.validate(target, error);
        if (error.hasErrors()) {
            throw new FormInputInvalidException(error);
        }
    }
}
