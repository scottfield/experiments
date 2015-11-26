package com.gnum.experiments.aop.demo.controller;

import com.gnum.experiments.aop.demo.domain.User;
import com.gnum.experiments.aop.demo.form.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jackie
 * @date 2015/10/18
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "")
    public String login(@Valid User user,BindingResult error,Model model) {
        Map map =  new HashMap();
        map.put("username", "jackie");
        return "login";
    }
    @RequestMapping(value = "/test")
    public String test(Model model) {
        Map map =  new HashMap();
        map.put("username", "jackie");
        model.addAttribute(map);
        return "login";
    }
}
