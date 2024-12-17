package com.xworkz.xworkz_website.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "website_table")
@NamedQuery(name = "WebsiteEntity.findByEmail", query = "SELECT we FROM WebsiteEntity we WHERE we.email = :email")
public class WebsiteEntity {

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

    @Column(name = "ph")
    private String ph;

    public WebsiteEntity(String name, String email, int age, String password,String ph) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
        this.ph = ph;
    }
}
