/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import authenticate.AValider;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Vince
 */
public abstract class Personne implements Serializable, AValider
{
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected String numTel;
    protected String login;
    
    public Personne()
    {
        this.nom="NULL";
        this.prenom="NULL";
        this.adresse="NULL";
        this.numTel="NULL";
        this.login="NULL";
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

    /**
     * @return the login
     */
    public abstract String getLogin();
    
    public abstract boolean isMember();

    /**
     * @param login the login to set
     */
    public abstract void setLogin(String login);
    
    @Override
    public boolean isValid()
    {
        return false;
    }
    
    @Override
    public boolean validate(String mdp)
    {
        return false;
    }
    
}
