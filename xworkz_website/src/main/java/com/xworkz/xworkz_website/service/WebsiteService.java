package com.xworkz.xworkz_website.service;

import com.xworkz.xworkz_website.dto.WebsiteDTO;

public interface WebsiteService {

    String validateAndSave(WebsiteDTO websiteDTO);
     String validateAndLogin(String email, String password);
     WebsiteDTO getUserDetails(String email);

}
