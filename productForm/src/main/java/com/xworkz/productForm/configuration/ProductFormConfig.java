package com.xworkz.productForm.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.productForm")
@EnableWebMvc
public class ProductFormConfig {

    public ProductFormConfig()
    {
        System.out.println("created ProductFormConfig");
    }
}
