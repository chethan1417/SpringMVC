package com.xworkz.xworkz_website.service;

import com.xworkz.xworkz_website.dto.WebsiteDTO;
import com.xworkz.xworkz_website.entity.WebsiteEntity;
import com.xworkz.xworkz_website.repository.WebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class WebsiteServiceImpl implements WebsiteService{

    public WebsiteServiceImpl()
    {
        System.out.println("created WebsiteServiceImpl");
    }

    @Autowired
    WebsiteRepository websiteRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public String validateAndSave(WebsiteDTO websiteDTO) {

        String errorMessage = null;

        if (websiteDTO != null) {
            String name = websiteDTO.getName();

            if (name.length() < 10) {
                errorMessage = "Invalid Name:it should contain minimum of 10 characters";
                System.err.println("Invalid Name:it should contain minimum of 10 characters");

            } else {
                int age = websiteDTO.getAge();
                if (age <= 18) {
                    errorMessage = "Invalid Age:Age must be greater than 18";
                    System.err.println("Invalid Age:Age must be greater than 18");
                } else {
                    String email = websiteDTO.getEmail();
                    if (!email.contains("@") || !email.endsWith("gmail.com")) {
                        errorMessage = "Invalid Email:email must have @ and it should end with gmail.com";
                        System.err.println("Invalid Email:email must have @ and it should end with gmail.com");
                    } else {
                        String password = websiteDTO.getPassword();
                        if (password.length() < 7 || !password.matches(".*[^a-zA-Z0-9].*[^a-zA-Z0-9].*")) {
                            errorMessage = "Invalid Password";
                            System.err.println("Invalid Password");
                        } else {
                            String cPassword = websiteDTO.getCPassword();
                            if (!cPassword.equals(password)) {
                                errorMessage = "Password and Confirm Password doesn't match";
                                System.err.println("Password and Confirm Password doesn't match");
                            } else {
                                String ph = websiteDTO.getPh();
                                if (!ph.startsWith("9") || ph.length() != 10) {
                                    errorMessage = "Invalid Contact Number:Contact Number should have 10 characters and must start with 9";
                                    System.err.println("Invalid Contact Number:Contact Number should have 10 characters and must start with 9");
                                } else {
                                    WebsiteEntity websiteEntity = new WebsiteEntity();
                                    websiteEntity.setName(websiteDTO.getName());
                                    websiteEntity.setEmail(websiteDTO.getEmail());
                                    websiteEntity.setAge(websiteDTO.getAge());
                                    websiteEntity.setPassword(bCryptPasswordEncoder.encode(websiteDTO.getPassword()));
                                    websiteEntity.setPh(websiteDTO.getPh());
                                    websiteRepository.save(websiteEntity);
                                    errorMessage = "Validation successful";
                                    System.out.println("Validation successful");
                                }
                            }
                        }
                    }
                }
            }
        }


        return errorMessage;
    }


    @Override
    public String validateAndLogin(String email, String password) {
        WebsiteEntity websiteEntity = websiteRepository.findByEmail(email);

        if (websiteEntity != null)
        {
            if (bCryptPasswordEncoder.matches(password, websiteEntity.getPassword())) {
                return websiteEntity.getName();
            } else {
                return "Invalid email or password";
            }
        }

        return "Invalid email or password";

    }

    @Override
    public WebsiteDTO getUserDetails(String email) {
        WebsiteEntity websiteEntity = websiteRepository.findByEmail(email);
        if (websiteEntity != null) {
            WebsiteDTO websiteDTO = new WebsiteDTO();
            websiteDTO.setName(websiteEntity.getName());
            websiteDTO.setEmail(websiteEntity.getEmail());
            websiteDTO.setAge(websiteEntity.getAge());
            websiteDTO.setPh(websiteEntity.getPh());
            return websiteDTO;
        }
        return null;
    }


}
