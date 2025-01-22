package com.xworkz.chethan_gym.service;

import com.xworkz.chethan_gym.dto.AdminDTO;
import com.xworkz.chethan_gym.dto.EnquiryDTO;
import com.xworkz.chethan_gym.dto.RegistrationDTO;
import com.xworkz.chethan_gym.entity.AdminEntity;
import com.xworkz.chethan_gym.entity.EnquiryEntity;
import com.xworkz.chethan_gym.entity.RegistrationEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface GymService {

    boolean validateAdmin(AdminDTO adminDTO) throws NoSuchAlgorithmException;
    boolean validateAndSaveForEnquiry(EnquiryDTO enquiryDTO);
    Long getCountofPhone(String phone);
    Long getCountofEmail(String email);
    boolean validateAndSaveForRegistration(RegistrationDTO registrationDTO);
    String generatePassword();
    boolean saveEmail(String email, String password);
    List<EnquiryEntity> getAllEnquiries();
    EnquiryEntity updateEnquiry(int enquiryId, String status, String description);
    boolean updateRegistration(int reg_id,String packages, String trainer, String amount ,String paidAmount , String balance);
    RegistrationEntity getAllEnquiriesRegistration(String email);
}
