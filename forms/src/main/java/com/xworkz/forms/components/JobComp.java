package com.xworkz.forms.components;

import com.xworkz.forms.dto.JobDTO;
import com.xworkz.forms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class JobComp {

    @Autowired
    private JobService jobService;
    public JobComp()
    {
        System.out.println("created JobComp");
    }

    @RequestMapping("/job")
    public String jobForm(JobDTO jobDTO)
    {
        System.out.println("jobForm in JobComp");
        System.out.println(jobDTO);
       boolean saved = jobService.validateAndSave();
       if(saved)
       {
           System.out.println("saved");
       }
       else
       {
           System.out.println("Not saved");
       }
        return "job.jsp";
    }
}
