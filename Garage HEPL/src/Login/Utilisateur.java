/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
import authenticate.AValider;

/**
 *
 * @author Vince
 */
public class Utilisateur implements AValider {
    private String login;
    private String password;
    static String caracteresValides="abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789._";
    
    public Utilisateur()
    {
        login="NULL";
        password="NULL";
    }
    
    public Utilisateur(String n, String m)
    {
        
        login=n;
        password=m;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isValid() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int i,j;
        //Test si le login a les bons caractères
        for(i=0; i<login.length()-1; i++)
        {
            for(j=0; j<caracteresValides.length()-1; j++)
            {
                if(login.charAt(i)==caracteresValides.charAt(j))
                    break;
            }
            if(login.charAt(i)!=caracteresValides.charAt(j))
                return false;
        }
        //Test si le mdp a les bons caractères
        for(i=0; i<password.length()-1; i++)
        {
            for(j=0; j<caracteresValides.length()-1; j++)
            {
                if(password.charAt(i)==caracteresValides.charAt(j))
                    break;
            }
            if(password.charAt(i)!=caracteresValides.charAt(j))
                return false;
        }
        return true;
    }

    @Override
    public boolean validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
