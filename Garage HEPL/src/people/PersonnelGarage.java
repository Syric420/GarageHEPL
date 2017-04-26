/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;
import authenticate.*;
import java.util.Hashtable;
/**
 *
 * @author Vince
 */
public abstract class PersonnelGarage extends Personne implements Identifiable, AValider
{
    private String matricule;
    private String login;
    
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

   
    //@Override
    public boolean validate(Hashtable h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       // if(h.get(login))
            
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
}
