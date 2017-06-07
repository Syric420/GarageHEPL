/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import authenticate.AValider;
import java.io.*;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String TempLog[],TempPwd[];
        String cheminFichier = user+separator+"src"+separator+"Gui"+separator+"users.properties";
        Properties propLogin = new Properties();
        try
        {
            propLogin.load (new FileInputStream (cheminFichier));
            
        }
        catch (FileNotFoundException e) { System.out.println("Fichier de propriétés non trouvé !"); }
        catch (IOException e) { System.out.println("Erreur : " + e.getMessage()); }
        TempLog=propLogin.getProperty("Id").split(",");
        TempPwd=propLogin.getProperty("Psw").split(",");
        
        for(int i=0; i<TempLog.length;i++)
        {
            if(TempLog[i].equals(login))
            {
                if(TempPwd[i].equals(mdp))
                    return true;
            }
        }
        return false;
    }
    
    
    public static void enregistrerVector(Vector vecUtilisateurs)
    {//Enregistre le vecteur de Personne
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier = user+separator+"Serialize"+separator+"Utilisateurs.data";
        
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
        
            fos = new FileOutputStream(cheminFichier);
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(vecUtilisateurs);
        } catch (FileNotFoundException ex) {
            System.out.println("Erreur FileNotFoundException : "+ex);
        } catch (IOException ex) {
            System.out.println("Erreur IOException : "+ex);
        }
    }
    
    public static Vector chargerVector()
    {
        //Charge le vecteur de Personne
        Vector vecPersonne = new Vector();
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier = user+separator+"Serialize"+separator+"Utilisateurs.data";
        
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(cheminFichier);
            ois = new ObjectInputStream(fis);
            vecPersonne = (Vector)ois.readObject();
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Erreur FileNotFoundException : "+ex);
            return null;
        } catch (IOException ex) {
            System.out.println("Erreur IOException : "+ex);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Erreur ClassNotFoundException : "+ex);
            return null;
        }
        return vecPersonne;
    }
}
