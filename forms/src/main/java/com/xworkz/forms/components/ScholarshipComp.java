package com.xworkz.forms.components;

import com.xworkz.forms.dto.ScholarshipDTO;
import com.xworkz.forms.service.ScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ScholarshipComp {

    @Autowired
    private ScholarshipService scholarshipService;

    public ScholarshipComp()
    {
        System.out.println("created ScholarshipComp");
    }

    @RequestMapping("/scholar")
    public String scholarForm(ScholarshipDTO scholarshipDTO)
    {
        System.out.println("scholarForm in FormsComponent");
        System.out.println(scholarshipDTO);
        boolean saved = scholarshipService.validateAndSave();
        if (saved)
        {
            System.out.println("saved");
        }
        else
        {
            System.out.println("not saved");
        }
        return "Scholarship.jsp";
    }
}
