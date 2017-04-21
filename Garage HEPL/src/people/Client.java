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
public class Client implements Identifiable
{
    private String numClient;
    
    public Client()
    {
        this.numClient="NULL";
    }
    
    public Client(String numCli)
    {
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
}
