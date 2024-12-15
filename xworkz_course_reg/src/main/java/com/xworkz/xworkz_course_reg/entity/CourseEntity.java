package com.xworkz.xworkz_course_reg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "course_table")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "cPassword")
    private String cPassword;

    @Column(name = "ph")
    private String ph;

    public CourseEntity(String name, int age, String email, String password, String cPassword, String ph) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.cPassword = cPassword;
        this.ph = ph;
    }
}
