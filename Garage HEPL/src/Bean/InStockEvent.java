/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.EventObject;

/**
 *
 * @author Vince
 */
public class InStockEvent extends EventObject {
    private String Libelle;
    
    public InStockEvent(Object o, String lib) {
        super(o);
        setLibelle(lib);
    }

    /**
     * @return the Libelle
     */
    public String getLibelle() {
        return Libelle;
    }

    /**
     * @param Libelle the Libelle to set
     */
    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }

    
}
