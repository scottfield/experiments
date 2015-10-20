package com.gnum.experiments.aop.demo.aop;

import com.gnum.experiments.aop.demo.FormInputInvalidException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * @author jackie
 * @date 2015/10/18
 */
@Aspect
@Component
public class FormValidationAop {
    @Before("execution(* com.gnum.experiments.aop.demo.controller..*(..))")
    public void validate(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (Errors.class.isAssignableFrom(arg.getClass())) {
                Errors errors = (Errors) arg;
                if (errors.hasErrors()) {
                    throw new FormInputInvalidException(errors);
                }
            }

        }

    }
}
