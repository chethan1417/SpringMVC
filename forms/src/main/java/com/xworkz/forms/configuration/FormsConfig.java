package com.xworkz.forms.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.forms")
@EnableWebMvc

public class FormsConfig {

    public FormsConfig()
    {
        System.out.println("created FormsConfig");
    }

}
