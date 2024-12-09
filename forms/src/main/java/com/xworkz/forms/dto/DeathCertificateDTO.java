package com.xworkz.forms.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class DeathCertificateDTO {

    private String deceasedName;
    private String deceasedAge;
    private String deceasedAddress;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate deceasedDob;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate deceasedLastDate;
    private String deceasedCause;

}
