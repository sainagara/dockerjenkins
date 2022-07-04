package com.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.model.Laptops;

public interface LaptopsRepository extends JpaRepository<Laptops, Integer> {

}
