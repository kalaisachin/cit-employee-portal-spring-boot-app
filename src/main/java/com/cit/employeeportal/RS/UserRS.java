package com.cit.employeeportal.RS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cit.employeeportal.dao.UserDAO;
import com.cit.employeeportal.model.UserDO;

@CrossOrigin(origins = { "http://localhost:3000",
"http://192.168.61.135:3000",
"https://master.d3krxm1i7x78gx.amplifyapp.com"}, maxAge = 4800, allowCredentials = "false")


@RestController
@RequestMapping(value = "/")
public class UserRS {
	
private final Logger LOG = LoggerFactory.getLogger(getClass());

	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/getmessage")
	public String getMessage() {
		return "Greeting from CIT Family !!!!";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void addNewUser(@RequestBody UserDO userDO) {
		userDAO.addNewUser(userDO);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateUsers(@RequestBody UserDO userDO) {
		userDAO.updateEmployeeDetails(userDO);
	}
	
	@RequestMapping(value = "/finduser/{username}", method = RequestMethod.GET)
	public UserDO findById(@PathVariable String username) {
		LOG.info("Getting all users." + username);
		return userDAO.getOneEmployeeDetails(username);
	}
	
	@RequestMapping(value = "/checkUserAvailability/{username}", method = RequestMethod.GET)
	public Integer checkUserAvailability(@PathVariable String username) {
		LOG.info("Getting all users." + username);
		Integer usercount = 0;
		// JsonObject listLength = new JsonObject();
		UserDO userDO = userDAO.getOneEmployeeDetails(username);
		if (userDO == null) {
			usercount = 0;
		} else {
			usercount = 1;
		}
		return usercount;
	}

}
