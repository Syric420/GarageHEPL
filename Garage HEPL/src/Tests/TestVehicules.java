/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;
import Vehicules.*;
import java.util.Scanner;
import java.util.Vector;
import people.Client;

/**
 *
 * @author tibha
 */
public class TestVehicules {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        if(args.length==1 && Integer.parseInt(args[0])>0 && Integer.parseInt(args[0])<=5)
        {
            Vector<Voiture> VecVoit = new Vector<Voiture>();
            Voiture[] voitures= new Voiture[5];
            Client[] clients ={
                new Client("C250", "Pierre", "Jean","Adresse du pré","0478fauxnum"),
                new Client("C250", "Hollande", "Francois","Champ El","0478fauxnum"),
                new Client("C250", "Sarkozy", "Nicolas","El Champ","0478fauxnum"),
            };
            voitures[0]= new Voiture("1-XCV-699",clients[0],"Suzuki","SUV","5");
            voitures[1]= new Voiture("1-ABC-354",clients[1],"Toyota","vroum vroum","5");
            voitures[2]= new Voiture("1-FGH-472",clients[2],"Porsche","berline","3");
            voitures[3]= new Voiture("1-DJY-972",clients[2],"Audi","SUV","5");
            voitures[4]= new Voiture("1-CVD-652",clients[1],"Renault","monospace","5");
            int compt=0;
            compt = Integer.parseInt(args[0]);
            //compt=5;
            //System.out.println("Nombre inséré: "+compt);
            int i=0;
            while(compt>0)
            {
                VecVoit.add(voitures[i]);
                i++;
                compt--;
            }
            for(i=0;i<VecVoit.size();i++)
            VecVoit.elementAt(i).affiche();
        }

    }
    
}
