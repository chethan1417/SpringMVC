package com.xworkz.forms.components;

import com.xworkz.forms.dto.HotelDTO;
import com.xworkz.forms.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HotelComp {

    @Autowired
    private HotelService hotelService;
    public HotelComp()
    {
        System.out.println("created HotelComp");
    }

    @RequestMapping("/hotel")
    public String hotelForm(HotelDTO hotelDTO)
    {
        System.out.println("hotelForm in HotelComp");
        System.out.println(hotelDTO);
        boolean saved = hotelService.validateAndSave();
        if(saved)
        {
            System.out.println("saved");
        }
        else
        {
            System.out.println("not saved");
        }
        return "Hotel.jsp";
    }

}
