package com.gnum.experiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jackie
 * @date 2015/9/24
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/getjson")
    public Object getJson() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "jackie");
        map.put("sex", "male");
        map.put("age", 22);
        ModelAndView result = new ModelAndView();
        result.addAllObjects(map);
        return result;
    }
    @RequestMapping("/jsp")
    public String getIndex() {
        return "index";
    }
}
