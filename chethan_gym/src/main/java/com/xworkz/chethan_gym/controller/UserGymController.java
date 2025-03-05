package com.xworkz.chethan_gym.controller;

import com.xworkz.chethan_gym.entity.RegistrationEntity;
import com.xworkz.chethan_gym.service.GymService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class UserGymController {

    @Autowired
    GymService gymService;

    public UserGymController(){
        System.out.println("created UserGymController");
    }

    @GetMapping("/userDetails")
    public String onUpdate(String email ,Model model) {
        RegistrationEntity registrationEntity = gymService.getAllEnquiriesRegistration(email);
        model.addAttribute("registrationEntity", registrationEntity);
        return "UserHome.jsp";
    }
    @PostMapping("/userLogin")
    public String onUserLogin(@RequestParam("email") String email, @RequestParam("password") String password , Model model) {

       boolean valid = gymService.validateUserLogin(email,password);
       if (valid){

         RegistrationEntity registrationEntity = gymService.getAllEnquiriesRegistration(email);
         if (registrationEntity.getUserLoginCount()==-1){
             return "UpdateUserPassword.jsp";
         }else if (registrationEntity.getUserLoginCount()==0){
             model.addAttribute("registrationEntity",registrationEntity);
             return "ClientHome.jsp";
         }
       }
        return "UserLogin.jsp";
    }

    @PostMapping("/updateUserPassword")
    public String updateUserPassword(@RequestParam("email") String email , @RequestParam("newPassword") String newPassword){

        boolean valid =gymService.updateUserPassword(email,newPassword);
        RegistrationEntity registrationEntity = gymService.getAllEnquiriesRegistration(email);

        if (valid) {
            if (registrationEntity.getUserLoginCount()==0){
            return "UserLogin.jsp";
            }
        }

        return "UserLogin.jsp";
    }

    @PostMapping("/userUpdate")
    public String updateUserDetails(@RequestParam("email") String email , Model model){

        RegistrationEntity registrationEntity =gymService.getAllEnquiriesRegistration(email);
        if (registrationEntity!=null){
            model.addAttribute("registrationEntity",registrationEntity);
            return "UserDetailsUpdate.jsp";
        }
        return "UserLogin.jsp";
    }


    @PostMapping("/updateUserProfile")
    public String updateUserProfile(@RequestParam("reg_id") int reg_id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("ph") String ph, @RequestParam("age") String age, @RequestParam("weight") String weight, @RequestParam("height") String height, @RequestParam("plan") String plan, @RequestParam("picture") MultipartFile multipartFile , Model model) throws IOException {

        if (multipartFile.isEmpty()) {
            boolean isUpdated = gymService.updateUserProfile(reg_id, name, email, ph, age, weight, height, plan, null);

            if (isUpdated) {
                RegistrationEntity registrationEntity =gymService.getAllEnquiriesRegistration(email);
                model.addAttribute("registrationEntity",registrationEntity);

                return "UserSuccess.jsp";
            }

        } else {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get("D:\\images\\" + System.currentTimeMillis() + ".jpeg");
            Files.write(path, bytes);
            String filePath = path.getFileName().toString();
            boolean isUpdated = gymService.updateUserProfile(reg_id, name, email, ph, age, weight, height, plan, filePath);
            if (isUpdated) {
                RegistrationEntity registrationEntity =gymService.getAllEnquiriesRegistration(email);
                model.addAttribute("registrationEntity",registrationEntity);
                System.out.println("fileeee"+filePath);
                return "UserSuccess.jsp";
            }
        }
        return "UserLogin.jsp";
    }

    @GetMapping("/userHome")
    public String userHome(String email ,Model model) {
        RegistrationEntity registrationEntity = gymService.getAllEnquiriesRegistration(email);
        model.addAttribute("registrationEntity", registrationEntity);
        return "ClientHome.jsp";
    }

    @GetMapping("/download")
    public void display(HttpServletResponse response, @RequestParam String filePath) throws Exception {
        response.setContentType("Image/jpeg");
        File file = new File("D:\\images\\" + filePath);
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        response.flushBuffer();
    }

}
