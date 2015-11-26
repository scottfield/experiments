package com.gnum.experiments.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jackie
 * @date 2015/9/24
 */
@Configuration
@ComponentScan(basePackages = {"com.gnum.experiments"}, excludeFilters = @ComponentScan.Filter(Configuration.class))
public class AppConfig {
    @Bean
    public HandlerMapping handlerMapping() {
        return new DefaultAnnotationHandlerMapping();
    }
    @Bean
    public ViewResolver negotiationViewResolver() {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        List<View> views = new ArrayList<View>();
        views.add(new MappingJackson2JsonView());
       /* MarshallingView xmlView = new MarshallingView();
        xmlView.setMarshaller(new org.springframework.oxm.xstream.XStreamMarshaller());*/
        viewResolver.setDefaultViews(views);
        Map<String, String> mediaTypes = new HashMap<String, String>();
        mediaTypes.put("json", "application/json");
        mediaTypes.put("xml", "application/xml");
        viewResolver.setMediaTypes(mediaTypes);
        viewResolver.setOrder(0);
        return viewResolver;
    }
    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/WEB-INF/views/");
        return viewResolver;
    }
}
