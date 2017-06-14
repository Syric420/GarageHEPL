/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Gui.InterfaceCentrale;
import java.beans.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.NetworkBasicServer;

/**
 *
 * @author Vince
 */
public class ReicivingBean {
    NetworkBasicServer server;
    protected PropertyChangeSupport GestProp = new PropertyChangeSupport(this);
    private String Commande;
    private InterfaceCentrale Ic;

    public ReicivingBean() {
        Commande = null;
        
    }

    public ReicivingBean(String Commande) {
        this.Commande = Commande;
    }
    
    
    public void setServer(int port,javax.swing.JCheckBox cb)
    {
        server = new NetworkBasicServer(port,cb);//besoin d'une methode pour acceder a l interface centrale
        
    }
    
    public void run()
    {
        //setCommande("Salut");//Juste pour test
        String message;
        message = server.getMessage();
        while(true)
        {
            //message recu
            if(!message.equalsIgnoreCase("RIEN"))
            {
                //send event
                Ic.LireMessage(message);
                setCommande(message);
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ReicivingBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            //message = server.getMessage();
            
        }
        
        
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
    
}
