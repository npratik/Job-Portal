package com.neu.edu.dao;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.pojo.Employer;
import com.neu.pojo.Jobs;
import com.neu.pojo.Jobseeker;
import com.neu.pojo.Person;
import com.neu.spring.exception.AdException;

//import com.yusuf.spring.exception.AdException;
//import com.yusuf.spring.pojo.Email;
//import com.yusuf.spring.pojo.Person;
//import com.yusuf.spring.pojo.User;

public class UserDAO extends DAO {
	
    public UserDAO() {
    }

    public Person get(String name)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Person where name = :name");
            q.setString("name", name);
            Person person = (Person) q.uniqueResult();
            commit();
            return person;
        } catch (HibernateException e) {
            rollback();
           throw new AdException("Could not get user " + name, e);
        }
		//return null; //check****** had to insert to avoid errors
    }
 
    
    public Person checkUserExists(String username) throws Exception{
    	
    	try {
			System.out.println( "username >>>" + username);
			//System.out.println( "password >>>" + password);
            Query query = getSession().createQuery("from Person where name = :username ");
            
            query.setString("username", username);
            //query.setString("password", password);
            
            Person personDetails = (Person) query.uniqueResult();
           
            if(personDetails!=null){
            	System.out.println("user exits");
            }
            close();
            return personDetails;
		} catch (HibernateException e) {
			
            throw new Exception("Could not get user " + username, e);
		}	
    }
    	//return false;
    
    
    
    public Jobseeker create(String username, String password,String emailId, String firstName, String lastName)//public Person create(String username, String password,String emailId, String firstName, String lastName)
    throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
            //Email email=new Email(emailId);
            //User user=new User(username,password);
           //new Person(username,password);
            //Person person = new Person();
            
            Jobseeker person = new Jobseeker("10", "Company name", "Designation");
            
            person.setFirstName(firstName);
            person.setLastName(lastName);
            
            person.setPassword(password);
            
            person.setEmailAddress(emailId);
            
            person.setName(username);
            
            person.setUserRole("jobseeker");
            
            getSession().save(person);
            
            commit();
            
            return person;
            
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
           throw new AdException("Exception while creating user in userDAO: " + e.getMessage());
        }
        
    }
    
    //createEmployer
    public Employer createEmployer(String username, String password,String emailId, String firstName, String lastName, String companyID)//public Person create(String username, String password,String emailId, String firstName, String lastName)
    	    throws AdException {
    	        try {
    	            begin();
    	            System.out.println("inside DAO");
    	            
    	            //Email email=new Email(emailId);
    	            //User user=new User(username,password);
    	           //new Person(username,password);
    	            //Person person = new Person();
    	            
    	            //Check*** need to save other fields as well
    	            Employer person = new Employer();
    	            
    	            person.setFirstName(firstName);
    	            person.setLastName(lastName);
    	            
    	            person.setPassword(password);
    	            
    	            person.setEmailAddress(emailId);
    	            
    	            person.setName(username);
    	            
    	            person.setCompanyID(companyID);
    	            
    	            // quert q = getsession().createquery(" username")
    	            //
    	            //Employee e = (Employee) q1.uniqueQuery;
    	           
    	            /* from here*******
    	            Query q = getSession().createQuery("from employee where name = :name");
    	            q.setString("name", name);
    	            Person person = (Person) q.uniqueResult();
    	            */
    	            person.setUserRole("employer");
    	            
    	            getSession().save(person);
    	            
    	            commit();
    	            
    	            return person;
    	            
    	        } catch (HibernateException e) {
    	            rollback();
    	            //throw new AdException("Could not create user " + username, e);
    	           throw new AdException("Exception while creating user in userDAO: " + e.getMessage());
    	        }
    	        
    	    }
    
    
    public Jobs createJobs(String company, String jobLocation, String jobRole, String jobType, String technology, Employer employer, String name, String jobDescription)throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
            //Email email=new Email(emailId);
            //User user=new User(username,password);
           //new Person(username,password);
            //Person person = new Person();
            
            //Check*** need to save other fields as well
            Jobs job = new Jobs();
            
            job.setCompany(company);
            job.setJobLocation(jobLocation);
            job.setJobRole(jobRole);
            job.setJobType(jobType);
            job.setTechnology(technology);
            job.setJobDescrition(jobDescription);
           // job.setEmployer(employer);
           // job.seJobtPersonId(personID);
            
            Query q = getSession().createQuery("from Person where name = :name");
            q.setString("name", name);
            Person person = (Person) q.uniqueResult();
           
            long personid = person.getPersonID();
            
            System.out.println( "personid >>>" + personid);
            
            Query q1 = getSession().createQuery("from Employer where personID = :personid");
            q1.setLong("personid", personid);
            Employer employer1 = (Employer) q1.uniqueResult();
            
            job.setEmployer(employer1);
            getSession().save(job);
            
            commit();
            
            return job;
            
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e); 
           throw new AdException("Exception while creating job in userDAO: " + e.getMessage());
        }
        
    }
    //(jobs.getCompany(), jobs.getJobLocation(), jobs.getJobRole(), jobs.getJobType(),jobs.getTechnology(), personAccount.getPersonID()); noResumeExists
    

    public void delete(Person person)
            throws AdException {
        try {
            begin();
            getSession().delete(person);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + person.getName(), e);
        }
    }
    
    public Person authenticateUsernameAndPassword(String name, String password)
            throws Exception {
		try {
			System.out.println( "name >>>" + name);
			System.out.println( "password >>>" + password);
            Query query = getSession().createQuery("from Person where name = :name and password = :password");
            
            query.setString("name", name);
            query.setString("password", password);
            
            Person personDetails = (Person) query.uniqueResult();
           
            if(personDetails==null){
            	System.out.println("no user exits");
            }
            close();
            return personDetails;
		} catch (HibernateException e) {
			
            throw new Exception("Could not get user " + name, e);
		}	
    }
}