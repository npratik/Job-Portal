package com.neu.edu;

//import javax.inject.Qualifier;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
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
import org.springframework.web.context.request.SessionScope;

import com.neu.edu.dao.UserDAO;
import com.neu.pojo.Person;


@Controller
//@RequestMapping("/jobseekerLogin.htm")
public class JobseekerLogin {
	@Autowired
    @Qualifier("userLoginValidator")
	UserLoginValidator validator;

		@InitBinder
		private void initBinder(WebDataBinder binder) {
			binder.setValidator(validator);
		}

	@RequestMapping(value = "/jobseekerLogin.htm",method = RequestMethod.POST) // @RequestMapping(method = RequestMethod.POST)
		protected String doSubmitAction(@ModelAttribute("person") Person person, BindingResult result,HttpServletRequest request,HttpServletResponse response, Model model) throws Exception {
		//public String submitForm(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("person")Person person,Model model,BindingResult result) throws Exception{
			validator.validate(person, result);
			if (result.hasErrors()) {
				return "employerLogin";
			}

			try {
				System.out.print("test");
				UserDAO userDao = new UserDAO();
				Person personAccount=userDao.authenticateUsernameAndPassword(person.getName(),person.getPassword());
                
				HttpSession currentSession = request.getSession();
				 if( personAccount==null) {
					 model.addAttribute("errorInvalidUserIDpsw" , true);
					 //return "InvalidUser";
					 return "employerLogin";
				 }
		      //		return "addedJob";
			
				if(personAccount.getUserROle().equalsIgnoreCase("jobseeker")){//testing*****
					
					currentSession.setAttribute("employeeSession", personAccount);
					return "jobseekerdashboard";	
					
					//currentSession.setAttribute("employeeSession", personAccount);
					
				}
				
				if(personAccount.getUserROle().equalsIgnoreCase("employer")){//testing*****
					
					 currentSession.setAttribute("employerSession", personAccount);
					
					 
					return "employerdashboard";	
				}
				
				System.out.print("test123");
				
				//userDao.create(person.getName(), person.getPassword(), person.getEmail(), person.getFirstName(), person.getLastName());
				
				// DAO.close(); create(String username, String password,String emailId, String firstName, String lastName)
			} catch (HibernateException e) {
				System.out.println("Exception: " + e.getMessage());
				return "addedJob"; //testing****
			}
            
			System.out.print("test123 in try catch method");
			return "addedJob"; //"jobseekerdashboard"; //need to return some login error page check******
		}

		
	}
