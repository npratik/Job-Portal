package com.neu.edu;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.UserDAO;
import com.neu.pojo.Jobseeker;
import com.neu.pojo.Person;
import com.neu.spring.exception.AdException;
//import com.yusuf.spring.controller.UserValidator;
//import com.yusuf.spring.dao.UserDAO;
//import com.yusuf.spring.exception.AdException;
//import com.yusuf.spring.pojo.User;

/* Before
@Controller
public class JobSeekerRegistration {

	@RequestMapping("/jobseekerregister.htm")
	public String loginview(){	
		return "jobseekerregister";
	}
	
}*/
@Controller
//@RequestMapping("/jobseekerregistervalidate.htm")
public class JobSeekerRegistration {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value="/jobseekerregistervalidate.htm",method = RequestMethod.POST)//@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("jobseeker") Jobseeker jobseeker, BindingResult result, Model model) throws Exception { //@ModelAttribute("person") Person person
		validator.validate(jobseeker, result);
		if (result.hasErrors()) {
			return "jobseekerregister";
		}
		
		//check if user name is unique

		try {
			System.out.print("test");
			UserDAO userDao = new UserDAO();
			System.out.print("test1");
			
			Person person = userDao.checkUserExists(jobseeker.getName());
			
			if(person!=null){
				model.addAttribute("erroremployeeAlreadyExists",true);
				return "jobseekerregister";
			}
			
			userDao.create(jobseeker.getName(), jobseeker.getPassword(), jobseeker.getEmailAddress(), jobseeker.getFirstName(), jobseeker.getLastName());//userDao.create(person.getName(), person.getPassword(), person.getEmail(), person.getFirstName(), person.getLastName());
			
			// DAO.close(); create(String username, String password,String emailId, String firstName, String lastName) View and Apply Job !
		} catch (HibernateException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addedUser";
	}

	}
