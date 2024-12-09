package com.xworkz.forms.service;

import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService{

    public HotelServiceImpl()
    {
        System.out.println("created HotelServiceImpl");
    }

    @Override
    public boolean validateAndSave() {
        System.out.println("validateAndSave in HotelServiceImpl");
        return true;
    }
}
