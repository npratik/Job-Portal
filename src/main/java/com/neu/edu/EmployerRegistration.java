package com.neu.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.neu.pojo.Employer;
import com.neu.pojo.Person;

@Controller
//@RequestMapping("/employerregister.htm")
public class EmployerRegistration {
	
	@Autowired
	@Qualifier("userValidatorEmployer")
	UserValidatorEmployer validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value="/employerregistervalidate.htm",method = RequestMethod.POST)//@RequestMapping(method = RequestMethod.POST) blob
	protected String doSubmitAction(@ModelAttribute("employer") Employer employer, BindingResult result,HttpServletRequest request,HttpServletResponse response,Model model) throws Exception { //@ModelAttribute("person") Person person
		validator.validate(employer, result);
		if (result.hasErrors()) {
			return "employerregister";
		}

		try {
			System.out.print("test");
			UserDAO userDao = new UserDAO();
			System.out.print("test1");
			
			Person person = userDao.checkUserExists(employer.getName());
			
			if(person!=null){
				model.addAttribute("erroremployerAlreadyExists",true);
				//return "userAlreadyExists";
				return "employerregister";
			}
			
			userDao.createEmployer(employer.getName(), employer.getPassword(), employer.getEmailAddress(), employer.getFirstName(), employer.getLastName(), employer.getCompanyID());//userDao.create(person.getName(), person.getPassword(), person.getEmail(), person.getFirstName(), person.getLastName());
			
			// DAO.close(); create(String username, String password,String emailId, String firstName, String lastName)
		} catch (HibernateException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addedEmployer";
	}
   

}
