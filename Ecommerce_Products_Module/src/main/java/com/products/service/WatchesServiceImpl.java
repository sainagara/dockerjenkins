package com.products.service;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.Dto.WatchesDto;
import com.products.model.Watches;
import com.products.repositories.WatchesRepository;


@Service
public class WatchesServiceImpl implements WatchesService {
	@Autowired
	private WatchesRepository watchRepo;
	@Autowired
	private ProductsService productsServ;
	@Override
	public List<Watches> getAllWatches() {
		return watchRepo.findAll();
		
	}

	@Override
	public JSONObject saveWatches(Watches watches) {
		Watches save = watchRepo.save(watches);
		ProductsServiceImpl productsServ=new ProductsServiceImpl();
		if(save!=null)
		{
			return productsServ.productsResponse("ok","Watches Details are Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	    	  
		}
		else
		{
			return productsServ.productsResponse("Not ok","Watches Details are NOT Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	    	  
		}
	}

	@Override
	public JSONObject updateWatch(WatchesDto watchDto, int productId) {
		ProductsServiceImpl productsServ=new ProductsServiceImpl();
		Optional<Watches> findById = watchRepo.findById(productId);
		Watches watch = findById.get();
		String productName = watchDto.getProductName();
		String bandType = watchDto.getBandType();
		String watchType = watchDto.getWatchType();
		String waterResistant = watchDto.getWaterResistant();
		int price = watchDto.getPrice();
	    watch.setProductName(productName);
	    watch.setWatchType(watchType);
	    watch.setBandType(bandType);
	    watch.setWaterResistant(waterResistant);
	    watch.setPrice(price);
	    Watches save = watchRepo.save(watch);
	    if(save!=null)
		{
			return productsServ.productsResponse("ok","Watch Details are Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	    	  
		}
		else
		{
			return productsServ.productsResponse("Not ok","Watch Details are NOT Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	    	  
		}
		
	}

	@Override
	public JSONObject delateWatch(int id) {
		ProductsServiceImpl productsServ=new ProductsServiceImpl();
		watchRepo.deleteById(id);
		return productsServ.productsResponse("ok","Watch Details are Getting Deleted succesfully" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
  	  
		}
		

}
