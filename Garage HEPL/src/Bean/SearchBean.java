/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.beans.*;
import java.util.Vector;

/**
 *
 * @author Vince
 */
public class SearchBean implements PropertyChangeListener {
    
    private Vector vecCommandes;

    public SearchBean() {
        vecCommandes = new Vector();
    }

    
    

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        String Commande = pce.getNewValue().toString();
        System.out.println("Commande = "+ Commande);
        
        vecCommandes.add(Commande);
    }
    
}
