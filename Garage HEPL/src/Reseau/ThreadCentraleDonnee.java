/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reseau;

import Gui.InterfaceApplication;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.NetworkBasicServer;

/**
 *
 * @author Vince
 */
public class ThreadCentraleDonnee extends Thread {
    NetworkBasicServer server;
   // private javax.swing.JCheckBox MessageEntrant;
    private InterfaceApplication IA;
    public ThreadCentraleDonnee() {
        //MessageEntrant = new javax.swing.JCheckBox();
        server = new NetworkBasicServer(50011, null);
    }
    
        /*public javax.swing.JCheckBox getCBMessDispo() {
            return MessageEntrant;
        }*/
    @Override
    public void run()
    {
        String message;
        while(true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadCentraleDonnee.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            message = server.getMessage();
            System.out.println("Mesage recu thread: " + message);
            if(!message.equalsIgnoreCase("RIEN"))
            {
                getIA().TraiterMessage(message);
            }
        }
        
    }
        public InterfaceApplication getIA() {
        return IA;
    }
        public void setIA(InterfaceApplication IA) {
        this.IA = IA;
    }

}
