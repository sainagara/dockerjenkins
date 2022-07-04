package com.products.service;


import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Override
	public JSONObject productsResponse(String status,String message, String accessToken)
	{

   	 JSONObject obj=new JSONObject();
   	 obj.put("ststus",status);
   	 obj.put("message",message);
   	 obj.put("accessToken",accessToken);
   	 return obj;
	}

	

}
