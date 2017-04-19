package com.neu.edu;

import java.io.IOException;
import java.sql.Blob;

import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.neu.edu.dao.JobListDAO;
import com.neu.pojo.Jobseeker;

@Controller
//@RequestMapping("/uploadresume.htm")
public class PostResume {

	
	@RequestMapping(value = "/uploadresume.htm", method = RequestMethod.POST)
	public String save(            
            @RequestParam("fileName") MultipartFile file,HttpSession session) throws IOException {
         
         
       
        System.out.println("File NAme:" + file.getName());
        System.out.println("type of coentent:" + file.getContentType());
        Jobseeker jobseeker =(Jobseeker) session.getAttribute("employeeSession");
        try {
            Blob blob =(Blob) Hibernate.createBlob(file.getInputStream()); 
            JobListDAO jobListDAO=new JobListDAO();
 
            jobListDAO.uploadResume(jobseeker.getPersonID(),blob,file.getOriginalFilename(),file.getContentType());
            
            System.out.println( "Employer person id upload resume" + jobseeker.getPersonID());
            
            System.out.println( "Employer file name upload resume" + file.getOriginalFilename());
           // document.setFileName(file.getOriginalFilename());
            //document.setContent(blob);
           // document.setContentType(file.getContentType());
        } catch (HibernateException e) {
            e.printStackTrace();
        }
         
        
        return "addedJob";
    }

}
