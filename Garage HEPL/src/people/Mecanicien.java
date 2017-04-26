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
public class Mecanicien extends PersonnelGarage {
    private String specialite;
    
    public Mecanicien()
    {
        super();
        this.specialite = "NULL";
    }

    public Mecanicien(String nom, String prenom, String adresse, String numTel, String mat, String spe)
    {
        super(nom, prenom, adresse, numTel, mat);
        this.specialite = spe;
    }
    /**
     * @return the specialite
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * @param specialite the specialite to set
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public boolean validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
