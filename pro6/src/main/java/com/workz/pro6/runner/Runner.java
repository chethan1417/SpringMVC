package com.workz.pro6.runner;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Runner extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

   public Runner()
   {
       System.out.println("no arg const of pro6");
   }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        String[]  url={"/"};
        System.out.println("config url for dispatched server");
        return url;    }
}
