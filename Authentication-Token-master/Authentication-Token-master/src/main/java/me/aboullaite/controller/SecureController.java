package me.aboullaite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.aboullaite.model.User;
import me.aboullaite.service.UserService;

@RestController
@RequestMapping("/secure")
@Api(value = "The security Controller", description = "Rest controller for security")


public class SecureController {

	@Autowired
	private UserService userService;
	@ApiOperation(value = "Get all services",
			produces = "A list of services",
			notes = "Hit this URL to get all services details"
			)


	@RequestMapping("/user/users")
	public String loginSuccess() {
		return "Login Successful!";
	}
	@ApiOperation(value = "Add a service",
			consumes = "A new product is JSON",
			notes = "Hit this URL to insert a new services's details"
			)
	

	@RequestMapping(value = "/user/email", method = RequestMethod.POST)
	public User findByEmail(@RequestBody String email) {
		return userService.getByEmail(email);
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public User updateUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}
