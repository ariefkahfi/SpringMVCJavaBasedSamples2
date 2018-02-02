package com.arief.mvc.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
            MySpringAppContext.class
        };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
            MyWebAppContext.class
        };
    }

    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }
}
