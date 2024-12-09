package com.xworkz.forms.components;

import com.xworkz.forms.dto.MatrimonyDTO;import com.xworkz.forms.service.MatrimonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MatrimonyComp {

    @Autowired
    private MatrimonyService matrimonyService;

    public MatrimonyComp()
    {
        System.out.println("created MatrimonyComp");
    }

    @RequestMapping("/matrimony")
    public String matrimonyForm(MatrimonyDTO matrimonyDTO)
    {
        System.out.println("matrimonyForm in MatrimonyComp");
        System.out.println(matrimonyDTO);
        boolean saved= matrimonyService.validateAndSave();
        if (saved)
        {
            System.out.println("saved");
        }
        else
        {
            System.out.println("not saved");
        }
        return "Matrimony.jsp";
    }
}
