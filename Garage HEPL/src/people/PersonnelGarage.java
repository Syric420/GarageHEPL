/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;
import authenticate.*;
import java.io.*;
import java.util.Hashtable;
/**
 *
 * @author Vince
 */
public abstract class PersonnelGarage extends Personne implements Identifiable, Serializable
{
    private String matricule;
    private Hashtable hash;
    
    public PersonnelGarage()
    {
        super();
        this.matricule="NULL";
    }
    
    public PersonnelGarage(String nom, String prenom, String adresse, String numTel, String matricule)
    {
        super(nom, prenom, adresse, numTel);
        this.matricule=matricule;
    }

    @Override
    public String getID() {
        return matricule;
    }

    @Override
    public void setID(String i) {
        this.matricule = i;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the hash
     */
    public Hashtable getHash() {
        return hash;
    }

    /**
     * @param hash the hash to set
     */
    public void setHash(Hashtable hash) {
        this.hash = hash;
    }
}
