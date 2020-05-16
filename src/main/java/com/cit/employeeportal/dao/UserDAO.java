package com.cit.employeeportal.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.cit.employeeportal.model.UserDO;

@Repository
public class UserDAO {
	
	@Autowired
	private DynamoDBMapper mapper;
	
	public static final String TABLE_NAME = "employeeportal";
	
	public void addNewUser(UserDO userDO) {
		System.out.println("getting in into DAO Method");
		mapper.save(userDO);
	}
	
	public UserDO getOneEmployeeDetails(String username) {
		return mapper.load(UserDO.class, username);
	}
	
	public void updateEmployeeDetails(UserDO userDO) {
		try {
			mapper.save(userDO);
		} catch (ConditionalCheckFailedException ex)   {
			System.out.println(ex.getMessage());
		}
	}
	
	public DynamoDBSaveExpression buildDynamoDbSaveExpression(UserDO userDO) {
		DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expected = new HashMap<>();
		expected.put("username", new ExpectedAttributeValue(new AttributeValue(userDO.getUsername())))
		.withComparisonOperator(ComparisonOperator.EQ);
		dynamoDBSaveExpression.setExpected(expected);
		return dynamoDBSaveExpression;
	}
	
}
