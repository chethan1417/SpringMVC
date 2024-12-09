package com.xworkz.forms.service;

import org.springframework.stereotype.Service;

@Service
public class MatrimonyServiceImpl implements MatrimonyService{

    public  MatrimonyServiceImpl()
    {
        System.out.println("created MatrimonyServiceImpl");
    }

    @Override
    public boolean validateAndSave() {
        System.out.println("validateAndSave in MatrimonyServiceImpl");
        return true;
    }
}
