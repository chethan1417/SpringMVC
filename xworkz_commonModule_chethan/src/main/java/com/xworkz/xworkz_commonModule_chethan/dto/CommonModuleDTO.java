package com.xworkz.xworkz_commonModule_chethan.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CommonModuleDTO {
    private int id;
    @Size(min = 3,max = 15,message = "Name must be atleast 3 characters")
    private String name;
    @Email(message = "Email should have @ and .com  ")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$" , message ="Email should have @ and .com ")
    private String email;
    @Pattern(regexp = "^[0-9]{10}$",message = "Provide valid Contact number")
    private String ph;
    @Email(message = "Alter Email should have @ and .com  ")
    private String alterEmail;
    @Pattern(regexp = "^[0-9]{10}$",message = "Provide valid Contact number")
    private String alterPh;
    @Size(min =10,max = 100,message = "Location must be atleast 10 characters")
    private String location;
}
