package com.xworkz.forms.components;

import com.xworkz.forms.dto.OrganDTO;
import com.xworkz.forms.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class OrganComp {

    @Autowired
    private OrganService organService;
    public OrganComp()
    {
        System.out.println("created OrganComp");
    }

    @RequestMapping("/organ")
    public String organForm(OrganDTO organDTO)
    {
        System.out.println("organForm in OrganComp");
        System.out.println(organDTO);
        boolean saved = organService.validateAndSave();
        if (saved)
        {
            System.out.println("saved");
        }
        else
        {
            System.out.println("not saved");
        }
        return "Organ.jsp";
    }

}
