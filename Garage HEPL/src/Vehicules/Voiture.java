/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicules;

import people.Client;

/**
 *
 * @author tibha
 */
public class Voiture extends Vehicule
{ 
    private Client proprietaire;
    private TypeVoiture type;
    public Voiture()
    {
        super();
        proprietaire=null;
        type = new TypeVoiture();
    }
    public Voiture(String mat,Client prop,String marque,String typ,String porte)
    {
        super(mat);
        setProprietaire(prop);
        try
        {
            type=new TypeVoiture(marque,typ,porte);
        }
        catch(MissingTradeMarkException e){ System.out.println("Erreur : " + e.getMessage());}
    }
    
    public Voiture(String mat,Client prop,TypeVoiture voit)
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
    public String toString()
    {
        return this.getProprietaire() + " " + this.getType().toString();
    }
    
    public void affiche()
    {
        System.out.println(this);
    }

    /**
     * @return the proprietaire
     */
    public Client getProprietaire() {
        return proprietaire;
    }

    /**
     * @param proprietaire the proprietaire to set
     */
    public void setProprietaire(Client proprietaire) {
        this.proprietaire = proprietaire;
    }
    
}
