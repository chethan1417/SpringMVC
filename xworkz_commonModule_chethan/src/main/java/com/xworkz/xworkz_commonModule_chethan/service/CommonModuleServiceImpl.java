package com.xworkz.xworkz_commonModule_chethan.service;

import com.xworkz.xworkz_commonModule_chethan.dto.CommonModuleDTO;
import com.xworkz.xworkz_commonModule_chethan.entity.CommonModuleEntity;
import com.xworkz.xworkz_commonModule_chethan.repository.CommonModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class CommonModuleServiceImpl implements CommonModuleService {

    @Autowired
    CommonModuleRepository commonModuleRepository;


    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    CommonModuleEntity commonModuleEntity=new CommonModuleEntity();

    private final static String character = "ABCDEFGHIJKLMNOPQRSTQUVWXYZabcdefghijkmloppqrstuvxxyz09876554321@";

    public CommonModuleServiceImpl() {
        System.out.println("Created CommonModuleServiceImpl");
    }

    @Override
    public boolean validateAndSave(CommonModuleDTO commonModuleDTO) {

        boolean isValid = false;

        if (commonModuleDTO != null) {
            if (commonModuleDTO.getName() != null) {
                commonModuleEntity.setName(commonModuleDTO.getName());
                isValid = true;
            }

            if (commonModuleDTO.getEmail() != null) {
                commonModuleEntity.setEmail(commonModuleDTO.getEmail());
                isValid = true;
            }

            if (commonModuleDTO.getPh() != null) {
                commonModuleEntity.setPh(commonModuleDTO.getPh());
                isValid = true;
            }

            if (commonModuleDTO.getAlterEmail() != null) {
                commonModuleEntity.setAlterEmail(commonModuleDTO.getAlterEmail());
                isValid = true;
            }
            if (commonModuleDTO.getAlterPh() != null) {
                commonModuleEntity.setAlterPh((commonModuleDTO.getAlterPh()));
                isValid = true;
            }

            if (commonModuleDTO.getLocation() != null) {
                commonModuleEntity.setLocation(commonModuleDTO.getLocation());
                isValid = true;
            }

            if (commonModuleDTO.getEmail() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                SecureRandom secureRandom = new SecureRandom();
                for (int i = 0; i < 9; i++) {
                    int index = secureRandom.nextInt(character.length());
                    stringBuilder = stringBuilder.append(character.charAt(index));
                }
                commonModuleEntity.setPassword(stringBuilder.toString());
                isValid = true;
            }
            commonModuleEntity.setSigninCount(-1);
            if (isValid) {
                commonModuleRepository.save(commonModuleEntity);
            }
        }
        return isValid;

    }

    @Override
    public Long getCountofName(String name) {
        return commonModuleRepository.getCountOfName(name);
    }

    @Override
    public Long getCountofEmail(String email) {
        return commonModuleRepository.getCountOfEmail(email);
    }

    @Override
    public Long getCountofPhone(String phone) {
        return commonModuleRepository.getCountOfPhone(phone);
    }

    @Override
    public Long getCountofAlterEmail(String alterEmail) {
        return commonModuleRepository.getCountOfAlterEmail(alterEmail);
    }

    @Override
    public Long getCountofAlterPhone(String alterPhone) {
        return commonModuleRepository.getCountOfAlterPhone(alterPhone);
    }

    @Override
    public String onSignin(String email, String password) {
        CommonModuleEntity commonModuleEntity1 =commonModuleRepository.onSignin(email);
        if (commonModuleEntity1!=null){
            if (bCryptPasswordEncoder.matches(password,commonModuleEntity.getPassword())){
                return commonModuleEntity.getName();
            }
            return null;
        }
        return null;
    }

    @Override
    public boolean onUpdate(String email, String newPassword, String confirmPassword) {
        if (newPassword.equals(confirmPassword)){
            CommonModuleEntity commonModuleEntity1=commonModuleRepository.getData(email);
            if (commonModuleEntity1!=null)
            {
                commonModuleEntity.setPassword(bCryptPasswordEncoder.encode(confirmPassword));
                commonModuleEntity.setSigninCount(0);
                return commonModuleRepository.onUpdate(commonModuleEntity);
            }
            return false;
        }
        return false;
    }


}
