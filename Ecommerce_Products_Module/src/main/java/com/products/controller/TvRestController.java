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

import com.products.Dto.TvDto;
import com.products.model.Tv;
import com.products.service.TvService;

@RestController
@RequestMapping("/products/tvs")
public class TvRestController {
	@Autowired
	private TvService tvService;
	@GetMapping(value="/getTvs")
	public List<Tv> getAllTvs()
	{
		 return tvService.getAllTvs();
		 
	}
	@PostMapping(value="/saveTvs")
	public JSONObject saveTvs(@RequestBody Tv tv) {
		return tvService.saveTvs(tv);
		
		
	}
	@PutMapping(value="/updateTvs/{productId}")
	public JSONObject updateTvs(@RequestBody TvDto tvDto,@PathVariable int productId)
	{
		return tvService.updateTvs(tvDto, productId);
		
		
	}
	@DeleteMapping(value="/deleteTvs/{id}")
	public JSONObject delateTvs(@PathVariable int id)
	{
		return tvService.delateTvs(id);
		
	}

}
