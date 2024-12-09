//package com.xworkz.forms.controller;
//
//import com.xworkz.forms.dto.HotelDTO;
//import com.xworkz.forms.service.HotelService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/")
//public class HotelController {
//
//    @Autowired
//    private HotelService hotelService;
//
//    public HotelController()
//    {
//        System.out.println("created HotelController");
//    }
//
//    @RequestMapping("/hotel")
//    public String hotelForm(HotelDTO hotelDTO)
//    {
//        System.out.println("hotelForm in HotelController");
//        System.out.println(hotelDTO);
//        boolean saved = hotelService.validateAndSave();
//
//        if(saved)
//        {
//            System.out.println("Data is saved");
//        }
//        else
//        {
//            System.out.println("Data is not saved");
//        }
//
//        return "Hotel.jsp";
//    }
//
//
//}
