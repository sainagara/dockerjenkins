package com.user.login.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.login.Dto.UserLogInDto;
import com.user.login.service.UserLogInService;

@RestController
@RequestMapping("/userLogIn")
public class UserLogInRestController {
	@Autowired
	private UserLogInService userService;
	

	@PostMapping("/verifyLogin")
	public JSONObject verifylogin(@RequestBody UserLogInDto users)
	{
		 return userService.verifylogin(users);
		 
	} 

}
