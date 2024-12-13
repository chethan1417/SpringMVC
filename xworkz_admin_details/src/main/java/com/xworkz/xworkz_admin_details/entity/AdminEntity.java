package com.xworkz.xworkz_admin_details.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "admin_table")
public class AdminEntity {

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

    public AdminEntity(String name, int age, String email, String password, String cPassword, String ph) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.cPassword = cPassword;
        this.ph = ph;
    }
}
