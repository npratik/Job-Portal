package com.neu.edu.dao;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.JobsApplied;
import com.neu.pojo.AppliedJobs;
import com.neu.pojo.Jobs;
import com.neu.pojo.Jobseeker;
import com.neu.spring.exception.AdException;


//import com.yusuf.spring.exception.AdException;

public class JobListDAO extends DAO {
   
	public JobListDAO(){
	}
	
	
	public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Jobs");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the Jobs", e);
        }
    }
	
	public Boolean checkifResumeExists(long personid){
		
		
		Query q=getSession().createQuery("from Jobseeker where personID=:personID");
		q.setLong("personID",personid);
		
	
		
		Jobseeker jobseeker=(Jobseeker) q.uniqueResult();
		
		if(jobseeker.getContent()!=null){
			
			return true;
		}
				
		//System.out.println(jobSeekerId+"Job Seeker Person-Id");
		
		return false;
	}
	
	public List getListofJobs( long jobSeekerId) throws AdException{
	
	try {
		//List<Jobs> jobList = new ArrayList<Jobs>();//check*****
		
		System.out.println("In side HQL jobseekerid" + jobSeekerId);
		
		 begin();
         Query q = getSession().createQuery("from Jobs jt where jt.jobId not  in"+"( select aj.jobs from  AppliedJobs aj where  "+"  aj.jobseeker =:jobSeekerId)");
         //also add status of job as available****
         q.setLong("jobSeekerId", jobSeekerId);
         
         List jobList = q.list();
         commit();
		
		return jobList;
		
	} catch (HibernateException e) {
        rollback();
        throw new AdException("Could not list the Jobs", e);
    }
	}
	
	//jobSeekerId,jobId
	public void jobApplied(long jobSeekerId, long jobId) {
		// TODO Auto-generated method stub
		AppliedJobs appliedJobs=new AppliedJobs();
		try{
			begin();
			Query q=getSession().createQuery("from Jobseeker where personID=:personID");
			q.setLong("personID",jobSeekerId);
			
		
			
			Jobseeker jobseeker=(Jobseeker) q.uniqueResult();
			System.out.println(jobSeekerId+"Job Seeker Person-Id");
			
			
			
			Query query=getSession().createQuery("from Jobs where id=:jobId");
			query.setLong("jobId",jobId);
			
			Jobs jobs =(Jobs) query.uniqueResult();
			//System.out.println(jobId);
			
			appliedJobs.setJobStatus("Applied");
			appliedJobs.setJobs(jobs);
			appliedJobs.setJobseeker(jobseeker);
			appliedJobs.setResumeName(jobseeker.getFilename());
			appliedJobs.setFileType(jobseeker.getContentType());//check file type*****
			appliedJobs.setContentDetails(jobseeker.getContent()); //check*****
			
			
			//getSession().update(js);
			//getSession().update(j);
			getSession().save(appliedJobs);
			commit();
			System.out.println(appliedJobs.getJobStatus());
			
		}
		catch(Exception e){
			e.printStackTrace();
			rollback();
			
			
			
		}
		
	}
	
	
	//list of posted jobs for Employer
	
	public List<Jobs> getPostedJobsList(long personid) {
		List<Jobs> jobs=new ArrayList<Jobs>();
		try{begin();
		Query query =getSession().createQuery("from Jobs where personID=:personid");
		query.setLong("personid",personid);
		
		System.out.println("Employer Person ID in posted jobsList menthod- JobList DAO --  " + personid);
		jobs= query.list();
		
		System.out.println("Employer Person ID in posted jobsList menthod- JobList DAO -- jobs   " + jobs);
		commit();
		
		}
		catch(Exception e){
			e.printStackTrace();
			rollback();
			
		}
		return jobs;
		
	}
	
	public List ListOfPostedJobs(long personid) throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Jobs where personID=:personid");
            q.setLong("personid",personid);
            
            System.out.println("Employer Person ID in posted jobsList menthod- JobList DAO -- ** " + personid);
            
            List list = q.list();
            
            System.out.println("Employer Person ID in posted jobsList menthod- JobList DAO -- jobs  ** " + list);
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the Jobs", e);
        }
    }
	
	public List<AppliedJobs> getJobApplicatsList(long userId, long jobId) {
		AppliedJobs ja=new AppliedJobs();// TODO Auto-generated method stub
		
		List<AppliedJobs> applicants=new ArrayList<AppliedJobs>();
		
		
		try{
			begin();
			//Query q=getSession().createQuery("from Jobs where jobId=:jobId");
			//q.setLong("jobId",jobId);
			
			//Jobs j=(Jobs) q.uniqueResult();
			
			Query qu=getSession().createQuery("from AppliedJobs where jobId=:j");
			qu.setLong("j", jobId);//qu.setLong("j", jobId); check*****
			
			applicants=qu.list();
					
			commit();
			
		}
		catch(Exception e){
			rollback();
		}
		
		return applicants;
	}

	public List<AppliedJobs> getListOfAppliedJobs(long personId) {
		AppliedJobs ja=new AppliedJobs();// TODO Auto-generated method stub
		
		List<AppliedJobs> applicants=new ArrayList<AppliedJobs>();
		
		
		try{
			begin();
			//Query q=getSession().createQuery("from Jobs where jobId=:jobId");
			//q.setLong("jobId",jobId);
			
			//Jobs j=(Jobs) q.uniqueResult();
			
			Query qu=getSession().createQuery("from AppliedJobs where jobseeker=:j");
			qu.setLong("j", personId);//qu.setLong("j", jobId); check*****
			
			applicants=qu.list();
					
			commit();
			
		}
		catch(Exception e){
			rollback();
		}
		
		return applicants;
	}
	
	public void uploadResume(long personID, Blob blob, String originalFilename, String contentType) {
		begin();
		Query q = getSession().createQuery("from JobSeeker where personID = :personID");
		 q.setLong("personID",personID);
		 
		 Jobseeker jobseeker = (Jobseeker) q.uniqueResult(); 
		 
		 jobseeker.setContent(blob);
		 jobseeker.setFilename(originalFilename);
		 jobseeker.setContentType(contentType);
		 
		 //if(jobseeker.getContent().e)
		 
		 //jobseeker.setContent(blob);
		 
		 getSession().update(jobseeker);
		 commit();
		
	}
	
	public void uploadResumeNew(long personId, Blob resumeFile, String originalFilename, String contentType, String skills) {
		begin();
		Query q = getSession().createQuery("from Jobseeker where personID = :personId");
		q.setLong("personId",personId);
		System.out.println(resumeFile);
		Jobseeker j = (Jobseeker) q.uniqueResult(); 
		System.out.println(contentType);
		j.setContent(resumeFile);
		j.setFilename(originalFilename);
		j.setContentType(contentType);
		 j.setSkills(skills);
		getSession().update(j);
		commit();
		
	}
	
	public AppliedJobs getAppliedResume(long jobId) {
		AppliedJobs jobApplied=new AppliedJobs(); //remove if not required but its being used****
		try{
			
			begin();
			Query query=getSession().createQuery("from AppliedJobs where appliedid=:jobId");
			query.setLong("jobId",jobId);
			jobApplied=(AppliedJobs) query.uniqueResult();
			commit();
			
		}
		catch(Exception e){
			e.printStackTrace();
			rollback();
		}
		
		return jobApplied;
		
	}
	
	//getApplicantId
	
	public AppliedJobs getApplicantId(long jobId) {
		AppliedJobs jobApplied=new AppliedJobs(); //remove if not required but its being used****
		try{
			
			begin();
			Query query=getSession().createQuery("from AppliedJobs where appliedid=:jobId");
			query.setLong("jobId",jobId);
			jobApplied=(AppliedJobs) query.uniqueResult();
			commit();
			
		}
		catch(Exception e){
			e.printStackTrace();
			rollback();
		}
		
		return jobApplied;
		
	}
	
	//updatestatus
	
public void updatestatus(String status, long jobsAppliedID, String message) {
		
	AppliedJobs appliedJobs;//= new AppliedJobs();//applicantobj
			
			//Jobseeker js = (Jobseeker) session.getAttribute("userObj");
		
		try{
			begin();
			Query q=getSession().createQuery("from AppliedJobs where appliedid=:jobsAppliedID");
			q.setLong("jobsAppliedID", jobsAppliedID);
			
			 System.out.println("inside file Changestatus controller DAO" + jobsAppliedID +" " +status );
			
			 appliedJobs=(AppliedJobs) q.uniqueResult();
			 
			appliedJobs.setJobStatus(status);
			
			appliedJobs.setMessage(message);
			
			getSession().update(appliedJobs);
			
			
			commit();
			
		}
		catch(Exception e){
			rollback();
		}
	
		
	}
	
}
