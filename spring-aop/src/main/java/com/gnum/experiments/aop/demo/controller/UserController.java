package com.gnum.experiments.aop.demo.controller;

import com.gnum.experiments.aop.demo.form.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author jackie
 * @date 2015/10/18
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "")
    public String login(@Valid UserDto userDto,BindingResult errors) {
        System.out.println(errors.getModel());
        System.out.println(userDto);
        return "login";
    }
}
