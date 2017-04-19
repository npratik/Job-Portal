package com.neu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@PrimaryKeyJoinColumn(name="personID")
public class Employer extends Person {
	
	@Column(name="companyName")
	private String companyName;
	
	//private String companyType;
	
	@Column(name="companyAddress")
	private String companyAddress;
	@Column(name="companyContact")
	private String companyContact;
	
	private String companyID;
	
	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public Employer(){
		
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/*
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}*/
	
	//Check*** this removed for testing****
	@OneToMany(fetch=FetchType.EAGER,mappedBy="employer")
	private Set<Jobs> jobs = new HashSet<Jobs>();
	
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyContact() {
		return companyContact;
	}
	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}
	
	

}
