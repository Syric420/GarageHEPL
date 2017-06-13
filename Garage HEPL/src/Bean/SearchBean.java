/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

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

    public SearchBean() {
        vecCommandes = new Vector();
        Charger();
    }

    public void Enregistrer(String s)
    {
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier = user+separator+"Serialize"+separator+"Commandes.data";
        
         try
        {
            vecCommandes.add(s);
            fos=new FileOutputStream(cheminFichier);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(vecCommandes);
            
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Erreur ! Fichier non trouvé [" + e + "]");
        }
        catch (IOException e)
        {
            System.err.println("Erreur ! ? [" + e + "]");
        }
    }
    
        public void Charger()
    {
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier = user+separator+"Serialize"+separator+"Commandes.data";
        
         try
        {
            fis=new FileInputStream(cheminFichier);
            ois = new ObjectInputStream(fis);
            vecCommandes=(Vector) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SearchBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SearchBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        String Commande = pce.getNewValue().toString();
        System.out.println("Commande = "+ Commande);
        
        Enregistrer(Commande);
    }
    
}
