/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicules;

import java.io.Serializable;

/**
 *
 * @author tibha
 */
public class TypeVoiture implements Serializable
{
    private String marque;
    private String type;
    private String portes;
    
    public TypeVoiture()
    {
        marque="NULL";
        type="NULL";
        portes="NULL";
    }
    public TypeVoiture(TypeVoiture voit)throws MissingTradeMarkException
    {
        if(voit.marque == "NULL")
             throw new MissingTradeMarkException("Marque NULL");
        else setMarque(voit.marque);
        setType(voit.type);
        setPortes(voit.portes);
    }
    public TypeVoiture(String mar,String ty,String po)throws MissingTradeMarkException
    {
        if(mar == "NULL")
             throw new MissingTradeMarkException("Marque NULL");
        else setMarque(mar);
        setType(ty);
        setPortes(po);
    }
    public String getMarque() {
        return marque;
    }

    /**
     * @param marque the marque to set
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the portes
     */
    public String getPortes() {
        return portes;
    }

    /**
     * @param portes the portes to set
     */
    public void setPortes(String portes) {
        this.portes = portes;
    }    
    
    @Override
    public String toString()
    {
        return getMarque() + " ";
    }
    
    public void affiche()
    {
        System.out.println(this);
    }
}
