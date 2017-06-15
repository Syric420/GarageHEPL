/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Gui.InterfaceCentrale;
import java.beans.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vince
 */
public class SearchBean implements PropertyChangeListener {
    
    private Vector vecCommandes;
    FileOutputStream fos ;
    ObjectOutputStream oos;
    FileInputStream fis ;
    ObjectInputStream ois;
    private InterfaceCentrale Ic;
    Vector vecBeanAalerter;

    public SearchBean() {
        vecCommandes = new Vector();
        vecBeanAalerter = new Vector();
    }

    public void Enregistrer(String s)
    {
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier = user+separator+"Serialize"+separator+"Commandes"+Ic.type+".data";
        
         try
        {
            vecCommandes.add(s);
            fos=new FileOutputStream(cheminFichier);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(vecCommandes);
            
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Erreur ! Fichier non trouve [" + e + "]");
        }
        catch (IOException e)
        {
            System.out.println("Erreur ! ? [" + e + "]");
        }
    }
    
        public void Charger()
    {
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier = user+separator+"Serialize"+separator+"Commandes"+Ic.type+".data";
        
         try
        {
            fis=new FileInputStream(cheminFichier);
            ois = new ObjectInputStream(fis);
            vecCommandes=(Vector) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Erreur ! ? [" + ex + "]");
        } catch (IOException ex) {
            System.out.println("Erreur ! ? [" + ex + "]");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erreur ! ? [" + ex + "]");
        }

    }
    

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        String Commande = pce.getNewValue().toString();
        System.out.println("Commande = "+ Commande);
        
        Enregistrer(Commande);
    }

    /**
     * @return the Ic
     */
    public InterfaceCentrale getIc() {
        return Ic;
    }

    /**
     * @param Ic the Ic to set
     */
    public void setIc(InterfaceCentrale Ic) {
        this.Ic = Ic;
    }
    
    public void notifyEvent(String lib, boolean succ)
    {
        SearchFoundEvent e = new SearchFoundEvent(this, lib, succ);
        
        int n = vecBeanAalerter.size();
        for (int i=0; i<n; i++)
        // activation de la methode AlertDetected pour chaque objet à l'ecoute
        {
            SearchFoundListener obj = (SearchFoundListener) vecBeanAalerter.elementAt(i);
            obj.SearchFoundDetected(e);
        }
    }
    
    public void addBeanAalerter(SearchFoundListener al)
    {
        if (!vecBeanAalerter.contains(al))
        {
            vecBeanAalerter.addElement(al);
        }
    }
    
    public void removeBeanAalerter(SearchFoundListener al)
    {
        if (!vecBeanAalerter.contains(al))
        {
            vecBeanAalerter.removeElement(al);
        }
    }
    
}
