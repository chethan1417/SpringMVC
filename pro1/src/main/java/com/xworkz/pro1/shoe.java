package com.xworkz.pro1;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class shoe extends AbstractAnnotationConfigDispatcherServletInitializer {



   public shoe()
    {
        System.out.println("no arg const of shoe");
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
        return url;
    }
}
