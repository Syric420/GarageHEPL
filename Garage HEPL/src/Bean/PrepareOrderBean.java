/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.*;

/**
 *
 * @author Vince
 */
public class PrepareOrderBean implements SearchFoundListener {

    private String message;
    Vector vecBeanAalerter;
    public PrepareOrderBean()
    {
        vecBeanAalerter = new Vector();
        
    }
    @Override
    public void SearchFoundDetected(SearchFoundEvent e) {
        Calendar c = Calendar.getInstance();
        Random randomGenerator = new Random();
        int D=randomGenerator.nextInt(10);
        System.out.println("Date calendrier = " + c.getTime());
        c.add(Calendar.DAY_OF_MONTH, D);
        if(e.isSucces())
            setMessage("OK!" + e.getLibelle() + "Livraison prevue le: " + c);
        else
            setMessage("NOT OK!" + e.getLibelle() + "Livraison prevue le: " + c);
        notifyEvent(); 
    }
    
    
    
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
        
    public void notifyEvent()
    {
        InStockEvent e = new InStockEvent(this, getMessage());
        
        int n = vecBeanAalerter.size();
        for (int i=0; i<n; i++)
        // activation de la methode AlertDetected pour chaque objet à l'ecoute
        {
            InStockListener obj = (InStockListener) vecBeanAalerter.elementAt(i);
            obj.InStockEventDetected(e);
        }
    }
    
    public void addBeanAalerter(InStockListener al)
    {
        if (!vecBeanAalerter.contains(al))
        {
            vecBeanAalerter.addElement(al);
        }
    }
    
    public void removeBeanAalerter(InStockListener al)
    {
        if (!vecBeanAalerter.contains(al))
        {
            vecBeanAalerter.removeElement(al);
        }
    }
}
