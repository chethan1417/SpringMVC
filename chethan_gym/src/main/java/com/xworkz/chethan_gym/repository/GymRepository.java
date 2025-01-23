package com.xworkz.chethan_gym.repository;

import com.xworkz.chethan_gym.entity.AdminEntity;
import com.xworkz.chethan_gym.entity.EnquiryEntity;
import com.xworkz.chethan_gym.entity.RegistrationEntity;
import com.xworkz.chethan_gym.entity.ViewDetailsEntity;

import java.util.List;

public interface GymRepository {

     AdminEntity getData(String email);
     boolean save(EnquiryEntity enquiryEntity);
     EnquiryEntity getEnquireEntity(String email);
     Long getCountOfPhone(String phone);
     boolean saveRegistration(RegistrationEntity registrationEntity);
     Long getCountOfEmail(String email);
     List<EnquiryEntity> getAllEnquiries();
     boolean updateDetailsByenquiryId(EnquiryEntity enquiryEntity);
     boolean updateDetailsByregId(RegistrationEntity registrationEntity);
     RegistrationEntity getAllEnquiriesRegistration(String email);
     int getLastViewDetailsId(int enquiryId);
     List<ViewDetailsEntity> findEnquiryById(int enquiryId);
}
