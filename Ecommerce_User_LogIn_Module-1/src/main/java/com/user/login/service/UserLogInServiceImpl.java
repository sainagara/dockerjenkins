package com.user.login.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.user.login.Dto.UserLogInDto;
import com.user.login.entity.User;
import com.user.login.repositories.UserRepository;

@Service
public class UserLogInServiceImpl implements UserLogInService {
	@Autowired
	private UserRepository userRepo;
	public JSONObject userResponse(String status,String message, String accessToken)
	{

   	 JSONObject obj=new JSONObject();
   	 obj.put("ststus",status);
   	 obj.put("message",message);
   	 obj.put("accessToken",accessToken);
   	 return obj;
	}

	@Override
	public JSONObject verifylogin(UserLogInDto users) {
		String email = users.getEmail();
		 String password = users.getPassword();
	     User user = userRepo.findByEmail(email);
	     UserLogInServiceImpl userServ=new UserLogInServiceImpl();
	     if(user!=null) {
	     if(user.getEmail().equals(email)&& user.getPassword().equals(password))
	     {
	    	return userServ.userResponse("Ok","Log In was succesfull" , "eyJhbGciOiJIUzI1NiIsInR5c3...");
	    	 
	     }
	    
	     else
	     {
	    	 return userServ.userResponse("Not Ok","Please enter valid user name and password" , "eyJhbGciOiJIUzI1NiIsInR5d4...");
	    	 
	     }
	     }
	     else
	     {
	    	  return userServ.userResponse("Not Ok","User does not exists Please enter valid user name" , "eyJhbGciOiJIUzI1NiIsInR5f5...");
	    	  
	     }
		
	}

}
