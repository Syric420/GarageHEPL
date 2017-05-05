package Activites;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tibha
 */
public class Entretien extends Travail
{
    public static void enregistrer(ObjectOutputStream oos,Entretien T)
    {
        try
        {
            oos.write(2);
            oos.writeObject(T);
            oos.flush();

        }
        catch (FileNotFoundException e)
        {
            System.err.println("Erreur ! Fichier non trouvé [" + e + "]");
        }
        catch (IOException e)
        {
            System.err.println("Erreur ! ? [" + e + "]");
        }
    }
}
