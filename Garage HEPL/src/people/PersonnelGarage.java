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
public abstract class PersonnelGarage extends Personne implements Identifiable, AValider, Serializable
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

    @Override
    public boolean isValid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public boolean validate(String mdp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(hash.get(login).equals(mdp))
           return true;
       else
           return false;
            
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
    
    public void charger() throws FileNotFoundException, IOException 
    {
        
    }
    
    public void sauvegarder() throws FileNotFoundException, IOException
    {
        String separator = System.getProperty("file.separator");
        String user = System.getProperty("user.dir");
        String cheminFichier = user+separator+"Serialize"+separator+"PersonnelGarage.data";
        
        FileOutputStream fos=new FileOutputStream(cheminFichier);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        
        
    }
}
