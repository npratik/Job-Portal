package com.neu.pojo;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class AppliedJobs {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appliedJobsID",unique=true,nullable=false)
	private long appliedid;//check if you just need id
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="personID")
	private Jobseeker jobseeker;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="jobId")
	private Jobs jobs;
	
	
	public AppliedJobs(){
		
	}
	
	@Column
	private String jobStatus;
	
	//check*** if below mentioned are required****
	@Column(name="resumeName")
	private String resumeName;
	
	@Column(name="fileType")
	private String fileType;
	
	@Column(name="contentDetails")
    @Lob
    private Blob contentDetails;
	
	@Column
	private String message;
	
	


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getAppliedid() {
		return appliedid;
	}

	public void setAppliedid(long appliedid) {
		this.appliedid = appliedid;
	}

	public Jobseeker getJobseeker() {
		return jobseeker;
	}

	public void setJobseeker(Jobseeker jobseeker) {
		this.jobseeker = jobseeker;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getResumeName() {
		return resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Blob getContentDetails() {
		return contentDetails;
	}

	public void setContentDetails(Blob contentDetails) {
		this.contentDetails = contentDetails;
	}
	
	
	
	
	

}
