/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.util.*;
import Login.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import people.*;
/**
 *
 * @author Vince
 */
public class Login extends java.awt.Dialog {

    /**
     * Creates new form Login
     */
    private String role;
    Vector vecUtilisateurs = new Vector();
    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        Mecanicien [] tabMecanicien = {
            new Mecanicien("Jean", "Albert", "Rue des prés 15", "0474142536", "Mec201", "Pneus", "Jeanjean"),
            new Mecanicien("Cavas", "Philippe", "Rue de Stockis", "04742578", "Mec202", "Portes", "CavaCava"),
            new Mecanicien("Poluche", "Remy", "Boulevard des anes", "04642541", "Mec205", "Electronique", "Vince")
        };
        for(int i=0; i<3;i++)
            vecUtilisateurs.add(tabMecanicien[i]);
        TechnicienExterieur[] tabTechnicien=
        {
            new TechnicienExterieur("Patoche", "Sebastien", "Rue des Flans 157", "04987847", "TechExt001", "Thib"),
            new TechnicienExterieur("Malah", "Adrien", "Rue des vaches 10", "04786514", "TechExt120", "Mal"),
            new TechnicienExterieur("Cara", "Pils", "Rue de la sottise", "04478533", "TechExt52", "Car")  
        };
        
        for(int i=0; i<3;i++)
            vecUtilisateurs.add(tabTechnicien[i]);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tfUser = new java.awt.TextField();
        tfPw = new java.awt.TextField();
        labUser = new java.awt.Label();
        labLogin = new java.awt.Label();
        buok = new java.awt.Button();
        buannuler = new java.awt.Button();
        jExterieurButton = new javax.swing.JRadioButton();
        jMembreButton = new javax.swing.JRadioButton();

        setModal(true);
        setName("Login"); // NOI18N
        setResizable(false);
        setTitle("Login");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        tfUser.setName("TF_login"); // NOI18N

        tfPw.setName("TF_pw"); // NOI18N

        labUser.setText("Utilisateur :");

        labLogin.setText("Mot de passe :");

        buok.setLabel("ok");
        buok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buokActionPerformed(evt);
            }
        });

        buannuler.setLabel("annuler");
        buannuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buannulerActionPerformed(evt);
            }
        });

        buttonGroup1.add(jExterieurButton);
        jExterieurButton.setText("Extérieur habililité");
        jExterieurButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExterieurButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jMembreButton);
        jMembreButton.setSelected(true);
        jMembreButton.setText("Membre du personnel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buok, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMembreButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buannuler, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jExterieurButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPw, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jExterieurButton)
                    .addComponent(jMembreButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buannuler, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buok, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        System.exit(0);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void buokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buokActionPerformed
        String login, password;   
        Personne unePersonne;
        
        login=tfUser.getText();
        password=tfPw.getText();
        try
        {
            if(login.equals("") || password.equals(""))//Si ils sont vides
                throw new ExUtilisateurVide("Utilisateur ou mot de passe vide");
            else
            {
                if(existUser(login)==false)
                    throw new ExUtilisateurInconnu("Utilisateur inconnu");
                else
                {
                    unePersonne = returnPersonneInVector(login);
                    if(unePersonne.validate(password))
                    {
                        if(!isUserAMember(login))
                        {
                            //C'est un extérieur habilité mais qu'il a coché la mauvaise case
                            if(jMembreButton.isSelected())
                                JOptionPane.showMessageDialog( this,"La qualité du membre est erronée", "Attention", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            if(jExterieurButton.isSelected())
                                JOptionPane.showMessageDialog( this,"La qualité du membre est erronée", "Attention", JOptionPane.INFORMATION_MESSAGE);
                        }
                            
                        this.dispose();
                    }  
                    else
                        JOptionPane.showMessageDialog( this,"Le mot de passe est erroné", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        }catch(ExUtilisateurVide ex)
        {
            JOptionPane.showMessageDialog(this, ex, "Login", JOptionPane.ERROR_MESSAGE, null);
        } catch (ExUtilisateurInconnu ex) {
            JOptionPane.showMessageDialog(this, ex, "Login", JOptionPane.ERROR_MESSAGE, null);
            System.exit(0);
        }
       
    }//GEN-LAST:event_buokActionPerformed

    public Personne returnPersonneInVector(String login)
    {
        for(int i=0; i<vecUtilisateurs.size(); i++)
        {
            if(((Personne)vecUtilisateurs.elementAt(i)).getLogin().equals(login))
            {
                //Il l'a trouvé
                return (Personne)vecUtilisateurs.elementAt(i);
            }
        }
        return null;
    }
    public boolean isUserAMember(String login)
    {
        for(int i=0; i<vecUtilisateurs.size(); i++)
        {
            if(((Personne)vecUtilisateurs.elementAt(i)).getLogin().equals(login))
            {
                //Il l'a trouvé
                if(((Personne)vecUtilisateurs.elementAt(i)).isMember())
                    return true;
            }
        }
        return false;
    }
    public boolean existUser(String login)
    {
        for(int i=0; i<vecUtilisateurs.size(); i++)
        {
            if(((Personne)vecUtilisateurs.elementAt(i)).getLogin().equals(login))
                return true;
        }
        return false;
    }
    
    private void buannulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buannulerActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        dispose();
    }//GEN-LAST:event_buannulerActionPerformed

    private void jExterieurButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExterieurButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jExterieurButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button buannuler;
    private java.awt.Button buok;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jExterieurButton;
    private javax.swing.JRadioButton jMembreButton;
    private java.awt.Label labLogin;
    private java.awt.Label labUser;
    private java.awt.TextField tfPw;
    private java.awt.TextField tfUser;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }
}
