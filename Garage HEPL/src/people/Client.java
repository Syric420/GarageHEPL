/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import authenticate.*;

/**
 *
 * @author Vince
 */
public class Client extends Personne implements Identifiable
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
    
}
