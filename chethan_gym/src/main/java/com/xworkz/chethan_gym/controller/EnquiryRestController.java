package com.xworkz.chethan_gym.controller;

import com.xworkz.chethan_gym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class EnquiryRestController {

    @Autowired
    GymService gymService;

    @GetMapping(value = "/phone/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onPhone(@PathVariable String phone) {
        Long count = gymService.getCountofPhone(phone);
        System.out.println(gymService.getCountofPhone(phone));
        if (count > 0) {
            return "Phone Already exists";
        }
        return "";
    }
}
