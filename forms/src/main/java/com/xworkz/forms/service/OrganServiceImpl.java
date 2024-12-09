package com.xworkz.forms.service;

import org.springframework.stereotype.Service;

@Service
public class OrganServiceImpl implements OrganService{

    public  OrganServiceImpl()
    {
        System.out.println("created OrganServiceImpl");
    }

    @Override
    public boolean validateAndSave() {
        System.out.println(" validateAndSave in OrganServiceImpl");
        return true;
    }
}
