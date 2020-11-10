package com.forest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.forest.model.User;
import com.forest.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/Login")
	public @ResponseBody String login(User user)
	{
		return userService.login(user);
	}
	@PostMapping("/")
	public @ResponseBody User insertUser(@RequestBody User user)
	{
		return userService.insertUser(user);
	}
	@DeleteMapping("/{username}")
	public @ResponseBody boolean deleteUser(@PathVariable("username") String userName)
	{
		return userService.deleteAdminbyName(userName);
		
	}
	@GetMapping("/Logout")
	public @ResponseBody String logout(User user)
	{
		return userService.logout(user);
	}
	
	
}

