package com.products.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.products.Dto.LaptopsDto;
import com.products.model.Laptops;



public interface LaptopsService {
	List<Laptops> getAllLaptops();

	JSONObject saveLaptops(Laptops laptop);

	JSONObject updateLaptops(LaptopsDto laptopDto, int productId);

	JSONObject delateLaptops(int id);

}
