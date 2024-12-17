package com.xworkz.xworkz_website.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WebsiteDTO {

    private int id;
    private String name;
    private String email;
    private int age;
    private String password;
    private String cPassword;
    private String ph;

}
