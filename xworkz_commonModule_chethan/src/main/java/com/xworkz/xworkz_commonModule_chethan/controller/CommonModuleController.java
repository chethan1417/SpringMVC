package com.xworkz.xworkz_commonModule_chethan.controller;

import com.xworkz.xworkz_commonModule_chethan.dto.CommonModuleDTO;
import com.xworkz.xworkz_commonModule_chethan.entity.CommonModuleEntity;
import com.xworkz.xworkz_commonModule_chethan.service.CommonModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Controller
@RequestMapping("/")
public class CommonModuleController {

    private static final Logger log = LoggerFactory.getLogger(CommonModuleController.class);
    @Autowired
    CommonModuleService commonModuleService;

    public CommonModuleController() {
        log.info("Created CommonModuleController");
    }

    @GetMapping("/signup")
    public String onSignup() {
        return "Signup.jsp";
    }

    @PostMapping("/signup")
    public String onSave(CommonModuleDTO commonModuleDTO,Model model) {
        log.info("onSave in CommonModuleController");
        Set<ConstraintViolation<CommonModuleDTO>> valid = commonModuleService.validateAndSave(commonModuleDTO);
        if (valid==null ||valid.isEmpty()) {
            log.info("Data saved successfully");
            model.addAttribute("successmsg","SignUp Successfull");
            return "SignupSuccess.jsp";
        } else {
            log.info("Data validation failed");
            model.addAttribute("error",valid);
            model.addAttribute("dto",commonModuleDTO);
        }
        return "Signup.jsp";
    }

    @GetMapping("/signin")
    public String onSignin() {
        return "Signin.jsp";
    }

    @PostMapping("/signin")
    public String onSignin(@RequestParam String email, @RequestParam String password ) {
        log.info("onSignin in CommonModuleController");
        CommonModuleEntity result = commonModuleService.onSignin(email, password);
        if (result == null) {
            return "Signin.jsp";
        }
        if (result.getSigninCount()==-1)
        {
            return "PasswordUpdate.jsp";
        }
        if (result.getSigninCount()>=3)
        {
            return "Signin.jsp";
        }
        if (result.getSigninCount()==0)
        {
            return "Success.jsp";
        }
        return "Signin.jsp";
    }

    @PostMapping("/updatePassword")
    public String onUpdatePassword(@RequestParam String email, @RequestParam String newPassword, @RequestParam String confirmPassword) {
        log.info("onUpdatePassword in CommonModuleController");
        if (commonModuleService.onUpdate(email, newPassword, confirmPassword)) {
            return "Success.jsp";
        }
        return "PasswordUpdate.jsp";
    }

}
