package com.gnum.experiments.controller;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jackie
 * @date 2015/10/7
 */
@Controller
@RequestMapping("/user")
public class RestControllerDemo {
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Object get(String id) {
        System.out.println("-->get user with id:" + id);
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("name", "jackie");
        user.put("sex", "male");

        return user;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Object post(@RequestParam Map<String, Object> user, HttpServletRequest request) {
        System.out.println("-->add user");
        System.out.println(user);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("message", "success");
        result.put("code", 1000);
        return result;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Object put(@RequestParam Map<String, Object> user, HttpServletRequest request) {
        System.out.println("-->update user");
        System.out.println(user);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("message", "success");
        result.put("code", 1000);
        return result;
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public Object delete(String id) {
        System.out.println("-->delete user with id:" + id);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("message", "success");
        result.put("code", 1000);
        return result;
    }

    public static void main(String[] args) throws URISyntaxException {
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();
        form.add("company", "gnum");
        form.add("id", "gnum");
        form.add("password", "12345");
        form.add("user",new User());
        Map<String, String> defaultHeaders = new HashMap<String, String>();
        defaultHeaders.put("name", "jackie");
        defaultHeaders.put("api", "another value");
        RestClient.configureDefaultHttpHeaders(defaultHeaders);
        Map result = RestClient.put("http://localhost:8080/user", Map.class, null, form);
        System.out.println(result);
    }
}
