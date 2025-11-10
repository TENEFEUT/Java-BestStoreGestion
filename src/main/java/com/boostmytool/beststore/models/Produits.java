package com.boostmytool.beststore.models;


import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name="produits")
public class Produits {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String marque;
	private String categorie;
	private Double prix;
	
	@Column(columnDefinition="TEXT")
	private String description;
	private Date createdAt;
	private String nomFichierImage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getNomFichierImage() {
		return nomFichierImage;
	}
	public void setNomFichierImage(String nomFichierImage) {
		this.nomFichierImage = nomFichierImage;
	}
	

}
