package com.boostmytool.beststore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boostmytool.beststore.models.Produits;
import com.boostmytool.beststore.services.ProduitsRepository;

@Controller
@RequestMapping("/produits")
public class ProduitsController {
	
	@Autowired
	private ProduitsRepository repo;

	@GetMapping({"","/"})
	public String afficheListeProduits(Model model) {
		List<Produits> produits=repo.findAll();
		model.addAttribute("produits",produits);
		return "produits/index";
	}
}
