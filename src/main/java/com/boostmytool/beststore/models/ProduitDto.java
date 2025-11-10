package com.boostmytool.beststore.models;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;

public class ProduitDto {
	
	@NotEmpty(message="Entrer le Nom")
	private String nom;
	
	@NotEmpty(message="Entrer la Marque")
	private String marque;
	
	@NotEmpty(message="Entrer la Catégorie")
	private String categorie;
	
	@Min(0)
	private double prix;
	
	@Size(min = 10, message = "La description du produit doit contenir au minimum 10 mots")
	@Size(max = 1000, message = "La description ne peut pas dépasser 1000 mots")
	private String description;
	
	private MultipartFile fichierImage;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getFichierImage() {
		return fichierImage;
	}

	public void setFichierImage(MultipartFile fichierImage) {
		this.fichierImage = fichierImage;
	}
	
	

}
