package com.neu.edu;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.pojo.Jobseeker;
import com.neu.pojo.Person;

@Component
public class UserLoginValidator  implements Validator {
    
	@Override
    public boolean supports(Class aClass)
    {
        return aClass.equals(Person.class);
    }
    
	@Override
    public void validate(Object obj, Errors errors)
    {
		Person user = (Person) obj;
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.user", "User Name Required*");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "Password Required*");
       //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "error.invalid.user", "Email Required");
        
    }
}
