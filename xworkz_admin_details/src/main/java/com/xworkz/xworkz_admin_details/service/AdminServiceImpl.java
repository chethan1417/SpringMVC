package com.xworkz.xworkz_admin_details.service;

import com.xworkz.xworkz_admin_details.dto.AdminDTO;
import com.xworkz.xworkz_admin_details.entity.AdminEntity;
import com.xworkz.xworkz_admin_details.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;
    AdminEntity adminEntity = new AdminEntity();


    public AdminServiceImpl() {
        System.out.println("created AdminServiceImpl");
    }

    @Override
    public boolean validateAndSave(AdminDTO adminDTO) {
        System.out.println("created validateAndSave in AdminServiceImpl");
        boolean valid = true;

        if (adminDTO != null) {
            String name = adminDTO.getName();
            if (name.length() >= 10 && name.matches("^[a-zA-Z0-9]*$")) {
                System.out.println("Valid Name");
            } else {
                System.out.println("Invalid Name");
                valid = false;
            }

            int age = adminDTO.getAge();
            if (age > 18) {
                System.out.println("valid age");
            } else {
                System.out.println("Invalid age");
                valid = false;
            }

            String email = adminDTO.getEmail();
            if (email.contains("@") && email.endsWith("gmail.com")) {
                System.out.println("valid email");
            } else {
                System.out.println("Invalid email");
                valid = false;
            }

            String password = adminDTO.getPassword();
            if (password.length() >= 7 && password.matches(".*[^a-zA-Z0-9].*[^a-zA-Z0-9].*")) {
                System.out.println("valid password");
            } else {
                System.out.println("invalid password");
                valid = false;
            }

            String cPassword = adminDTO.getCPassword();
            if (cPassword.equals(password))
            {
                System.out.println("valid Confirm password");
            } else{
                System.out.println("Invalid Confirm Password");
            }

            String ph = adminDTO.getPh();
            if (ph.startsWith("9") && ph.length() == 10) {
                System.out.println("valid Contact Number");
            } else {
                System.out.println("invalid Contact number");
                valid = false;
            }

        }
        if (valid) {
            adminEntity.setName(adminDTO.getName());
            adminEntity.setAge(adminDTO.getAge());
            adminEntity.setEmail(adminDTO.getEmail());
            adminEntity.setPassword(adminDTO.getPassword());
            adminEntity.setCPassword(adminDTO.getCPassword());
            adminEntity.setPh(adminDTO.getPh());
            adminRepository.save(adminEntity);
            System.out.println(adminEntity.toString());
        }
        return valid;
    }

}
