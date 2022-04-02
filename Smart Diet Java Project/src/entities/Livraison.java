
package entities;

import java.sql.Date;



public class Livraison {
    private int idLivraison;
    private int idCommande;
    private int idLivreur;
    private int etatLivraison;
    private String dateLivraison;
    
    

    public Livraison() {
    }

    public Livraison(int idLivreur, int idPayment, int etatLivraison, String dateLivraison ) {
        this.idLivreur = idLivreur;
        this.idCommande= idCommande;
        this.etatLivraison = etatLivraison;
        this.dateLivraison= dateLivraison;
        
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getDateLivraison() {
        return dateLivraison;
    }

    public int getIdLivraison() {
        return idLivraison;
    }

    public int getIdLivreur() {
        return idLivreur;
    }

    

    public int getEtatLivraison() {
        return etatLivraison;
    }

    public void setIdLivraison(int idLivraison) {
        this.idLivraison = idLivraison;
    }

    public void setIdLivreur   (int idLivreur) {
        this.idLivreur = idLivreur;
    }

    

    public void setEtatLivraison(int etatLivraison) {
        this.etatLivraison = etatLivraison;
    }

    @Override
    public String toString() {
        return "Livraison: " + "idLivraison=" + idLivraison + " idLivreur=" + idLivreur + " etatLivraison=" + etatLivraison + "\n";
    }

    
    
    
    
}
