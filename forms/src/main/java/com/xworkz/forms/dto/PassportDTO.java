package com.xworkz.forms.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class PassportDTO {

    private String givenName;
    private String surname;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;
    private String email;
    private String loginId;
    private String password;
    private String confirmPassword;


}
