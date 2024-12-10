package com.xworkz.productForm.service;

import com.xworkz.productForm.dto.ProductFormDTO;

public interface ProductFormService {

    public boolean validateAndSave(ProductFormDTO productFormDTO);
}
