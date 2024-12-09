package com.xworkz.forms.controller;

import com.xworkz.forms.dto.DeathCertificateDTO;
import com.xworkz.forms.service.DeathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DeathCertificateController {

    @Autowired
    private DeathService deathService;

    public DeathCertificateController()
    {
        System.out.println("created DeathCertificateController");
    }

    @RequestMapping("/death")
    public String  DeathCertificateForm(DeathCertificateDTO deathCertificateDTO)
    {
        System.out.println("DeathCertificateForm in DeathCertificateController");
        System.out.println(deathCertificateDTO);
        boolean saved = deathService.validateAndSave();
        if (saved)
        {
            System.out.println("saved");
        }
        else
        {
            System.out.println("not saved");
        }

        return "DeathCertificate.jsp";
    }

}
