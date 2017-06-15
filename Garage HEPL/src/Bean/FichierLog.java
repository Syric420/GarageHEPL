/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.*;
import java.util.*;

/**
 *
 * @author Vince
 */
public class FichierLog implements Serializable {
    private String nomFichier;
    
    public FichierLog()
    {
        nomFichier=null;
    }
    
    public void ecritLigne(String ligne)
    {
        try
        {
            FileWriter f = new FileWriter(nomFichier, true);//True pour append
            BufferedWriter bf = new BufferedWriter(f);
            bf.write("["+new Date() + "] " + ligne);
            bf.newLine();
            bf.close();
        }
        catch (IOException e)
        {
            System.out.println("Erreur IOException: "+e.getMessage());
        }
    }

    /**
     * @return the nomFichier
     */
    public String getNomFichier() 
    {
        return nomFichier;
    }

    /**
     * @param nomFichier the nomFichier to set
     */
    public void setNomFichier(String nomFichier) 
    {
        this.nomFichier = nomFichier;
    }
}
