package com.xworkz.xworkz_course_reg.service;

import com.xworkz.xworkz_course_reg.dto.CourseDTO;
import com.xworkz.xworkz_course_reg.entity.CourseEntity;
import com.xworkz.xworkz_course_reg.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseServiceImpl() {
        System.out.println("created CourseServiceImpl");
    }

    @Override
    public String validateAndSave(CourseDTO courseDTO) {
        System.out.println("created validateAndSave in CourseServiceImpl");
        System.out.println("Service"+courseDTO.toString());

        String errorMessage = null;

        if (courseDTO != null) {
            String name = courseDTO.getName();
            if (name.length() < 10 || !name.matches("^[a-zA-Z0-9]*$")) {
                errorMessage = "Invalid Name";
            } else {
                int age = courseDTO.getAge();
                if (age <= 18) {
                    errorMessage = "Invalid Age";
                } else {
                    String email = courseDTO.getEmail();
                    if (!email.contains("@") || !email.endsWith("gmail.com")) {
                        errorMessage = "Invalid Email";
                    } else {
                        String password = courseDTO.getPassword();
                        if (password.length() < 7 || !password.matches(".*[^a-zA-Z0-9].*[^a-zA-Z0-9].*")) {
                            errorMessage = "Invalid Password";
                        } else {
                            String cPassword = courseDTO.getCPassword();
                            if (!cPassword.equals(password)) {
                                errorMessage = "Invalid Confirm Password";
                            } else {
                                String ph = courseDTO.getPh();
                                if (!ph.startsWith("9") || ph.length() != 10) {
                                    errorMessage = "Invalid Contact Number";
                                } else {
                                    CourseEntity courseEntity = new CourseEntity();
                                    courseEntity.setName(courseDTO.getName());
                                    courseEntity.setEmail(courseDTO.getEmail());
                                    courseEntity.setAge(courseDTO.getAge());
                                    courseEntity.setPassword(courseDTO.getPassword());
                                    courseEntity.setCPassword(courseDTO.getCPassword());
                                    courseEntity.setPh(courseDTO.getPh());
                                    courseRepository.save(courseEntity);
                                    errorMessage = "Validation successful";
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
    public String authenticateUser(String email, String password) {
        CourseEntity courseEntity = courseRepository.findByEmail(email);
        if (courseEntity != null && courseEntity.getPassword().equals(password)) {
            return "Authentication successful";
        }
        return "Authentication failed";
    }

    @Override
    public String getUserNameByEmail(String email) {
        CourseEntity courseEntity = courseRepository.findByEmail(email);
        if (courseEntity != null) {
            return courseEntity.getName();
        }
        return null;
    }
}
