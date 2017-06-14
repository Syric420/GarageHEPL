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
public class SearchFoundEvent extends EventObject {
    private String Libelle;
    private boolean succes;
    
    public SearchFoundEvent(Object o, String lib, boolean succ) {
        super(o);
        setLibelle(lib);
        setSucces(succ);
        System.out.println(lib + " "+ succ);
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

    /**
     * @return the succes
     */
    public boolean isSucces() {
        return succes;
    }

    /**
     * @param succes the succes to set
     */
    public void setSucces(boolean succes) {
        this.succes = succes;
    }
    
}
