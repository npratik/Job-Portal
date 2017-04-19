package com.neu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table//(name="job") Check****
public class Jobs {
	
	
    public Jobs(){
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="jobId",unique=true,nullable=false)
    private long jobId;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="personID")
    private Employer employer;
	
	//Mapping with AppliedJobs Table
	
		@OneToMany(mappedBy="jobs")
		private Set<AppliedJobs> appliedJobs = new HashSet<AppliedJobs>();
		
	/*
	private long personID;
	
	public void seJobtPersonId(long personID) {
		this.personID = personID;
	}

	public long getJobPersonId() {
		return personID;
	}
	
	*/
	
	@Column(name="jobType")
	private String jobType;
	
	@Column(name="company")
	private String company;
	
	@Column(name="technology")
	private String technology;
	
	@Column(name="jobRole")
	private String jobRole;
	
	@Column(name="jobLocation")
	private String jobLocation;
	
	@Column
	private String jobDescrition;
	
	@Column
	private String jobEffectiveStatus;
	
	
	
	
	
	public String getJobDescrition() {
		return jobDescrition;
	}

	public void setJobDescrition(String jobDescrition) {
		this.jobDescrition = jobDescrition;
	}

	public String getJobEffectiveStatus() {
		return jobEffectiveStatus;
	}

	public void setJobEffectiveStatus(String jobEffectiveStatus) {
		this.jobEffectiveStatus = jobEffectiveStatus;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public Set<AppliedJobs> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(Set<AppliedJobs> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}

		
	
	

}
