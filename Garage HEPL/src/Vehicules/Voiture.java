/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicules;
/**
 *
 * @author tibha
 */
public class Voiture extends Vehicule
{ 
    private String proprietaire;
    private TypeVoiture type;
    public Voiture()
    {
        super();
        proprietaire="NULL";
        type = new TypeVoiture();
    }
    public Voiture(String mat,String prop,String marque,String typ,String porte)
    {
        super(mat);
        setProprietaire(prop);
        try
        {
            type=new TypeVoiture(marque,typ,porte);
        }
        catch(MissingTradeMarkException e){ System.out.println("Erreur : " + e.getMessage());}
    }
    
    public Voiture(String mat,String prop,TypeVoiture voit)
    {
        super(mat);
        setProprietaire(prop);
        try
        {
            type=new TypeVoiture(voit);
        }
        catch(MissingTradeMarkException e){ System.out.println("Erreur : " + e.getMessage());}
    }
    
    
    /**
     * @return the proprietaire
     */
    public String getProprietaire() {
        return proprietaire;
    }

    /**
     * @param proprietaire the proprietaire to set
     */
    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    /**
     * @return the type
     */
    public TypeVoiture getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TypeVoiture type) {
        this.type = type;
    }

    @Override
    public boolean isValid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString()
    {
        return "Immatriculation: "+this.getID()+ "\nProprietaire: \n"+this.getProprietaire() +"\n" + this.getType().toString()+"\n";
    }
    
    public void affiche()
    {
        System.out.println(this);
    }
    
}
