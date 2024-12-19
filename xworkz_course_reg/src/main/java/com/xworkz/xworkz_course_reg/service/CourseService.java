package com.xworkz.xworkz_course_reg.service;

import com.xworkz.xworkz_course_reg.dto.CourseDTO;

public interface CourseService {
    String validateAndSave(CourseDTO courseDTO);
    String authenticateUser(String email, String password);
    String getUserNameByEmail(String email);
}
