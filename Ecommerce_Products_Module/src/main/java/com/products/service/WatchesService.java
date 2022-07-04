package com.products.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.products.Dto.WatchesDto;
import com.products.model.Watches;



public interface WatchesService {
	List<Watches> getAllWatches();

	JSONObject saveWatches(Watches watches);

	JSONObject updateWatch(WatchesDto watchDto, int productId);

	JSONObject delateWatch(int id);

}
