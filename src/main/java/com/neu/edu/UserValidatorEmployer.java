package com.neu.edu;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.pojo.Employer;
import com.neu.pojo.Jobseeker;

@Component
public class UserValidatorEmployer implements Validator {
    
	@Override
    public boolean supports(Class aClass)
    {
        return aClass.equals(Employer.class);
    }
    
	@Override
    public void validate(Object obj, Errors errors)
    {
		Employer user = (Employer) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.user", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "Password Required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "error.invalid.user", "Email Required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyID", "error.invalid.user", "Company ID Required");
        
    }
}


