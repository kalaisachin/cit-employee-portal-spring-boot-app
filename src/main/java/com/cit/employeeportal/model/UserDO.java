package com.cit.employeeportal.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="employeeportal")
public class UserDO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String designation;
	
	private String emailId;
	
	private Float rating;
	
	private String experienceLevel;
	
	private Integer totalProjects;
	
	private String communicationLevel;
	
	private Float availability;
	
	private Long mobile;
	
	private Map<String, String> userProfile = new HashMap<>();
	
	@DynamoDBHashKey(attributeName = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@DynamoDBAttribute(attributeName = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@DynamoDBAttribute(attributeName = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@DynamoDBAttribute(attributeName = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@DynamoDBAttribute(attributeName = "designation")
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@DynamoDBAttribute(attributeName = "emailId")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@DynamoDBAttribute(attributeName = "rating")
	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	@DynamoDBAttribute(attributeName = "experienceLevel")
	public String getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	@DynamoDBAttribute(attributeName = "totalProjects")
	public Integer getTotalProjects() {
		return totalProjects;
	}

	public void setTotalProjects(Integer totalProjects) {
		this.totalProjects = totalProjects;
	}

	@DynamoDBAttribute(attributeName = "communicationLevel")
	public String getCommunicationLevel() {
		return communicationLevel;
	}

	public void setCommunicationLevel(String communicationLevel) {
		this.communicationLevel = communicationLevel;
	}

	@DynamoDBAttribute(attributeName = "availability")
	public Float getAvailability() {
		return availability;
	}

	public void setAvailability(Float availability) {
		this.availability = availability;
	}

	@DynamoDBAttribute(attributeName = "mobile")
	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	@DynamoDBAttribute(attributeName = "userProfile")
	public Map<String, String> getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(Map<String, String> userProfile) {
		this.userProfile = userProfile;
	}
}
