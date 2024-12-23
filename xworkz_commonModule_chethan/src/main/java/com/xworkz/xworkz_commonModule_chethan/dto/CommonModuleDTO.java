package com.xworkz.xworkz_commonModule_chethan.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonModuleDTO {
    private int id;
    private String name;
    private String email;
    private String ph;
    private String alterEmail;
    private String alterPh;
    private String location;
}
