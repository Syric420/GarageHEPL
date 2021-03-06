/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activites;
import Gui.InterfaceApplication;
import Vehicules.Voiture;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import people.*;
/**
 *
 * @author tibha
 */
public abstract class Travail implements Serializable {
    protected Mecanicien mecanicien;
    protected Voiture voiture;
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
     * @return the voiture
     */
    public Voiture getVoiture() {
        return voiture;
    }

    /**
     * @param voiture the voiture to set
     */
    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
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
        return voiture.toString() + travail;
    }
    public Vector AfficheJTable()
    {
        Vector v = new Vector();
        v.add(voiture.getType().getMarque());
        v.add(voiture.getID());
        v.add(voiture.getProprietaire());
        v.add(getTravail());
        v.add(getRemarque());
        return v;
    }
    public static Vector chargerVec(int mode)
    {    
        Vector<Travail> VecTrav= new Vector<Travail>();
        Reparation uneReparation = new Reparation();
        Entretien unEntretien = new Entretien();
        int type=0;
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier;
        if(mode==1)
            cheminFichier = user+separator+"Serialize"+separator+"TravauxEnCours.data";
        else
            cheminFichier = user+separator+"Serialize"+separator+"TravauxTermine.data";
        try
        {
            FileInputStream fis = new FileInputStream(cheminFichier);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            while(ois.available() >0)
           {
               type = ois.readInt();
                if(type == 1)
                {
                    uneReparation = (Reparation)ois.readObject();
                    //System.out.println("Reparation ajoutée");
                    VecTrav.add(uneReparation);
                }
                    
                else if(type == 2)
                {
                    unEntretien = (Entretien)ois.readObject();
                    //System.out.println("Entretien ajouté");
                    VecTrav.add(unEntretien);
                }
                else
                    System.out.println("Type incorrect");
            }
            fis.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Erreur FileNotFoundException :"+e);
        }
        catch (IOException e)
        {
            System.out.println("Erreur IOException : "+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Erreur ClassNotFoundException : "+e);
        }
        return VecTrav;
    }
    
    public static void enregistrerVec(Vector list, int mode)
    {
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier;
        
        if(mode==1)
            cheminFichier = user+separator+"Serialize"+separator+"TravauxEnCours.data";
        else
            cheminFichier = user+separator+"Serialize"+separator+"TravauxTermine.data";
        
        try
        {
           FileOutputStream fos=new FileOutputStream(cheminFichier);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           
           int taille=list.size();
           for(int i =0;i<taille;i++)
           {
               if(list.get(i).getClass().getName().equals("Activites.Entretien"))
               {
                    oos.writeInt(2);
                    oos.writeObject(list.get(i));
                    oos.flush();
               }     
               else
               {
                   oos.writeInt(1);
                   oos.writeObject(list.get(i));
                   oos.flush();
               }
           }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Erreur FileNotFoundException : "+e);
        }
        catch (IOException e)
        {
            System.out.println("Erreur IOException : "+e);
        }
        
        
    }
    public static void enregistrerLL(LinkedList list)
    {
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier = user+separator+"Serialize"+separator+"Travaux.data";
        
        try
        {
           FileOutputStream fos=new FileOutputStream(cheminFichier);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           
           int taille=list.size();
           for(int i =0;i<taille;i++)
           {
               if(list.get(i).getClass().getName().equals("Activites.Entretien"))
               {
                       oos.writeInt(2);
                        oos.writeObject(list.get(i));
                        oos.flush();
               }     
               else
               {
                   oos.writeInt(1);
                   oos.writeObject(list.get(i));
                   oos.flush();
               }
           }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Erreur FileNotFoundException : "+e);
        }
        catch (IOException e)
        {
            System.out.println("Erreur IOException : "+e);
        }
        
        
    }
    public static LinkedList chargerLL()
    {    
        LinkedList<Travail> VecTrav= new LinkedList<Travail>();
        Reparation uneReparation = new Reparation();
        Entretien unEntretien = new Entretien();
        int type=0;
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier = user+separator+"Serialize"+separator+"Travaux.data";
        try
        {
            //System.out.println("cc");
            FileInputStream fis = new FileInputStream(cheminFichier);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //System.out.println(ois.available());
            
           //System.out.println("type" + type);
           while(ois.available() >0)
           {
               type = ois.readInt();
                if(type == 1)
                {
                    uneReparation = (Reparation)ois.readObject();
                    //System.out.println("Reparation ajoutée");
                    VecTrav.add(uneReparation);
                }
                    
                else if(type == 2)
                {
                    unEntretien = (Entretien)ois.readObject();
                    //System.out.println("Entretien ajouté");
                    VecTrav.add(unEntretien);
                }
                else
                    System.out.println("Type incorrect");
            }
            fis.close();
        }
       catch (FileNotFoundException e)
        {
            System.out.println("Erreur FileNotFoundException : "+e);
        }
        catch (IOException e)
        {
            System.out.println("Erreur IOException : "+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Erreur ClassNotFoundException : "+e);
        }
        return VecTrav;
    }
    
    
    
}