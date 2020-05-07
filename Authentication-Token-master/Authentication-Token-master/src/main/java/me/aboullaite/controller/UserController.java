package me.aboullaite.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.aboullaite.model.User;
import me.aboullaite.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("/user")
@Api(value = "The user Controller", description = "Rest controller for user")
public class UserController {

	@Autowired
	private UserService userService;
	@ApiOperation(value = "Get all services",
			produces = "A list of services",
			notes = "Hit this URL to get all services details"
			)


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void registerUser(@RequestBody User user) {
		userService.addUser(user);
	}
	@ApiOperation(value = "Add a service",
			consumes = "A new product is JSON",
			notes = "Hit this URL to insert a new services's details"
			)
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User login) throws ServletException {

		String jwtToken = "";

		if (login.getEmail() == null || login.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String email = login.getEmail();
		String password = login.getPassword();

		User user = userService.getByEmail(email);

		if (user == null) {
			
			throw new ServletException("User email not found.");
			
		}

		String pwd = user.getPassword();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}

		jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		return jwtToken;
	}
}
