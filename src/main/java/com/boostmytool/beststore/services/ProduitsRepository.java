package com.boostmytool.beststore.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boostmytool.beststore.models.Produits;

public interface ProduitsRepository extends JpaRepository<Produits, Integer> {

}
