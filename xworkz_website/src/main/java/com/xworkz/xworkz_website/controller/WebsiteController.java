package com.xworkz.xworkz_website.controller;

import com.xworkz.xworkz_website.dto.WebsiteDTO;
import com.xworkz.xworkz_website.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebsiteController {

    @Autowired
    private WebsiteService websiteService;

    public WebsiteController()
    {
        System.out.println("created WebsiteController");
    }

    @PostMapping("/signup")
    public String onSave(WebsiteDTO websiteDTO, Model model)
    {
        System.out.println("onSave in WebsiteController");
        System.out.println(websiteDTO);
       String validationMessage = websiteService.validateAndSave(websiteDTO);
        if ("Validation successful".equals(validationMessage)) {
            return "SignupSuccess.jsp";
        } else {
            model.addAttribute("failure", validationMessage);
            return "Signup.jsp";
        }
    }

    @PostMapping("/signin")
    public String onLogin(String email, String password, Model model) {
        System.out.println("onLogin in WebsiteController");
        String validationMessage = websiteService.validateAndLogin(email, password);
        if (!validationMessage.equals("Invalid email or password")) {
            WebsiteDTO userDetails = websiteService.getUserDetails(email);
            model.addAttribute("userName", validationMessage);
            model.addAttribute("userDetails", userDetails);
            return "Success.jsp";
        } else {
            model.addAttribute("error", validationMessage);
            return "Signin.jsp";
        }
    }

    @RequestMapping("/user")
    public String getUserDetails(String email, Model model) {
        WebsiteDTO userDetails = websiteService.getUserDetails(email);
        model.addAttribute("userName", userDetails.getName());
        model.addAttribute("userDetails", userDetails);
        return "Success.jsp";
    }


}
