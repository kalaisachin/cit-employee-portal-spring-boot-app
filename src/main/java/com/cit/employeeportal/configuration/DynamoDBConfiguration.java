package com.cit.employeeportal.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;



@Configuration
public class DynamoDBConfiguration {
	
	@Value("${aws.access.key}")
	private String accessKey;
	
	@Value("${aws.access.secret-key}")
	private String secretKey;
	
	@Value("${aws.access.region}")
	private String region;
	
	@Value("${aws.access.dbendpointurl}")
	private String dbEndPoint;
	
	@Bean
	public DynamoDBMapper mapper() {
		return new DynamoDBMapper(dynamoDbConfiguration ());
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
	    AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
	    amazonDynamoDB.setEndpoint(dbEndPoint);
	    return amazonDynamoDB;
	}
	
	@Bean
	public AWSCredentials amazonAWSCredentials() {
	    return new BasicAWSCredentials(accessKey, secretKey);
	}
	
	public AmazonDynamoDB dynamoDbConfiguration () {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dbEndPoint, region))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
				.build();
	}

}
