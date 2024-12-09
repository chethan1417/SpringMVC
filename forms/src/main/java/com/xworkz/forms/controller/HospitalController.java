package com.xworkz.forms.controller;

import com.xworkz.forms.dto.HospitalDTO;
import com.xworkz.forms.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    public HospitalController()
    {
        System.out.println("created HospitalController");
    }

    @RequestMapping("/hospital")
    public String hospForm(HospitalDTO hospitalDTO)
    {
        System.out.println("hospForm in HospitalController");
        System.out.println(hospitalDTO);
       boolean saved =  hospitalService.validateAndSave();
       if (saved)
       {
           System.out.println("saved");
       }
       else
       {
           System.out.println("Not saved");
       }
        return "Hospital.jsp";
    }
}
