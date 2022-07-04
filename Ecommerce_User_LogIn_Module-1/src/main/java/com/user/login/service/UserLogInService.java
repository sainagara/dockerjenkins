package com.user.login.service;

import org.json.simple.JSONObject;

import com.user.login.Dto.UserLogInDto;



public interface UserLogInService {
	JSONObject verifylogin(UserLogInDto users);

}
