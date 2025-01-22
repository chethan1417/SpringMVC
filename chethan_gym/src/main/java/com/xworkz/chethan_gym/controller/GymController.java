package com.xworkz.chethan_gym.controller;

import com.xworkz.chethan_gym.constants.GymNameEnum;
import com.xworkz.chethan_gym.constants.PackageEnum;
import com.xworkz.chethan_gym.constants.StatusEnum;
import com.xworkz.chethan_gym.dto.AdminDTO;
import com.xworkz.chethan_gym.dto.EnquiryDTO;
import com.xworkz.chethan_gym.dto.RegistrationDTO;
import com.xworkz.chethan_gym.entity.EnquiryEntity;
import com.xworkz.chethan_gym.entity.RegistrationEntity;
import com.xworkz.chethan_gym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GymController {

    List<PackageEnum> packages = new ArrayList<>(Arrays.asList(PackageEnum.values()));
    List<GymNameEnum> gymNames = new ArrayList<>(Arrays.asList(GymNameEnum.values()));
    List<StatusEnum> status = new ArrayList<>(Arrays.asList(StatusEnum.values()));

    public GymController() {
        System.out.println("created GymController");
    }

    @Autowired
    GymService gymService;

    @PostMapping("/login")
    public String onRegistration(AdminDTO adminDTO , Model model) throws NoSuchAlgorithmException {

        boolean valid = gymService.validateAdmin(adminDTO);
        if (valid) {
            return "Success.jsp";
        }else {
            model.addAttribute("logInerror","Email and Password doesn't match");
        }
        return "index.jsp";
    }

    @GetMapping("/registration")
    public String onRegistration(Model model) {

        model.addAttribute("packages", packages);
        model.addAttribute("gymNames", gymNames);
        return "Registration.jsp";
    }

    @GetMapping("/update")
    public String onUpdate(Model model) {
        model.addAttribute("packages", packages);
        return "Update.jsp";
    }

    @PostMapping("/enquiry")
    public String onEnquiry(EnquiryDTO enquiryDTO){
        boolean saved = gymService.validateAndSaveForEnquiry(enquiryDTO);
        if (saved){
            return "Enquiry.jsp";
        }
        else {
            return "Success.jsp";
        }
    }

    @PostMapping("/registration1")
    public String onRegistration(RegistrationDTO registrationDTO)  {

        System.out.println(registrationDTO);
        boolean valid = gymService.validateAndSaveForRegistration(registrationDTO);
        if (valid) {
            return "RegistrationSuccess.jsp";
        }
        return "index.jsp";
    }

    @PostMapping("/updateEnquiry")
    public String updateEnquiry(@RequestParam("enquiryId") int enquiryId, @RequestParam("status") String status, @RequestParam("description") String description, Model model) {

        EnquiryEntity updatedEnquiry = gymService.updateEnquiry(enquiryId, status, description);
        if (updatedEnquiry != null) {
            return "redirect:/follow";
        } else {
            model.addAttribute("error", "Failed to update enquiry.");
            return "Success.jsp";
        }
    }

    @GetMapping("/follow")
    public String getFollowPage(Model model) {
        List<EnquiryEntity> enquiries = gymService.getAllEnquiries();
        model.addAttribute("enquiries", enquiries);
        model.addAttribute("status", status);
        return "Follow.jsp";
    }

    @PostMapping("/update")
    public String updateRegistration(@RequestParam("reg_id") int reg_id, @RequestParam("packages") String packages, @RequestParam("trainer") String trainer, @RequestParam("amount") String amount , @RequestParam("paidAmount") String paidAmount , @RequestParam("balance") String balance , Model model) {

       boolean updated = gymService.updateRegistration(reg_id, packages, trainer ,amount,paidAmount,balance);
        if (updated) {
            return "Update.jsp";
        } else {
            model.addAttribute("error", "Failed to update....");
            return "Success.jsp";
        }
    }


    @PostMapping("/search")
    public String getRegEntityByEmail(@RequestParam("email")String email , Model model){

        RegistrationEntity registrationEntity =gymService.getAllEnquiriesRegistration(email);
        System.out.println(registrationEntity);
        if (registrationEntity!=null){
            model.addAttribute("registrationEntity",registrationEntity);
            return "Update.jsp";
        }
        return "Success.jsp";
    }
}
