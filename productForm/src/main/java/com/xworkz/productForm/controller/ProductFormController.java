package com.xworkz.productForm.controller;

import com.xworkz.productForm.dto.ProductFormDTO;
import com.xworkz.productForm.service.ProductFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProductFormController {

    @Autowired
    private ProductFormService productFormService;

    public ProductFormController()
    {
        System.out.println("created ProductFormController");
    }

    @PostMapping("/product")
    public String productForm(ProductFormDTO productFormDTO, Model model)
    {
        System.out.println("created productForm in ProductFormController");
        System.out.println(productFormDTO);
        boolean saved = productFormService.validateAndSave(productFormDTO);
        if (saved)
        {
            System.out.println("Data is saved");
            model.addAttribute("smessage","Got the product details");
            return "ProductSuccess.jsp";
        }
        else
        {
            System.out.println("Data is Not saved");
            model.addAttribute("productDto",productFormDTO);
            model.addAttribute("fmessage","Failure in Getting product details");
        }
        return "Product.jsp";
    }
}
