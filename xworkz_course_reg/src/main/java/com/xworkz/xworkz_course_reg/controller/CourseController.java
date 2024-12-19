package com.xworkz.xworkz_course_reg.controller;

import com.xworkz.xworkz_course_reg.dto.CourseDTO;
import com.xworkz.xworkz_course_reg.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController() {
        System.out.println("created CourseController");
    }

    @PostMapping("/xworkz")
    public String onSave(CourseDTO courseDTO, Model model) {
        System.out.println("created onSave in CourseController");
        String validationMessage = courseService.validateAndSave(courseDTO);

        if ("Validation successful".equals(validationMessage)) {
            model.addAttribute("success", "Signup successful");
            return "Success.jsp";
        } else {
            model.addAttribute("failure", validationMessage);
            model.addAttribute("fail", "Invalid Data");
            return "Signup.jsp";
        }
    }

    @PostMapping("/signin")
    public String onSignIn(String email, String password, Model model) {
        System.out.println("created onSignIn in CourseController");
        String validationMessage = courseService.authenticateUser(email, password);

        if (validationMessage.equals("Authentication successful")) {
            String userName = courseService.getUserNameByEmail(email);
            model.addAttribute("userName", userName);
            return "Success.jsp";
        } else {
            model.addAttribute("error", "Given email and password do not match.");
            return "Signin.jsp";
        }
    }
}
