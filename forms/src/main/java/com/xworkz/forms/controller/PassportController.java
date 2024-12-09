package com.xworkz.forms.controller;

import com.xworkz.forms.dto.PassportDTO;
import com.xworkz.forms.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PassportController {

    @Autowired
    private PassportService passportService;

    public PassportController()
    {
        System.out.println("created PassportController");
    }

    @RequestMapping("/passport")
    public String passportForm(PassportDTO passportDTO)
    {
        System.out.println("passportForm in PassportController");
        System.out.println(passportDTO);
        boolean saved = passportService.validateAndSave();
        if (saved)
        {
            System.out.println("saved");
        }
        System.out.println("Not saved");
        return "Passport.jsp";
    }

}
