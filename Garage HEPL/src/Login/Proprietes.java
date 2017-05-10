/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
import java.util.*;
import java.io.*;
/**
 *
 * @author tibha_000
 */
public class Proprietes {
    public void main(String args[])
    {
        String user = System.getProperty("user.home");
        String separator = System.getProperty("file.separator");
        String TempLog[],TempPwd[];
        String cheminFichier = user+separator+"Dropbox"+separator+"java"+separator+"LibLogin"+separator+"src"+separator+"login"+separator+"Properties.properties";
        Properties propLogin = new Properties();
        try
        {
            //propLogin.load (new FileInputStream ("C:\\Users\\tibha_000\\Dropbox\\java\\LibLogin\\src\\login\\Properties.properties"));
            propLogin.load (new FileInputStream (cheminFichier));
            //propLogin.load (new FileInputStream ("C:\\Users\\Vince\\Dropbox\\java\\LibLogin\\src\\login\\Properties.properties"));
            
        }
        catch (FileNotFoundException e) { System.out.println("Fichier de propriétés non trouvé !"); }
        catch (IOException e) { System.out.println("Erreur : " + e.getMessage()); }
        TempLog=propLogin.getProperty("Login").split(",");
        TempPwd=propLogin.getProperty("Password").split(",");
        for(int i=0;i<TempLog.length;i++)
        {
                //hash.put(TempLog[i],TempPwd[i]);
        }
    }
}
