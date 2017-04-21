/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author Vince
 */
public class Personne 
{
    private String nom;
    private String prenom;
    private String adresse;
    private String numTel;
    
    public Personne()
    {
        this.nom="NULL";
        this.prenom="NULL";
        this.adresse="NULL";
        this.numTel="NULL";
    }
    
    public Personne(String n, String p, String a, String num)
    {
        this.nom= n;
        this.prenom=p;
        this.adresse=a;
        this.numTel=num;
    }
    

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the numTel
     */
    public String getNumTel() {
        return numTel;
    }

    /**
     * @param numTel the numTel to set
     */
    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
    
    
}
