package com.products.service;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.Dto.LaptopsDto;
import com.products.model.Laptops;
import com.products.repositories.LaptopsRepository;

@Service
public class LaptopsServiceImpl implements LaptopsService {
	@Autowired
	private LaptopsRepository laptopRepo;
	@Autowired
	private ProductsService productServ;
	@Override
	public List<Laptops> getAllLaptops() {
		return laptopRepo.findAll();
		
	}

	@Override
	public JSONObject saveLaptops(Laptops laptop) {
		ProductsServiceImpl productsServ=new ProductsServiceImpl();
		Laptops save = laptopRepo.save(laptop);
		if(save!=null)
		{
			return productsServ.productsResponse("ok","Laptops Details are Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	    	 
		}
		else
		{
			return productsServ.productsResponse("Not ok","Laptops Details are NOT Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	    	  
		}
	}

	@Override
	public JSONObject updateLaptops(LaptopsDto laptopDto, int productId) {
		Optional<Laptops> findById = laptopRepo.findById(productId);
		Laptops laptop = findById.get();
		ProductsServiceImpl productsServ=new ProductsServiceImpl();
		String brandName = laptopDto.getBrandName();
		String os = laptopDto.getOs();
		String ram = laptopDto.getRam();
		String displaySize = laptopDto.getDisplaySize();
		String processor = laptopDto.getProcessor();
		String touchScreen = laptopDto.getTouchScreen();
		int price = laptopDto.getPrice();
		laptop.setBrandName(brandName);
		laptop.setOs(os);
		laptop.setProcessor(processor);
		laptop.setRam(ram);
		laptop.setDisplaySize(displaySize);
		laptop.setTouchScreen(touchScreen);
		laptop.setPrice(price);
		Laptops save = laptopRepo.save(laptop);
		if(save!=null)
		{
			return productsServ.productsResponse("ok","Laptops Details are Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	    	 
		}
		else
		{
			return productsServ.productsResponse("Not ok","Laptops Details are NOT Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	    	  
		}
		
	}

	@Override
	public JSONObject delateLaptops(int id) {
		
		ProductsServiceImpl productsServ=new ProductsServiceImpl();
		laptopRepo.deleteById(id);
		return productsServ.productsResponse("ok","Laptops Details are Getting Deleted Succesfully" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
  	  
	}

}
