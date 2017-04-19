package com.neu.pojo;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;




@Entity
@Table
@PrimaryKeyJoinColumn(name="personID")
public class Jobseeker extends Person {
	
	//@Column(name="currentPosition")
	
	@Column(name="monthsOfExperience")
	private String monthsOfExperience;
	
	@Column(name="currentCompany")
	private String currentCompany;
	
	@Column(name="education")
	private String education;
	//private String resume;
	
	@Column(name="currentDesignation")
	private String currentDesignation;
	
	// Attributes for file upload
	/*@Column(name="name")
    private String name;
 
    @Column(name="description")
    private String description;*/
 
    @Column(name="filename")
    private String filename;
 
    @Column(name="content")
    @Lob
    private Blob content;
     
    @Column(name="fileType")
    private String fileType;
    
    @Column
    private String skills;
    
    
    public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	//Relationship and mapping with applied jobs
    @OneToMany(mappedBy="jobseeker")
     private Set<AppliedJobs> appliedJobs = new	HashSet<AppliedJobs>();
    
    
	public Jobseeker(){}
	//Check*** if any parameters should be passed in this constructor
	public Jobseeker(String monthsOfExperience,String currentCompany, String currentDesignation){
		this.monthsOfExperience = monthsOfExperience;
		this.currentCompany = currentCompany;
		this.currentDesignation = currentDesignation;
	}
	
	public String getMonthsOfExperience() {
		return monthsOfExperience;
	}
	public void setMonthsOfExperience(String monthsOfExperience) {
		this.monthsOfExperience = monthsOfExperience;
	}
	public String getCurrentCompany() {
		return currentCompany;
	}
	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	
	/*
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	*/
	public String getCurrentDesignation() {
		return currentDesignation;
	}
	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Blob getContent() {
		return content;
	}
	public void setContent(Blob content) {
		this.content = content;
	}
	public String getContentType() {
		return fileType;
	}
	public void setContentType(String contentType) {
		this.fileType = contentType;
	}
	public Set<AppliedJobs> getAppliedJobs() {
		return appliedJobs;
	}
	public void setAppliedJobs(Set<AppliedJobs> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}
	
	
	
	

}
