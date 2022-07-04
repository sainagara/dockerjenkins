package com.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.model.Tv;

public interface TvRepository extends JpaRepository<Tv, Integer> {

}
