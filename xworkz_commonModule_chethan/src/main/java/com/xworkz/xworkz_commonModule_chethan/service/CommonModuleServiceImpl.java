package com.xworkz.xworkz_commonModule_chethan.service;

import com.xworkz.xworkz_commonModule_chethan.dto.CommonModuleDTO;
import com.xworkz.xworkz_commonModule_chethan.entity.AbstractAuditEntity;
import com.xworkz.xworkz_commonModule_chethan.entity.CommonModuleEntity;
import com.xworkz.xworkz_commonModule_chethan.repository.CommonModuleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.Set;

@Service
public class CommonModuleServiceImpl implements CommonModuleService {

    private static final Logger log = LoggerFactory.getLogger(CommonModuleServiceImpl.class);

    @Autowired
    CommonModuleRepository commonModuleRepository;


    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    CommonModuleEntity commonModuleEntity=new CommonModuleEntity();

    private final static String character = "ABCDEFGHIJKLMNOPQRSTQUVWXYZabcdefghijkmloppqrstuvxxyz09876554321@";

    public CommonModuleServiceImpl() {
        log.info("Created CommonModuleServiceImpl");
    }

    @Override
    public Set<ConstraintViolation<CommonModuleDTO>> validateAndSave(CommonModuleDTO commonModuleDTO) {

        AbstractAuditEntity abstractAuditEntity=new AbstractAuditEntity();

        System.out.println("Service"+commonModuleDTO);

        if (commonModuleDTO != null) {
            if (commonModuleDTO.getName() != null) {
                commonModuleEntity.setName(commonModuleDTO.getName());
                commonModuleEntity.setCreatedBy(commonModuleDTO.getName());
                commonModuleEntity.getCreatedDate();
                commonModuleEntity.setUpdatedBy(commonModuleDTO.getName());
                commonModuleEntity.getUpdatedDate();
            }

            if (commonModuleDTO.getEmail() != null) {
                commonModuleEntity.setEmail(commonModuleDTO.getEmail());
            }

            if (commonModuleDTO.getPh() != null) {
                commonModuleEntity.setPh(commonModuleDTO.getPh());
            }

            if (commonModuleDTO.getAlterEmail() != null) {
                commonModuleEntity.setAlterEmail(commonModuleDTO.getAlterEmail());
            }
            if (commonModuleDTO.getAlterPh() != null) {
                commonModuleEntity.setAlterPh((commonModuleDTO.getAlterPh()));
            }

            if (commonModuleDTO.getLocation() != null) {
                commonModuleEntity.setLocation(commonModuleDTO.getLocation());
            }

            if (commonModuleDTO.getEmail() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                SecureRandom secureRandom = new SecureRandom();
                for (int i = 0; i < 9; i++) {
                    int index = secureRandom.nextInt(character.length());
                    stringBuilder = stringBuilder.append(character.charAt(index));
                }
                saveEmail(commonModuleDTO.getEmail(),stringBuilder.toString());
                commonModuleEntity.setPassword(stringBuilder.toString());
            }
            commonModuleEntity.setSigninCount(-1);

            ValidatorFactory validatorFactory=Validation.buildDefaultValidatorFactory();
            Validator validator =validatorFactory.getValidator();
            Set<ConstraintViolation<CommonModuleDTO>> constraintViolations=validator.validate(commonModuleDTO);

            if(constraintViolations.isEmpty()){
                commonModuleRepository.save(commonModuleEntity);
            }else {
                return constraintViolations;
            }
        }
        return null;

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
    public CommonModuleEntity onSignin(String email, String password) {
        CommonModuleEntity commonModuleEntity =commonModuleRepository.onSignin(email);
        if (commonModuleEntity!=null){

            if (commonModuleEntity.getSigninCount()==-1){
                return commonModuleEntity;
            }

            if (commonModuleEntity.getSigninCount()>=3)
            {
                log.info("this Account has been Locked");
                return null;
            }
            if (bCryptPasswordEncoder.matches(password,commonModuleEntity.getPassword())){
                commonModuleEntity.setSigninCount(0);
                commonModuleRepository.onUpdate(commonModuleEntity);
                return commonModuleEntity;
            }else {
                int count =commonModuleEntity.getSigninCount()+1;
                commonModuleEntity.setSigninCount(count);
                commonModuleRepository.onUpdate(commonModuleEntity);
                return null;
            }

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

    @Override
    public boolean saveEmail(String email, String password) {
        final String username ="chethan.chiru.rc@gmail.com";
        final String userPassword = "btlw qavi xork qwqd";


        Properties prop = new Properties() ;
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, userPassword);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Your password");
            message.setText("your passwordd"+password);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean updateDetails(CommonModuleDTO commonModuleDTO) {
        if (commonModuleDTO != null) {

            commonModuleEntity.setName(commonModuleDTO.getName());
            commonModuleEntity.setEmail(commonModuleDTO.getEmail());
            commonModuleEntity.setPh(commonModuleDTO.getPh());
            commonModuleEntity.setAlterEmail(commonModuleDTO.getAlterEmail());
            commonModuleEntity.setAlterPh(commonModuleDTO.getAlterPh());
            commonModuleEntity.setLocation(commonModuleDTO.getLocation());
            System.out.println(commonModuleEntity);
            log.info("Serv Updating details for email: {}", commonModuleDTO.getEmail());
            return commonModuleRepository.updateDetailsByName(commonModuleEntity);
        }
        log.warn("CommonModuleDTO is null");
        return false;
    }


}
