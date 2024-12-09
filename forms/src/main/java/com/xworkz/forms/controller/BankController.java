package com.xworkz.forms.controller;

import com.xworkz.forms.dto.BankDTO;
import com.xworkz.forms.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BankController {

    @Autowired
    private BankService bankService;

   public BankController()
   {
       System.out.println("created Bank controller");
   }

    @RequestMapping("/bank")
    public String bankForm(BankDTO bankDTO)
   {
       System.out.println("bankForm in BankController");
       System.out.println(bankDTO);
       boolean saved = bankService.validateAndSave();
       if (saved)
       {
           System.out.println("saved");
       }
       else
       {
           System.out.println("Not saved");
       }
       return "Bank.jsp";
   }

}
