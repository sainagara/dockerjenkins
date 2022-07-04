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

import com.products.Dto.WatchesDto;
import com.products.model.Watches;
import com.products.service.WatchesService;


@RestController
@RequestMapping("/products/watches")
public class WatchesRestController {
	@Autowired
	private WatchesService watchesService;
	
	@GetMapping(value="/getAllWatches")
	public List<Watches> getAllWatches()
	{
		 return watchesService.getAllWatches();
		
	}
	@PostMapping(value="/saveWatches")
	public JSONObject saveWatches(@RequestBody Watches watches) 
	{
		return watchesService.saveWatches(watches);
		
	
	}
	@PutMapping(value="/updateWatches/{productId}")
	public JSONObject updateWatch(@RequestBody WatchesDto watchDto,@PathVariable int productId)
	{
		return watchesService.updateWatch(watchDto, productId);
	    
	}
	@DeleteMapping(value="/deleteWatches/{id}")
	public JSONObject delateWatch(@PathVariable int id)
	{
		return watchesService.delateWatch(id);
	}

}
