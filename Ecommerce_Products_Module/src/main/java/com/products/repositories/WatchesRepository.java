package com.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.model.Watches;

public interface WatchesRepository extends JpaRepository<Watches, Integer> {

}
