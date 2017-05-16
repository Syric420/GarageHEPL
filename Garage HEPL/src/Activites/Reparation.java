/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activites;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author tibha
 */
public class Reparation extends Travail
{
    public static void enregistrer(ObjectOutputStream oos,Reparation T)
{
    try
    {
        oos.writeInt(1);
        oos.writeObject(T);
        oos.flush();

    }
    catch (FileNotFoundException e)
    {
        System.err.println("Erreur ! Fichier non trouvé [" + e + "]");
    }
    catch (IOException e)
    {
        System.err.println("Erreur ecriture ! ? [" + e + "]");
    }
}
    
}
