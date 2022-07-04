package com.products.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.products.Dto.TvDto;
import com.products.model.Tv;



public interface TvService {
	List<Tv> getAllTvs();

	JSONObject saveTvs(Tv tv);

	JSONObject updateTvs(TvDto tvDto, int productId);

	JSONObject delateTvs(int id);

}
