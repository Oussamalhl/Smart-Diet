/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Moez
 */
public class Produit {
    private int codeProduit ;
    private String nom;
    private String description ;
    private int quantite ;
    private float prix;
    private String statut;
    private String categorie;

    public Produit() {
    }

    public Produit(String nom, String description, int quantite, float prix, String statut, String categorie) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.statut = statut;
        this.categorie = categorie;
    }

    public Produit(int codeProduit, String nom, String description, int quantite, float prix, String statut, String categorie) {
        this.codeProduit = codeProduit;
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.statut = statut;
        this.categorie = categorie;
    }

    public Produit(int codeProduit, String nom, String description, int quantite, float prix, String statut) {
        this.codeProduit = codeProduit;
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.statut = statut;
    }

    public Produit(String nom, String description, int quantite, float prix, String statut) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.statut = statut;
        
    }
    

   

    public Produit(int codeProduit, String nom, String description, int quantite, float prix, String statut, int id_categories) {
        this.codeProduit = codeProduit;
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.statut = statut;
        
    }

    public int getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(int codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit{" + "codeProduit=" + codeProduit + ", nom=" + nom + ", description=" + description + ", quantit\u00e9=" + quantite + ", prix=" + prix + ", statut=" + statut + '}';
    }

   
  
   

    

    

    

    
}
