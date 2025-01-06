package com.xworkz.xworkz_commonModule_chethan.service;

import com.xworkz.xworkz_commonModule_chethan.dto.CommonModuleDTO;
import com.xworkz.xworkz_commonModule_chethan.entity.CommonModuleEntity;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface CommonModuleService {

    Set<ConstraintViolation<CommonModuleDTO>> validateAndSave(CommonModuleDTO commonModuleDTO);
    Long getCountofName(String name);
    Long getCountofEmail(String email);
    Long getCountofPhone(String phone);
    Long getCountofAlterEmail(String alterEmail);
    Long getCountofAlterPhone(String alterPhone);
    CommonModuleEntity onSignin(String email, String password);boolean onUpdate(String email, String newPassword, String confirmPassword);
    boolean saveEmail(String email, String password);
    boolean updateDetails(CommonModuleDTO commonModuleDTO);
}

