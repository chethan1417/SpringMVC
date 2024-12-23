package com.xworkz.xworkz_commonModule_chethan.controller;

import com.xworkz.xworkz_commonModule_chethan.dto.CommonModuleDTO;
import com.xworkz.xworkz_commonModule_chethan.service.CommonModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CommonModuleController {

    @Autowired
    CommonModuleService commonModuleService;

    public CommonModuleController() {
        System.out.println("Created CommonModuleController");
    }

    @GetMapping("/signup")
    public String onSignup() {
        return "Signup.jsp";
    }

    @PostMapping("/signup")
    public String onSave(CommonModuleDTO commonModuleDTO) {
        System.out.println("onSave in CommonModuleController");
        boolean valid = commonModuleService.validateAndSave(commonModuleDTO);
        if (valid) {
            System.out.println("Data saved successfully");
            return "SignupSuccess.jsp";
        } else {
            System.out.println("Data validation failed");
        }
        return "Signup.jsp";
    }

    @GetMapping("/signin")
    public String onSignin() {
        return "Signin.jsp";
    }

    @PostMapping("/signin")
    public String onSignin(@RequestParam String email, @RequestParam String password) {
        System.out.println("onSignin in CommonModuleController");
        String result = commonModuleService.onSignin(email, password);
        if (result != null) {
            return "Success.jsp";
        }
        return "PasswordUpdate.jsp";
    }

    @PostMapping("/updatePassword")
    public String onUpdatePassword(@RequestParam String email, @RequestParam String newPassword, @RequestParam String confirmPassword) {
        System.out.println("onUpdatePassword in CommonModuleController");
        if (commonModuleService.onUpdate(email, newPassword, confirmPassword)) {
            return "Success.jsp";
        }
        return "PasswordUpdate.jsp";
    }
}
