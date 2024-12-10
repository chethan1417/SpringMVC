package com.xworkz.productForm.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ProductFormDTO {

    private String name;
    private String type;
    private double cost;
    private String manufacturer;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate manufactureDate;
    private int warranty;
}
