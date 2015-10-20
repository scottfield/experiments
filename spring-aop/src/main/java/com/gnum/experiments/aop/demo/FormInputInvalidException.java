package com.gnum.experiments.aop.demo;

import org.springframework.validation.Errors;

/**
 * @author jackie
 * @date 2015/10/19
 */
public class FormInputInvalidException extends RuntimeException {
    private Errors errors;

    public FormInputInvalidException(Errors errors) {
        super();
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
