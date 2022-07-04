package com.products.service;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.Dto.TvDto;
import com.products.model.Tv;
import com.products.repositories.TvRepository;

@Service
public class TvServiceImpl implements TvService {
	@Autowired
	private TvRepository tvRepo;
	@Autowired
	private ProductsService productsServ;
	@Override
	public List<Tv> getAllTvs() {
		 return tvRepo.findAll();
			
	}

	@Override
	public JSONObject saveTvs(Tv tv) {
		Tv save = tvRepo.save(tv);
		ProductsServiceImpl productsServ=new ProductsServiceImpl();
		if(save!=null)
		{
			return productsServ.productsResponse("ok","Tv Details are Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	    	  
		}
		else
		{
			return productsServ.productsResponse("Not ok","Tv Details are NOT Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	    	  
		}
	}

	@Override
	public JSONObject updateTvs(TvDto tvDto, int productId) {
		Optional<Tv> findById = tvRepo.findById(productId);
		Tv tv = findById.get();
		ProductsServiceImpl productsServ=new ProductsServiceImpl();
		String brandName = tvDto.getBrandName();
		String type = tvDto.getType();
		String displaySize = tvDto.getDisplaySize();
		String displayType = tvDto.getDisplayType();
		int price = tvDto.getPrice();
		tv.setBrandName(brandName);
		tv.setType(type);
		tv.setDisplaySize(displaySize);
		tv.setDisplayType(displayType);
		tv.setPrice(price);
		Tv save = tvRepo.save(tv);
		if(save!=null)
		{
			return productsServ.productsResponse("ok","Tv Details are Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	    	  
		}
		else
		{
			return productsServ.productsResponse("Not ok","Tv Details are NOT Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	    	  
		}
		
	}

	@Override
	public JSONObject delateTvs(int id) {
		
		ProductsServiceImpl productsServ=new ProductsServiceImpl();
		tvRepo.deleteById(id);
		return productsServ.productsResponse("ok","Tv recdord getting deleted" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
  	  
	}

}
