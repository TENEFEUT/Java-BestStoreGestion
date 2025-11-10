package com.boostmytool.beststore.controllers;

import java.nio.file.Files;
import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boostmytool.beststore.models.ProduitDto;
import com.boostmytool.beststore.models.Produits;
import com.boostmytool.beststore.services.ProduitsRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/produits")
public class ProduitsController {
	
	@Autowired
	private ProduitsRepository repo;

	@GetMapping({"","/"})
	public String afficheListeProduits(Model model) {
		List<Produits> produits=repo.findAll(Sort.by(Sort.Direction.DESC,"id"));
		model.addAttribute("produits",produits);
		return "produits/index";
	}
	
	
	@GetMapping("/create")
	public String affichePageCreation(Model model) {
		ProduitDto produitDto =  new ProduitDto();
		model.addAttribute("produitDto", produitDto);
		return "produits/CreateProduit";
	}
	
	@PostMapping("/create")
	public String createProduit(@Valid @ModelAttribute 
			ProduitDto produitDto, BindingResult result) 
	{
		
		if(produitDto.getFichierImage().isEmpty()) {
			result.addError(new FieldError("produitDto","fichierImage","choisissez une image"));
		}
		
		if(result.hasErrors()) {
			return "produits/CreateProduit";
		}
		
		// Sauvegarde du fichier Image
		MultipartFile image = produitDto.getFichierImage();
		Date createdAt = new Date();
		String enregistrerFichier = createdAt.getTime()+"_"+image.getOriginalFilename();
		
		try {
			String fichierImage = "public/images/";
			Path sauvegardefichier = Paths.get(fichierImage);
			if(!Files.exists(sauvegardefichier)) {
				Files.createDirectories(sauvegardefichier);
			}
			try(InputStream inputStream = image.getInputStream()){
				Files.copy(inputStream, Paths.get(fichierImage + enregistrerFichier),
				StandardCopyOption.REPLACE_EXISTING);
			}
		}catch(Exception ex) {
			System.out.println("Exception: "+ex.getMessage());
		}
		
		
		Produits produits=new Produits();
		produits.setNom(produitDto.getNom());
		produits.setMarque(produitDto.getMarque());
		produits.setCategorie(produitDto.getCategorie());
		produits.setPrix(produitDto.getPrix());
		produits.setDescription(produitDto.getDescription());
		produits.setCreatedAt(createdAt);
		produits.setNomFichierImage(enregistrerFichier);
		
		repo.save(produits);
		
		return "redirect:/produits";
		
	}
	
	@GetMapping("/modifier")
	public String pageModificationProduit(Model model,
			@RequestParam int id) {
		
		try {
			Produits produits =  repo.findById(id).get();
			model.addAttribute("produits", produits);
			
			ProduitDto produitDto=new ProduitDto();
			produitDto.setNom(produits.getNom());
			produitDto.setMarque(produits.getMarque());
			produitDto.setCategorie(produits.getCategorie());
			produitDto.setPrix(produits.getPrix());
			produitDto.setDescription(produits.getDescription());
			
			model.addAttribute("produitDto", produitDto);
			
		}
		catch(Exception ex) {
			System.out.println("Exception: "+ ex.getMessage());
			return "redirect:/produits";
		}
		
		return "produits/ModifierProduit";
	}
	
	@PostMapping("/modifier")
	public String modifierProduit(
			Model model,
			@RequestParam int id,
			@Valid @ModelAttribute ProduitDto produitDto,
			BindingResult result
			) {
		try {
			Produits produits=repo.findById(id).get();
			model.addAttribute("produits",produits);
			
			if(result.hasErrors()) {
				return "produits/ModifierProduit";
			}
			
			if(!produitDto.getFichierImage().isEmpty()) {
				//On supprime l'ancienne image
				String enregistrementimage="public/images/";
				Path ancienneImage=Paths.get(enregistrementimage + produits.getNomFichierImage());
				
				try {
					Files.delete(ancienneImage);
				}
				catch(Exception ex) {
					System.out.println("Exception: " + ex.getMessage());
				}
				
				// Sauvegarde de la nouvelle image
				MultipartFile image = produitDto.getFichierImage();
				Date newDate=new Date();
				String sauvegardeImage = newDate.getTime()+"_"+image.getOriginalFilename();
				
				try(InputStream inputStream = image.getInputStream()){
					Files.copy(inputStream, Paths.get(enregistrementimage + sauvegardeImage),
							StandardCopyOption.REPLACE_EXISTING);
				}
				
				produits.setNomFichierImage(sauvegardeImage);
				
			}
			
			produits.setNom(produitDto.getNom());
			produits.setMarque(produitDto.getMarque());
			produits.setCategorie(produitDto.getCategorie());
			produits.setPrix(produitDto.getPrix());
			produits.setDescription(produitDto.getDescription());
			
			repo.save(produits);
			
		}
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return "redirect:/produits";
	}
	
	@GetMapping("/supprimer")
	public String supprimerProduit(@RequestParam int id) {
		
		try {
			Produits produits=repo.findById(id).get();
			
			//Suppression de l'image du produit
			Path image=Paths.get("public/images/" + produits.getNomFichierImage());
			try {
				Files.delete(image);
			}catch(Exception ex) {
				System.out.println("Exception: " + ex.getMessage());
			}
			
			//Suppresion du produit dans la base de donnée
			repo.delete(produits);
			
		}catch(Exception ex) {
			
			System.out.println("Exception: " + ex.getMessage());
		}
		
		return "redirect:/produits";
	}
	
	
}
