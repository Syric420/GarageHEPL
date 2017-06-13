/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.beans.*;

/**
 *
 * @author Vince
 */
public class ReicivingBean {
    
    protected PropertyChangeSupport GestProp = new PropertyChangeSupport(this);
    private String Commande;

    public ReicivingBean() {
        Commande = null;
    }

    public ReicivingBean(String Commande) {
        this.Commande = Commande;
    }
    
    
    
    public void run()
    {
        setCommande("Salut");//Juste pour test
    }
    
    
    public void addPropertyChangeListener(PropertyChangeListener l)
    {
        GestProp.addPropertyChangeListener(l);
    }
    public void removePropertyChangeListener(PropertyChangeListener l)
    {
        GestProp.removePropertyChangeListener(l);
    }

    /**
     * @return the Commande
     */
    public String getCommande() {
        return Commande;
    }

    /**
     * @param Commande the Commande to set
     */
    public void setCommande(String Commande) {
        String ancienneCommande = this.Commande;
        this.Commande = Commande;
        GestProp.firePropertyChange("Commande", ancienneCommande, this.Commande);
    }
    
}
