/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tibha
 */
public class LancementInterfacesCentrales {

    /**
     * @param args the command line arguments
     */
    LancementInterfacesCentrales()
    {
                            InterfaceCentrale dialog1 = new InterfaceCentrale(new javax.swing.JFrame(), false , 1);
                dialog1.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog1.setVisible(true);
                InterfaceCentrale dialog2 = new InterfaceCentrale(new javax.swing.JFrame(), false , 2);
                dialog2.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog2.setVisible(true);
                InterfaceCentrale dialog3 = new InterfaceCentrale(new javax.swing.JFrame(), false , 3);
                dialog3.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog3.setVisible(true);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(InterfaceCentrale.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                dialog1.Connection(50011);
                dialog2.Connection(50012);
                dialog3.Connection(50013);
    }
    public static void main(String[] args) {
        
        
                        InterfaceCentrale dialog1 = new InterfaceCentrale(new javax.swing.JFrame(), false , 1);
                dialog1.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog1.setVisible(true);
                InterfaceCentrale dialog2 = new InterfaceCentrale(new javax.swing.JFrame(), false , 2);
                dialog2.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog2.setVisible(true);
                InterfaceCentrale dialog3 = new InterfaceCentrale(new javax.swing.JFrame(), false , 3);
                dialog3.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog3.setVisible(true);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(InterfaceCentrale.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                dialog1.Connection(50011);
                dialog2.Connection(50012);
                dialog3.Connection(50013);
    }
    
}
