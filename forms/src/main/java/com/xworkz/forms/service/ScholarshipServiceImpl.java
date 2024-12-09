package com.xworkz.forms.service;

import org.springframework.stereotype.Service;

@Service
public class ScholarshipServiceImpl implements ScholarshipService{

     public ScholarshipServiceImpl()
     {
         System.out.println("created ScholarshipServiceImpl");
     }
    @Override
    public boolean validateAndSave() {
        System.out.println("validateAndSave in ScholarshipServiceImpl");
        return true;
    }
}
