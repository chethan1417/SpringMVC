package com.xworkz.forms.components;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class FormsComponent {

    public FormsComponent()
    {
        System.out.println("created FormsComponent");
    }

    @RequestMapping("/forms")
    public String form()
    {
        System.out.println("form in FormsComponent");
        return "index.jsp";
    }

}
