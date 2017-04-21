/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;
import authenticate.*;
/**
 *
 * @author Vince
 */
public abstract class PersonnelGarage extends Personne implements Identifiable, AValider
{
    private String matricule;
    
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
    public boolean validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
