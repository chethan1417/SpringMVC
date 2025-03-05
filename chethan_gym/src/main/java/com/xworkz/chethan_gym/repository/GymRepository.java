package com.xworkz.chethan_gym.repository;

import com.xworkz.chethan_gym.entity.*;

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

    List<RegUpdateEntity> getPaymentDetailsById(int reg_id);

     boolean updateUserPassword(RegistrationEntity registrationEntity);

    boolean updateUserProfile(RegistrationEntity registrationEntity , String filePath);

    boolean saveTrainers(TrainersEntity trainersEntity);

    boolean saveTime(TimeEntity timeEntity);

    List<TrainersEntity> getAllTrainers();

    List<TimeEntity> getSlots();

    boolean updateSlotsForTrainers(TrainersEntity trainersEntity);

    boolean updateSlotsForClients(RegistrationEntity registrationEntity);

    List<RegistrationEntity> getClientsOfTrainer(String trainerName);

    boolean deleteTrainer(String trainerName);

    boolean updateDAWForClients(RegistrationEntity registrationEntity);
}
