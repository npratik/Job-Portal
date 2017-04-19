package com.neu.edu;

import org.springframework.stereotype.Component;

//import com.yusuf.spring.pojo.User;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.pojo.Jobseeker;
import com.neu.pojo.Person;

import org.springframework.validation.ValidationUtils;
@Component
public class UserValidator implements Validator {
    
	@Override
    public boolean supports(Class aClass)
    {
        return aClass.equals(Jobseeker.class);
    }
    
	@Override
    public void validate(Object obj, Errors errors)
    {
    	Jobseeker user = (Jobseeker) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.user", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "Password Required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "error.invalid.user", "Email Required");
        
    }
}

