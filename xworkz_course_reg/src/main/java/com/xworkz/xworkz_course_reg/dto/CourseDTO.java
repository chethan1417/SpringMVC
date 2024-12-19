package com.xworkz.xworkz_course_reg.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDTO {

    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
    private String cPassword;
    private String ph;

}
