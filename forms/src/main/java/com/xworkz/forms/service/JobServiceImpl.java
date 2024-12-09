package com.xworkz.forms.service;

import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService{

    public  JobServiceImpl()
    {
        System.out.println("created JobServiceImpl");
    }

    @Override
    public boolean validateAndSave() {
        System.out.println("validateAndSave in JobServiceImpl");
        return true;
    }
}
