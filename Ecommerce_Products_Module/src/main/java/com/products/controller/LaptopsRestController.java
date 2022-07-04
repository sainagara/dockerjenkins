package com.products.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.Dto.LaptopsDto;
import com.products.model.Laptops;
import com.products.service.LaptopsService;

@RestController
@RequestMapping("/products/laptops")
public class LaptopsRestController {
	@Autowired
	private LaptopsService laptopsService;
	
	@GetMapping(value="/getAllLaptops")
	public List<Laptops> getAllLaptops()
	{
		 return laptopsService.getAllLaptops();
		 
	}
	@PostMapping(value="/saveLaptops")
	public JSONObject saveLaptops(@RequestBody Laptops laptop) {
		return laptopsService.saveLaptops(laptop);
		
	}
	@PutMapping(value="/updateLaptops/{productId}")
	public JSONObject updateLaptops(@RequestBody LaptopsDto laptopDto,@PathVariable int productId)
	{
		return laptopsService.updateLaptops(laptopDto, productId);
		
	}
	@DeleteMapping(value="/deleteLaptops/{id}")
	public JSONObject delateLaptops(@PathVariable int id)
	{
		return laptopsService.delateLaptops(id);
		
	}

}
