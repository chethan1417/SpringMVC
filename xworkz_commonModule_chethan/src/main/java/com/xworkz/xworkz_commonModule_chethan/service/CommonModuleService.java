package com.xworkz.xworkz_commonModule_chethan.service;

import com.xworkz.xworkz_commonModule_chethan.dto.CommonModuleDTO;

public interface CommonModuleService {

    boolean validateAndSave(CommonModuleDTO commonModuleDTO);
    Long getCountofName(String name);
    Long getCountofEmail(String email);
    Long getCountofPhone(String phone);
    Long getCountofAlterEmail(String alterEmail);
    Long getCountofAlterPhone(String alterPhone);
    public String onSignin(String email, String password);
    public boolean onUpdate(String email, String newPassword, String confirmPassword);
}

