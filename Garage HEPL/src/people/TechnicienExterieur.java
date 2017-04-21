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
public class TechnicienExterieur extends Personne implements Identifiable
{
    private String matricule;
    
    public TechnicienExterieur()
    {
        super();
        this.matricule="NULL";
    }
    
    public TechnicienExterieur(String n, String p, String a, String num, String mat)
    {
        super(n, p, a, num);
        this.matricule=mat;
    }
    
    @Override
    public String getID() {
        return matricule;
    }

    @Override
    public void setID(String i) {
        this.matricule = i;
    }
}
