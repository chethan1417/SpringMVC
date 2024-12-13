package com.xworkz.xworkz_admin_details.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminDTO {

    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
    private String cPassword;
    private String ph;
}
