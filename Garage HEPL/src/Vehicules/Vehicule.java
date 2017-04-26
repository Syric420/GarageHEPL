/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicules;

import authenticate.*;

/**
 *
 * @author tibha
 */
public abstract class Vehicule  implements Identifiable
{
    private String immatriculation;
    static String caracteresValides="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789- ";
    public Vehicule()
    {
        immatriculation="NULL";
    }
    public Vehicule(String immat)
    {
        if(isValid(immat))
            immatriculation=immat;
    }
    
    public boolean isValid(String s)
    {
        int i,j;
        if(s.length()>5 && s.length()<13)
        for (i = 0 ; i < s.length() ;i++)
        {
            for (j = 0 ; j < getCaracteresValides().length()-1 ;j++)
            {
                if(s.charAt(i)==getCaracteresValides().charAt(j))
                {
                    break;
                }
            }
            if(s.charAt(i)!=getCaracteresValides().charAt(j))
            {
                return false;
            }
        }
        else
            return false;
        return true;
    }
    
    @Override
    public String getID() {
      return immatriculation;
    }

    @Override
    public void setID(String i) {
        this.immatriculation = i;
    }

    /**
     * @return the caracteresValides
     */
    public String getCaracteresValides() {
        return caracteresValides;
    }

}
