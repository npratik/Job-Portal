package com.neu.edu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.pojo.Jobseeker;
import com.neu.pojo.Person;

@Controller
@RequestMapping("/uploadResume.htm")

public class UploadDocument {
	
//public String doSubmitAction(@ModelAttribute("jobseeker") Jobseeker jobseeker, BindingResult result) throws Exception {//(@ModelAttribute("person") Person person, BindingResult result,HttpServletRequest request) {
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("jobseeker") Jobseeker jobseeker, BindingResult result) throws Exception { //@ModelAttribute("person") Person person	
		
		return "documents";
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("jobseeker") Jobseeker person, BindingResult result) {//public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {

		return "documents";
	}

}


