package com.xworkz.xworkz_commonModule_chethan.controller;

import com.xworkz.xworkz_commonModule_chethan.constants.LocationEnum;
import com.xworkz.xworkz_commonModule_chethan.dto.CommonModuleDTO;
import com.xworkz.xworkz_commonModule_chethan.entity.CommonModuleEntity;
import com.xworkz.xworkz_commonModule_chethan.service.CommonModuleService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class CommonModuleController {

    List<LocationEnum> listOfLocation = new ArrayList<>(Arrays.asList(LocationEnum.values()));

    CommonModuleEntity result;

    private static final Logger log = LoggerFactory.getLogger(CommonModuleController.class);
    @Autowired
    CommonModuleService commonModuleService;

    public CommonModuleController() {
        log.info("Created CommonModuleController");
    }

    @GetMapping("/signup")
    public String onSignup(Model model) {

        model.addAttribute("ListOfLocation", listOfLocation);
        return "Signup.jsp";
    }

    @PostMapping("/signup")
    public String onSave(CommonModuleDTO commonModuleDTO, Model model) {
        log.info("onSave in CommonModuleController");
        Set<ConstraintViolation<CommonModuleDTO>> valid = commonModuleService.validateAndSave(commonModuleDTO);
        if (valid == null || valid.isEmpty()) {
            log.info("Data saved successfully");
            model.addAttribute("successmsg", "SignUp Successfull");
            return "SignupSuccess.jsp";
        } else {
            log.info("Data validation failed");
            model.addAttribute("error", valid);
            model.addAttribute("dto", commonModuleDTO);
        }
        return "Signup.jsp";
    }

    @GetMapping("/signin")
    public String onSignin(Model model) {
        model.addAttribute("commonModuleEntity", result);
        return "UpdateDetails.jsp";

    }

    @PostMapping("/signin")
    public String onSignin(@RequestParam String email, @RequestParam String password, Model model) {
        log.info("onSignin in CommonModuleController");
        result = commonModuleService.onSignin(email, password);
        if (result == null) {
            return "Signin.jsp";
        }
        if (result.getSigninCount() >= 3) {
            model.addAttribute("error", "Account is locked. Try again after 24 hours.");
            return "Signin.jsp";
        }
        if (result.getSigninCount() == 0) {
            model.addAttribute("filePath",result.getFilePath());
            return "Success.jsp";
        }
        if (result.getSigninCount() == -1) {
            return "PasswordUpdate.jsp";
        }
        return "Signin.jsp";
    }

    @PostMapping("/updatePassword")
    public String onUpdatePassword(@RequestParam String email, @RequestParam String newPassword, @RequestParam String confirmPassword, Model model) {
        log.info("onUpdatePassword in CommonModuleController");
        if (commonModuleService.onUpdate(email, newPassword, confirmPassword)) {
            model.addAttribute("successmsg", "Password updated successfully. You can now log in.");
            return "UpdateSuccess.jsp";
        }
        model.addAttribute("error", "Password update failed. Please try again.");
        return "PasswordUpdate.jsp";
    }

    @PostMapping("/update")
    public String onUpdate(CommonModuleDTO commonModuleDTO, Model model, @RequestParam("picture") MultipartFile multipartFile) throws IOException {
        System.out.println("contoller:"+commonModuleDTO);
        log.info("Cont Updating details for email: {}", commonModuleDTO);
        if (multipartFile.isEmpty()) {
            boolean isUpdated = commonModuleService.updateDetails(commonModuleDTO,null);
            if (isUpdated) {
                log.info("Details updated successfully");
                model.addAttribute("successmsg", "Details updated successfully");
                model.addAttribute("entity", result);
                return "UpdateSuccess.jsp";
            }
        } else {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get("C:\\imgs\\" + System.currentTimeMillis() + ".jpg");
            Files.write(path, bytes);
            String filePath = path.getFileName().toString();
            log.info("filePath:" + filePath);
            log.info("multipartFile:" + multipartFile);
            boolean isUpdated = commonModuleService.updateDetails(commonModuleDTO,filePath);

            if (isUpdated) {
                return "UpdateSuccess.jsp";
            }

        }
        return "UpdateDetails.jsp";
    }

    @GetMapping("/download")
    public void display(HttpServletResponse response, @RequestParam String filePath) throws Exception{
        System.out.println(filePath);
        response.setContentType("Image/jpg");
        File file = new File("C:\\imgs\\"+filePath);
        InputStream inputStream=new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream outputStream=response.getOutputStream();
        IOUtils.copy(inputStream,outputStream);
        response.flushBuffer();
    }
}

