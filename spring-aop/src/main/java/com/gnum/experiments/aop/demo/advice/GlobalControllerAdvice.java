package com.gnum.experiments.aop.demo.advice;

import com.gnum.experiments.aop.demo.FormInputInvalidException;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jackie
 * @date 2015/10/18
 */
@ControllerAdvice
public class GlobalControllerAdvice {
    private final Logger logger = Logger.getLogger(GlobalControllerAdvice.class);
    private final String suffix = "Validator";

    private static final int FIELD_NAME_POSITION = 2;
    private static final String errorCodeSeperator = "\\.";

    @InitBinder
    public void globalInitBinder(WebDataBinder binder) {
        String className = binder.getTarget().getClass().getName();
        String validatorName = className + suffix;
        try {
            BeanUtils.instantiate(Class.<Validator>forName(validatorName));
            Validator validator = (Validator) Class.forName(validatorName).newInstance();
            binder.setValidator(validator);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @ExceptionHandler
    @ResponseBody
    public Object exceptionHandler(Exception ex, HttpServletRequest request) {
        Errors errors = ((FormInputInvalidException) ex).getErrors();
        RequestContext requestContext = new RequestContext(request);
        Map<String, String> errorMessages = new HashMap<String, String>();
        for (ObjectError fieldError : errors.getAllErrors()) {
            String errorCode = fieldError.getCode();
            String errorMessage = requestContext.getMessage(errorCode);
            errorMessages.put(parseFieldName(errorCode), errorMessage);
        }
        return errorMessages;
    }

    private String parseFieldName(String errorCode) {
        String[] names = errorCode.split(errorCodeSeperator);
        if (names.length < 3) {
            logger.debug("malformed errorCode==>" + errorCode + " the result filed name will use the error code as name .");
            return errorCode;
        }
        return names[FIELD_NAME_POSITION];
    }
}
