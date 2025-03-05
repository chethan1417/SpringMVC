package com.xworkz.chethan_gym.controller;

import com.xworkz.chethan_gym.constants.GymNameEnum;
import com.xworkz.chethan_gym.constants.PackageEnum;
import com.xworkz.chethan_gym.constants.StatusEnum;
import com.xworkz.chethan_gym.dto.*;
import com.xworkz.chethan_gym.entity.*;
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
        }
        return "AdminLogin.jsp";
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
            return "RegistrationSuccess.jsp";
        }
        else {
            return "Enquiry.jsp";
        }
    }

    @PostMapping("/registration1")
    public String onRegistration(RegistrationDTO registrationDTO)  {

        boolean valid = gymService.validateAndSaveForRegistration(registrationDTO);
        if (valid) {
            return "RegistrationSuccess.jsp";
        }
        return "Registration.jsp";
    }

    @PostMapping("/updateEnquiry")
    public String updateEnquiry(@RequestParam("enquiryId") int enquiryId, @RequestParam("status") String status, @RequestParam("description") String description, Model model) {

        EnquiryEntity updatedEnquiry = gymService.updateEnquiry(enquiryId, status, description);
        if (updatedEnquiry != null) {
            return "redirect:/follow";
        } else {
            return "RegistrationSuccess.jsp";
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
    public String updateRegistration(@RequestParam("reg_id") int reg_id,@RequestParam("name") String name, @RequestParam("packages") String packages, @RequestParam("trainer") String trainer, @RequestParam("amount") String amount , @RequestParam("paidAmount") String paidAmount , @RequestParam("balance") String balance , Model model) {

       boolean updated = gymService.updateRegistration(reg_id,name, packages, trainer ,amount,paidAmount,balance);
        if (updated) {
            return "RegistrationSuccess.jsp";
        } else {
            model.addAttribute("error", "Failed to update .");
            return "Update.jsp";
        }
    }


    @PostMapping("/search")
    public String getRegEntityByEmail(@RequestParam("email")String email , Model model){

        RegistrationEntity registrationEntity =gymService.getAllEnquiriesRegistration(email);
        if (registrationEntity!=null){
            model.addAttribute("registrationEntity",registrationEntity);
            return "Update.jsp";
        }else {
            model.addAttribute("noEmail","No Data Found For this mail");
            return "Update.jsp";
        }
    }

    @PostMapping("/viewDetails")
    public String viewDetails(@RequestParam("enquiryId") int enquiryId, Model model) {

        List<ViewDetailsEntity> viewDetailsEntity = gymService.getEnquiryById(enquiryId);

        if (viewDetailsEntity == null) {
            model.addAttribute("errorMessage", "No enquiry found for the given ID.");
            return "Success.jsp";
        }else {
            model.addAttribute("viewDetailsEntity", viewDetailsEntity);
            return "ViewDetails.jsp";

        }
    }

    @PostMapping("/viewPaymentDetails")
    public String viewPaymentDetails(@RequestParam("reg_id") int reg_id, Model model) {
       List<RegUpdateEntity> regUpdateEntityList= gymService.getPaymentDetailsById(reg_id);

       if (regUpdateEntityList!=null){
           model.addAttribute("regUpdateEntityList",regUpdateEntityList);
           return "PaymentDetails.jsp";
       }
        return "Success.jsp";
    }

    @PostMapping("/trainers")
    public String onTrainers(TrainerDTO trainerDTO, Model model)  {
        boolean saved =gymService.onTrainers(trainerDTO);
        if (saved){
            return "RegistrationSuccess.jsp";
        }
        model.addAttribute("error", "Failed to Add Trainers.");
        return "Trainers.jsp";
    }

    @PostMapping("/timeSlots")
    public String onTime(TimeDTO timeDTO,Model model){
        boolean saved =gymService.onTime(timeDTO);
        if (saved){
            return "RegistrationSuccess.jsp";
        }
        model.addAttribute("error", "Failed to Add slots.");
        return "AddSlots.jsp";
    }

    @GetMapping("/allotment")
    public String allotment(Model model){
        List<TrainersEntity> trainersEntities =gymService.getAllTrainers();
        List<TimeEntity> timeEntities = gymService.getSlots();
        if (trainersEntities!=null){
            model.addAttribute("trainersEntities",trainersEntities);
            model.addAttribute("timeEntities",timeEntities);
            return "AlotSlots.jsp";
        }
        return "Success.jsp";
    }


    @PostMapping("/allotment")
    public String assignSlots(@RequestParam("trainer") String trainer , @RequestParam("slot") String slot,Model model){
      boolean done =  gymService.updateSlotsForTrainers(trainer,slot);
      if (done){
          return "RegistrationSuccess.jsp";
      }
        model.addAttribute("error", "Failed to update enquiry.");
        return "AlotSlots.jsp";
    }


    @GetMapping("/slotDetails")
    public String slotDetails(Model model){
        List<TrainersEntity> trainersEntities =gymService.getAllTrainers();
        if (trainersEntities!=null){
            model.addAttribute("trainersEntities",trainersEntities);
            return "SlotsDetails.jsp";
        }
        return "Success.jsp";
    }

    @PostMapping("/removeSlot")
    public String removeSlots(@RequestParam("trainerName") String trainerName){
        System.out.println(trainerName);
        gymService.removeSlots(trainerName);
        return "RegistrationSuccess.jsp";
    }


    @PostMapping("/clientsearch")
    public String getClientEntityByEmail(@RequestParam("email")String email , Model model){

        RegistrationEntity registrationEntity =gymService.getAllEnquiriesRegistration(email);
        List<TrainersEntity> trainersEntities =gymService.getAllTrainers();
        if (registrationEntity!=null){
            model.addAttribute("registrationEntity",registrationEntity);
            model.addAttribute("trainersEntities",trainersEntities);
            return "ClientSlot.jsp";
        }
        return "Success.jsp";
    }

    @PostMapping("/trainerSearch")
    public String getTrainerEntityByEmail(Model model){

        List<TrainersEntity> trainersEntities =gymService.getAllTrainers();

        System.out.println(trainersEntities);
        if (trainersEntities!=null){
            model.addAttribute("trainersEntities",trainersEntities);
            return "ClientSlot.jsp";
        }
        return "Success.jsp";
    }

    @PostMapping("/clientAllotment")
    public String alotClientSlots(@RequestParam("clientName") String clientName , @RequestParam("trainer") String trainer , @RequestParam("slot") String slot,Model model){
        boolean saved =gymService.updateSlotsForClients(clientName,trainer,slot);
        if (saved){
            return "RegistrationSuccess.jsp";
        }
        model.addAttribute("error", "Failed to update enquiry.");
        return "ClientSlot.jsp";
    }

    @PostMapping("/clientSlotSearch")
    public String searchClientSlotByEmail(@RequestParam("email")String email , Model model){

        RegistrationEntity registrationEntity =gymService.getAllEnquiriesRegistration(email);
        System.out.println(registrationEntity);
        if (registrationEntity!=null){
            model.addAttribute("registrationEntity",registrationEntity);

            return "SearchClient.jsp";
        }
        return "Success.jsp";
    }

    @PostMapping("/deleteTrainer")
    public String deleteTrainer(@RequestParam("trainerName") String trainerName,Model model){
         List<RegistrationEntity> clients = gymService.getAllClientsForTrainer(trainerName);
        System.out.println(clients);
         if (clients!=null && !clients.isEmpty()){
             model.addAttribute("clientNames",clients);
             return "ClientSlot.jsp";
         }
         else {
             gymService.deleteTrainer(trainerName);
             return "RegistrationSuccess.jsp";
         }
    }

    @PostMapping("/assignDAW")
    public String assignDAW(@RequestParam("clientName")String clientName,@RequestParam("workoutPlan")String workoutPlan ,@RequestParam("dietPlan")String dietPlan){
        if (clientName!=null){
            boolean saved =gymService.updateDAWForClients(clientName,dietPlan,workoutPlan);
            if (saved){
                return "RegistrationSuccess.jsp";
            }
        }
        return "Success.jsp";
    }

    @PostMapping("/getClient")
    public String assignDAWgetClient(@RequestParam("email")String email,Model model){
        RegistrationEntity registrationEntity =gymService.getAllEnquiriesRegistration(email);
        System.out.println(registrationEntity);
        System.out.println(email);
        if (registrationEntity!=null){
            model.addAttribute("registrationEntity",registrationEntity);
            return "AssignDAW.jsp";
        }
        model.addAttribute("error", "No Client found for this mail.");
        return "AssignDAW.jsp";
    }

    @GetMapping("/viewDAW")
    public String dawDetails(@RequestParam("email")String email, Model model){
       RegistrationEntity registrationEntity = gymService.getAllEnquiriesRegistration(email);
       if (registrationEntity!=null){
           model.addAttribute("registrationEntity",registrationEntity);
           return "ViewDAW.jsp";
       }
        return "Success.jsp";
    }

}
