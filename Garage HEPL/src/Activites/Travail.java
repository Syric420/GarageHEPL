/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activites;
import Vehicules.Vehicule;
import people.*;
/**
 *
 * @author tibha
 */
public abstract class Travail {
    private Mecanicien mecanicien;
    private Vehicule vehicule;

    /**
     * @return the mecanicien
     */
    public Mecanicien getMecanicien() {
        return mecanicien;
    }

    /**
     * @param mecanicien the mecanicien to set
     */
    public void setMecanicien(Mecanicien mecanicien) {
        this.mecanicien = mecanicien;
    }

    /**
     * @return the vehicule
     */
    public Vehicule getVehicule() {
        return vehicule;
    }

    /**
     * @param vehicule the vehicule to set
     */
    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
    
    
}
