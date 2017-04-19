package com.neu.edu;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.UserDAO;
import com.neu.pojo.Jobseeker;

@Controller
@RequestMapping("/save.htm")
public class AddResume {
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("jobseeker") Jobseeker jobseeker, BindingResult result) throws Exception { //@ModelAttribute("person") Person person
		//validator.validate(person, result);
		if (result.hasErrors()) {
			return "documents";
		}

		try {
			System.out.print("test");
			UserDAO userDao = new UserDAO();
			System.out.print("test1");
			
			userDao.create(jobseeker.getName(), jobseeker.getPassword(), jobseeker.getEmailAddress(), jobseeker.getFirstName(), jobseeker.getLastName());//userDao.create(person.getName(), person.getPassword(), person.getEmail(), person.getFirstName(), person.getLastName());
			
			// DAO.close(); create(String username, String password,String emailId, String firstName, String lastName)
		} catch (HibernateException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "documents";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("jobseeker") Jobseeker person, BindingResult result) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {

		return "documents";
	}
}
