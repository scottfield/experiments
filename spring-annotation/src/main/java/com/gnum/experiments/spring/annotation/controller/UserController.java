package com.gnum.experiments.spring.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jackie
 * @date 2015/9/21
 */
@Controller
@RequestMapping("/index")
public class UserController {
    @RequestMapping("")
    public String indexView() {
        return "index";
    }

    @RequestMapping("/user")
    @ResponseBody
    public Object getUser() {
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("name","jackie");
        user.put("sex", "male");
        user.put("age", 26);
        return user;
    }

}
