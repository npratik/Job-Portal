package com.neu.edu;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.JobListDAO;
//import com.neu.edu.dao.OutputStream;
//import com.neu.edu.dao.SQLException;
import com.neu.pojo.AppliedJobs;
import com.neu.pojo.Employer;
import com.neu.pojo.Jobs;
import com.neu.pojo.Jobseeker;


@Controller
public class JobsApplied {
	
	@RequestMapping(value = "appliedjobs/{id}", method = RequestMethod.GET)
	public String applyJob(@PathVariable("id")long jobId,HttpServletRequest req, Model model){
		try{
			JobListDAO jobListDAO =new JobListDAO();
			
			Jobseeker jobseeker =(Jobseeker) req.getSession().getAttribute("employeeSession");
			long jobSeekerId =jobseeker.getPersonID();
			System.out.println(jobseeker.getPersonID());
			
			
			Boolean resumeExists = jobListDAO.checkifResumeExists(jobseeker.getPersonID());
			
			System.out.println("resumeExists" + resumeExists);
			
			
			
			if(resumeExists==false){
				
				model.addAttribute("resumeDoesnotexist",true);
				///Job Portal/src/main/webapp/WEB-INF/views/jobseekerResumeProfile.jsp
				return "jobseekerResumeProfile";
			}
			
			
			jobListDAO.jobApplied(jobSeekerId,jobId);
		}
		catch(Exception e){
			
		}
		return "jobAppliedSuccessPage";
}
//	"viewappliedjobseekers/${adverts.jobId}.htm"
	
	@RequestMapping(value = "viewappliedjobseekers/{id}", method = RequestMethod.GET)
	public String successemp(@PathVariable("id")long jobId,HttpServletRequest req,HttpSession session){
	try{
		
		JobListDAO jobListDAO=new JobListDAO();
		
		Employer employer =(Employer) session.getAttribute("employerSession");
		
		long userId=employer.getPersonID();
		
		List<AppliedJobs> employersApplicats=new ArrayList();
		employersApplicats=jobListDAO.getJobApplicatsList(userId,jobId); //check if both are required to pass
		
		req.getSession().setAttribute("employersApplicats", employersApplicats);
		if(employersApplicats.size()!=0){
			return "viewEployersJobSeekersAppliedList";
			
			
		}
		else{
			return "noapplicants";
		}
	
	}	catch(Exception e){
		
		return null; //check****
		
	   }
	
	}
	
	//seekerJob(long personId)
	
	@RequestMapping(value = "appliedJobs.htm", method = RequestMethod.GET)
	public String listofJobsApplied(HttpServletRequest req,HttpSession session){
	try{
		
		JobListDAO jobListDAO=new JobListDAO();
		
		Jobseeker seekerJob =(Jobseeker) session.getAttribute("employeeSession");
		
		long personId=seekerJob.getPersonID();
		
		List<AppliedJobs> JobAppliedList=new ArrayList();
		JobAppliedList=jobListDAO.getListOfAppliedJobs(personId); //check if both are required to pass
		
		req.getSession().setAttribute("JobAppliedList", JobAppliedList);
		if(JobAppliedList.size()!=0){
			return "viewJobSeekersAppliedJobList";
			
			
		}
		else{
			return "jobseekerNoJobtoList"; //jobseekerNoJobtoList.jsp
		}
	
	}	catch(Exception e){
		
		return null; //check****
		
	   }
	
	}
	
	
	//updateJobStatus
	//check***** Need to change****
	@RequestMapping(value = "updateJobStatus/{id}", method = RequestMethod.GET)
	public String updateJobStatus(@PathVariable("id")long applicantId,HttpSession session ){
		try{
			JobListDAO jobListDAO =new JobListDAO();
			
			
			
			AppliedJobs aj = jobListDAO.getApplicantId(applicantId);
			
			session.setAttribute("applicantobj", aj);
		}
		catch(Exception e){
			
		}
		return "updateEachJobseekersStatus";
}
	
	
	
	@RequestMapping(value="/updateSingleApplicantStatus/{ARId}",method = RequestMethod.POST)

	protected String doSubmitAction(@RequestParam("Status") String status,@RequestParam("message") String message,@PathVariable("ARId") String ARId,HttpSession session, Model model) throws Exception {

	 

	  try {

		  JobListDAO jobListDAO=new JobListDAO();

		  Long ai = Long.parseLong(ARId);
		  
		  System.out.println("inside file Changestatus controller" + ARId);
		  
		  AppliedJobs appliedJobs = (AppliedJobs) session.getAttribute("applicantobj");

		  jobListDAO.updatestatus(status,ai, message);

	        } catch (Exception e) {


	       	e.printStackTrace();


	        }
	  model.addAttribute("jobupdatedsucess",true);
	 // return "success2";
	  return "updateEachJobseekersStatus";

	}
	
	//appliedJobs.htm
	
	
	@RequestMapping(value = "/viewAndUpdateProfile.htm", method = RequestMethod.GET)
	public String profile(){
		
		
		return "jobseekerResumeProfile";
	}
	
	@RequestMapping(value = "/uploadResumeNew.htm", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("resumeFile") MultipartFile file,@RequestParam("skills") String skills,HttpSession session, Model model) {
		System.out.println("inside file upload controller");
		System.out.println("File:" + file.getOriginalFilename());
		System.out.println("ContentType:" + file.getContentType());
		
		//Jobseeker js = (Jobseeker) session.getAttribute("userObj");
		Jobseeker js =(Jobseeker) session.getAttribute("employeeSession");
		try {
			Blob blob = (Blob) Hibernate.createBlob(file.getInputStream());
			System.out.println("inside file upload controller forthe fiile uplaod");
			JobListDAO jsDao = new JobListDAO();

			jsDao.uploadResumeNew(js.getPersonID(), blob, file.getOriginalFilename(), file.getContentType(), skills);
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("resumeNotsucessful",true);
			return "jobseekerResumeProfile";
		}
        
		model.addAttribute("resumesucessful",true);
		return "jobseekerResumeProfile";///Job Portal/src/main/webapp/WEB-INF/views/jobseekerResumeProfile.jsp successUpload
	}
	
	@RequestMapping(value="download/{jaid}",method = RequestMethod.GET)
    public void download(@PathVariable("jaid")
            long documentId, HttpServletResponse response) {
		System.out.println("Inside download file");
		JobListDAO jd=new JobListDAO();
		System.out.println(documentId);
		AppliedJobs j=(AppliedJobs)jd.getAppliedResume(documentId);
		System.out.println(j.getResumeName());
		try {
            response.setHeader("Content-Disposition", "inline;filename=\"" +j.getResumeName()+ "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(j.getFileType());
            IOUtils.copy(j.getContentDetails().getBinaryStream(), out);
            out.flush();
            out.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}
	
	
	/*@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("jobseeker") Jobseeker person, BindingResult result) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {

		return "jobseekerregister";
	}*/
    
	/*@RequestMapping(value="/jobseekerregister.htm")
	public String initializeForm() {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {

		return "jobseekerregister";
	}*/
	
	/*@RequestMapping(value = "/jobseekerregister.htm", method = RequestMethod.GET)
	public String view(){
		
		
		return "jobseekerregister"; listjobs.htm
	}
	*/

	/*
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
         
        
        return "successfulUpload";
    }
	testing***** */
}
/*	@RequestMapping(value = "viewApplicants.htm", method = RequestMethod.GET)
	public String successemp(Model model,HttpServletRequest req,HttpSession session){
		try{
			JobListDAO jobListDAO=new JobListDAO();
			Employer employer =(Employer) session.getAttribute("employerSession");
			
			long personID= employer.getPersonID();
			
			System.out.println( "Employer person id in view jobposts/applicants" + personID);
			//List<Jobs> jobsList=jobListDAO.getPostedJobsList(personID);
			//model.addAttribute("jobsList",jobsList);
			
			//ListOfPostedJobs
			
			
		}
		catch(Exception e){
			
		}
		return "employerViewPostedJobs";
	

}
	
	@RequestMapping(value = "/viewApplicants.htm",method=RequestMethod.GET) //   /listjobs.htm
    protected ModelAndView handleRequestInternal(Model model,HttpServletRequest req,HttpSession session) throws Exception {
		JobListDAO categories = null;
        List categoryList = null;
        List advList = new ArrayList();

        try {
            categories = new JobListDAO();
             Employer employer =(Employer) session.getAttribute("employerSession");
			
			long personID= employer.getPersonID();
			
            categoryList = categories.getPostedJobsList(personID);
            
            System.out.println( "Employer person id in view jobposts/applicants" + personID);

            Iterator categIterator = categoryList.iterator();

            while (categIterator.hasNext())
            {
            	Jobs category = (Jobs) categIterator.next();
            	
            	 System.out.println( "category in employer posted jobs list " + category);

               // Iterator advIterator = category.getAdverts().iterator();

               // while (advIterator.hasNext())
                //{
                   // Advert advert = (Advert) advIterator.next();
                    advList.add(category);
                //}
            }
            //DAO.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("employerViewPostedJobs", "postedJobsList", advList);
        return mv;
    }*/

