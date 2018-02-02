package com.arief.mvc.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.arief.mvc.controllers"})
public class MyWebAppContext implements WebMvcConfigurer{


    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry
                .jsp("/WEB-INF/views/",".jsp")
                .viewClass(JstlView.class);
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/assets/");
    }
}
