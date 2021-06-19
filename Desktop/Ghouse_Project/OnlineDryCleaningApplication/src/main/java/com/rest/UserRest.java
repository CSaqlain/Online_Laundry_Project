package com.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.User;
import com.exception.EntityCreationException;
import com.exception.ForBiddenException;
import com.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserRest {

	@Autowired
	IUserService userService;

	@Autowired
	LoginRest logCon;

	@PostMapping("/validate/{username}/{password}")
	HttpStatus validateUser(@PathVariable String username, @PathVariable String password) throws Exception {
		if (!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException();
		return userService.validateUser(username, password);
	}

	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) throws EntityCreationException, ForBiddenException {
		if (!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException();
		return userService.addUser(user);
	}

	@DeleteMapping("/removeuser")
	public User removeUser(@RequestBody User user) throws ForBiddenException {
		if (!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException();
		User user2 = userService.removeUser(user);
		return user2;
	}

}
