package com.neu.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.pojo.Employer;
import com.neu.pojo.Jobseeker;
import com.neu.pojo.Person;

@Controller

public class JobSeekerRegistrationBasePage {
	
	@RequestMapping(value="/jobseekerregister.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("jobseeker") Jobseeker person, BindingResult result) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {

		return "jobseekerregister";
	}
	
	
	@RequestMapping(value="/employerregister.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("employer") Employer person, BindingResult result) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {

		return "employerregister";
	}
  
	
	//logout from home page logoutJobSeeker.htm
	
	@RequestMapping(value="/logoutJobSeeker.htm",method = RequestMethod.GET)
	public String jobseekerLogout(@ModelAttribute("jobseeker") Employer person, BindingResult result, HttpSession session) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {
         
		session.invalidate();
		return "home";
	}
	
	//logoutEmployer
	@RequestMapping(value="/logoutEmployer.htm",method = RequestMethod.GET)
	public String employerLogout(@ModelAttribute("jobseeker") Employer person, BindingResult result, HttpSession session) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {
         
		session.invalidate();
		return "home";
	}
	
	//jobseekerdashboarddivert.htm
	
	@RequestMapping(value="/jobseekerdashboarddivert.htm",method = RequestMethod.GET)
	public String divertojobsskerdashboard(@ModelAttribute("jobseeker") Employer person, BindingResult result, HttpSession session) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {
         
		//session.invalidate();
		return "jobseekerdashboard";
	}
    
	@RequestMapping(value="/jobseekerdashboarduploaddivert.htm",method = RequestMethod.GET)
	public String divertojobsskerdashboarduploadResume(@ModelAttribute("jobseeker") Employer person, BindingResult result, HttpSession session) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {
         
		//session.invalidate();
		return "jobseekerResumeProfile";
	}
	
	//jobseekerdashboardappliedJobsdivert.htm
	
	@RequestMapping(value="/jobseekerdashboardappliedJobsdivert.htm",method = RequestMethod.GET)
	public String divertojobsskerdashboardappliedjobs(@ModelAttribute("jobseeker") Employer person, BindingResult result, HttpSession session) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {
         
		//session.invalidate();
		return "viewJobSeekersAppliedJobList";
	}
	
	@RequestMapping(value="/getemployerdashboard.htm",method = RequestMethod.GET)
	public String divertoemployerdashboardappliedjobs(@ModelAttribute("jobseeker") Employer person, BindingResult result, HttpSession session) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {
         
		//session.invalidate();
		return "employerdashboard";
	}
	
	
	//employerViewPostedJobs
	
	@RequestMapping(value="/getemployerdashboardviewpostedJobs.htm",method = RequestMethod.GET)
	public String divertoemployerdashboardappliedjobsother(@ModelAttribute("jobseeker") Employer person, BindingResult result, HttpSession session) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {
         
		//session.invalidate();
		return "employerViewPostedJobs";
	}
	//divertQuickSearchJobs.htm
	
	@RequestMapping(value="/divertQuickSearchJobs.htm",method = RequestMethod.GET)
	public String jobseekerquicksearch(@ModelAttribute("jobseeker") Employer person, BindingResult result, HttpSession session) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {
         
		//session.invalidate();
		return "jobSeekerQuickSerach"; ///Job Portal/src/main/webapp/WEB-INF/views/jobSeekerQuickSerach.jsp
	}
	
	
	@RequestMapping(value="/diverthome.htm",method = RequestMethod.GET)
	public String diverthome(@ModelAttribute("jobseeker") Employer person, BindingResult result, HttpSession session) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {
         
		//session.invalidate();
		return "home"; ///Job Portal/src/main/webapp/WEB-INF/views/jobSeekerQuickSerach.jsp
	}
	
	//regiternewuserpage.htm
	@RequestMapping(value="/regiternewuserpage.htm",method = RequestMethod.GET)
	public String registernewuser(@ModelAttribute("person") Person person, BindingResult result, HttpSession session) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {
         
		//session.invalidate();
		return "RegisterUser"; ///Job Portal/src/main/webapp/WEB-INF/views/jobSeekerQuickSerach.jsp
	}
	//quickSearchJobs.htm
	/*@RequestMapping(value="/quickSearchJobs.htm",method = RequestMethod.GET)
	public String jobseekerquicksearch(@ModelAttribute("jobseeker") Employer person, BindingResult result, HttpSession session) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {
         
		//session.invalidate();
		return "jobSeekerQuickSerach"; ///Job Portal/src/main/webapp/WEB-INF/views/jobSeekerQuickSerach.jsp
	}*/
	
	
	//jobseekerdashboard
	/*@RequestMapping(value="/jobseekerLogin.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("person") Person person, BindingResult result,HttpServletRequest request,HttpServletResponse response) {
         
		System.out.print("testing in get method");
		return "jobseekerdashboard"; //check**** need to place homepage I guess
	}*/
	
}
