package com.xworkz.chethan_gym.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationDTO {

    private String name;
    private String email;
    private String ph;
    private String packages;
    private String trainer;
    private String gymName;
    private String amount;
    private String discount;
    private String balance;
    private String installment;
    private String paidAmount;

}
