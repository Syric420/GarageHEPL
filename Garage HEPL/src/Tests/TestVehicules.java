/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;
import Vehicules.*;
import java.util.Scanner;
import java.util.Vector;

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
            voitures[0]= new Voiture("1-XCV-699","Me Peruzzi","Suzuki","SUV","5");
            voitures[1]= new Voiture("1-ABC-354","louis","toyota","vroum vroum","5");
            voitures[2]= new Voiture("1-FGH-472","david","porsche","berline","3");
            voitures[3]= new Voiture("1-DJY-972","vincent","audi","SUV","5");
            voitures[4]= new Voiture("1-CVD-652","thibault","renault","monospace","5");
            int compt=0;
            compt = Integer.parseInt(args[0]);
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
