package com.gnum.experiments.spring.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * @author jackie
 * @date 2015/9/21
 */
@WebAppConfiguration
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.gnum.experiments")
public class MVCConfig extends WebMvcConfigurerAdapter {
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/views/");
        return configurer;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
      registry.freeMarker().suffix(".html").viewClass(FreeMarkerView.class);
    }
}
