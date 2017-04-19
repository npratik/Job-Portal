package com.neu.edu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neu.pojo.Person;

@Controller
public class LoginController {
	
	@RequestMapping("/employerLogin.htm")
	public String loginview(@ModelAttribute("person") Person person, BindingResult result,HttpServletRequest request){
		return "employerLogin";
	}

}
