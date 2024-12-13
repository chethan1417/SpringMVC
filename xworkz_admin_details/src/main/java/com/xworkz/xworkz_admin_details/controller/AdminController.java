package com.xworkz.xworkz_admin_details.controller;

import com.xworkz.xworkz_admin_details.dto.AdminDTO;
import com.xworkz.xworkz_admin_details.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    AdminService adminService;

    public AdminController()
    {
    System.out.println("created AdminController");
    }

    @PostMapping("/xworkz")
    public String onSave(AdminDTO adminDTO)
    {
        System.out.println("onSave in AdminController");
        System.out.println(adminDTO);
        boolean saved=adminService.validateAndSave(adminDTO);
        if (saved)
        {
            System.out.println("Data is saved");
            return "Success.jsp";
        }
        else
        {
            System.out.println("Data Not saved");
        }
        return "index.jsp";
    }




}
