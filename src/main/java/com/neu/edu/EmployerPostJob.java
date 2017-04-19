package com.neu.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.UserDAO;
import com.neu.pojo.Employer;
import com.neu.pojo.Jobs;
import com.neu.pojo.Jobseeker;
import com.neu.pojo.Person;

@Controller
@RequestMapping("/employerpostjob.htm")
public class EmployerPostJob {
	
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("jobs") Jobs jobs, BindingResult result,HttpServletRequest request,HttpServletResponse response, Model model) throws Exception { //@ModelAttribute("person") Person person
		//validator.validate(person, result);
		if (result.hasErrors()) {
			return "employerpostjob";
		}

		try {
			System.out.print("test");
			UserDAO userDao = new UserDAO();
			System.out.print("test1");
			
			Person personAccount = (Person) request.getSession().getAttribute("employerSession");
			
			String name = personAccount.getName();
			
			System.out.println("user name of the person posting the job : " + name);
			
		              //Person user = s.("employerSession");
			// here jobs.getEmployer() will be blank*****
			userDao.createJobs(jobs.getCompany(), jobs.getJobLocation(), jobs.getJobRole(), jobs.getJobType(),jobs.getTechnology(), jobs.getEmployer(), personAccount.getName(), jobs.getJobDescrition());//userDao.create(person.getName(), person.getPassword(), person.getEmail(), person.getFirstName(), person.getLastName());
			
			// DAO.close(); create(String username, String password,String emailId, String firstName, String lastName)
		} catch (HibernateException e) {
			System.out.println("Exception: " + e.getMessage());
		}
        
		model.addAttribute("jobSucessfullyAdded",true);
		//return "addedJob";
		return "employerpostjob";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("jobs") Jobs jobs, BindingResult result) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {

		return "employerpostjob";
	}
}
