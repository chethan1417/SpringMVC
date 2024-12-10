package com.xworkz.productForm.service;

import com.xworkz.productForm.dto.ProductFormDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductFormServiceImpl implements ProductFormService{

    public ProductFormServiceImpl()
    {
        System.out.println("created ProductFormServiceImpl");
    }

    @Override
    public boolean validateAndSave(ProductFormDTO productFormDTO) {
        return true;
    }
}
