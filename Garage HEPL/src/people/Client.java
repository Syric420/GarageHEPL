/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import authenticate.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Vince
 */
public class Client extends Personne implements Identifiable, Serializable
{
    private String numClient;
    
    public Client()
    {
        super();
        this.numClient="NULL";
    }
    
    public Client(String numCli, String n, String p, String a, String num)
    {
        super(n,p,a,num);
        this.numClient=numCli;
    }

    @Override
    public String getID() {
        return numClient;
    }

    @Override
    public void setID(String i) {
        this.numClient = i;
    }
    
    @Override
    public String toString()
    {
        return this.getNom()+" "+this.getPrenom();
    }

    @Override
    public String getLogin() {
        return this.login;
    }

    @Override
    public void setLogin(String login) {
        this.login=login;
    }

    @Override
    public boolean isMember() {
        return false;
    }
    
    public static void enregistrerVector(Vector vecClients)
    {//Enregistre le vecteur de Personne
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier = user+separator+"Serialize"+separator+"Clients.data";
        
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
        
            fos = new FileOutputStream(cheminFichier);
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(vecClients);
        } catch (FileNotFoundException ex) {
            System.out.println("Erreur FileNotFoundException : "+ex);
        } catch (IOException ex) {
            System.out.println("Erreur IOException : "+ex);
        }
    }
    
    public static Vector chargerVector()
    {
        //Charge le vecteur de Personne
        Vector vecClients = new Vector();
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier = user+separator+"Serialize"+separator+"Clients.data";
        
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(cheminFichier);
            ois = new ObjectInputStream(fis);
            vecClients = (Vector)ois.readObject();
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Erreur FileNotFoundException : "+ex);
            return null;
        } catch (IOException ex) {
            System.out.println("Erreur IOException : "+ex);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Erreur ClassNotFoundException : "+ex);
            return null;
        }
        return vecClients;
    }
}
