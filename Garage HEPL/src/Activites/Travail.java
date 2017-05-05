/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activites;
import Vehicules.Vehicule;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;
import people.*;
/**
 *
 * @author tibha
 */
public abstract class Travail {
    protected Mecanicien mecanicien;
    protected Vehicule vehicule;
    protected String travail;
    protected String remarque;
    protected String pontTravail;
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

    /**
     * @return the travail
     */
    public String getTravail() {
        return travail;
    }

    /**
     * @param travail the travail to set
     */
    public void setTravail(String travail) {
        this.travail = travail;
    }

    /**
     * @return the remarque
     */
    public String getRemarque() {
        return remarque;
    }

    /**
     * @param remarque the remarque to set
     */
    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    /**
     * @return the pontTravail
     */
    public String getPontTravail() {
        return pontTravail;
    }

    /**
     * @param pontTravail the pontTravail to set
     */
    public void setPontTravail(String pontTravail) {
        this.pontTravail = pontTravail;
    }
    @Override
    public String toString()
    {
        return vehicule.toString() + travail;
    }
    public static Vector charger()
    {    
        Vector<Travail> VecTrav= new Vector<Travail>();
        Reparation uneReparation = new Reparation();
        Entretien unEntretien = new Entretien();
        int type=0;
        //unTravail.nom="first";
        String user = System.getProperty("user.home");
        String separator = System.getProperty("file.separator");
        String cheminFichier = user+separator+"Desktop"+separator+"java"+separator+"Travaux.data";
        try
        {
            FileInputStream fis = new FileInputStream(cheminFichier);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(type != 0)
            {
                type = ois.readInt();
                if(type == 1)
                    uneReparation = (Reparation)ois.readObject();
                else if(type == 2)
                    unEntretien = (Entretien)ois.readObject();
                
                VecTrav.add(uneReparation);
            }
            fis.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Erreur ! Fichier non trouvé [" + e + "]");
        }
        catch (IOException e)
        {
            System.err.println("Erreur ! ? [" + e + "]");
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Erreur ! Classe non trouvée [" + e + "]");
        }
        return VecTrav;
    }
}
