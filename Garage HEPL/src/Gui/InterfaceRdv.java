/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Activites.*;
import Vehicules.TypeVoiture;
import Vehicules.Voiture;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import people.Client;

/**
 *
 * @author Vince
 */

public class InterfaceRdv extends javax.swing.JDialog {
    
    DefaultComboBoxModel dmcbTravailEntretien = new DefaultComboBoxModel();
    DefaultComboBoxModel dmcbTravailReparation = new DefaultComboBoxModel();
    DefaultComboBoxModel dmcbProprio = new DefaultComboBoxModel();
    FileOutputStream fos ;
    ObjectOutputStream oos;
    /**
     * Creates new form InterfaceRdv
     */
    public InterfaceRdv(java.awt.Frame parent, boolean modal) throws IOException {
        
        super(parent, modal);
        initComponents();
        String user = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String cheminFichier = user+separator+"Serialize"+separator+"Travaux.data";
        try
        {
            fos=new FileOutputStream(cheminFichier);
            oos = new ObjectOutputStream(fos);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Erreur ! Fichier non trouvé [" + e + "]");
        }
        catch (IOException e)
        {
            System.err.println("Erreur ! ? [" + e + "]");
        }
        Travail.enregistrerLL(((InterfaceApplication)getParent()).Travaux,oos);
        
        dmcbTravailEntretien.addElement("Entretien annuel");
        dmcbTravailEntretien.addElement("Entretien 40000");
        dmcbTravailEntretien.addElement("Pneus hiver");
        CB_TypeTravail.setModel(dmcbTravailEntretien);
        
        dmcbTravailReparation.addElement("Reparation clim");
        dmcbTravailReparation.addElement("Reparation phares");
        
        for(int i=0; i<((InterfaceApplication)getParent()).vecClients.size();i++)
            dmcbProprio.addElement(((InterfaceApplication)getParent()).vecClients.elementAt(i));
        CB_Proprietaire.setModel(dmcbProprio);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TF_TypeVoiture = new javax.swing.JTextField();
        TF_Immatriculation = new javax.swing.JTextField();
        CB_Proprietaire = new javax.swing.JComboBox<>();
        CB_TypeTravail = new javax.swing.JComboBox<>();
        RB_Reparation = new javax.swing.JRadioButton();
        RB_Entretien = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_Instructions = new javax.swing.JTextArea();
        JB_Ok = new javax.swing.JButton();
        JB_Annuler = new javax.swing.JButton();
        CB_PlaqueBelge = new javax.swing.JCheckBox();
        JB_New = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Type voiture:");

        jLabel2.setText("Immatriculation:");

        jLabel3.setText("Propriétaire:");

        jLabel4.setText("Type de travail:");

        jLabel5.setText("Instructions particulières:");

        CB_Proprietaire.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mtre Dieu", "Vince", "Thibault" }));

        CB_TypeTravail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        RB_Reparation.setText("Réparation");
        RB_Reparation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_ReparationActionPerformed(evt);
            }
        });

        RB_Entretien.setSelected(true);
        RB_Entretien.setText("Entretien");
        RB_Entretien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_EntretienActionPerformed(evt);
            }
        });

        TA_Instructions.setColumns(20);
        TA_Instructions.setRows(5);
        jScrollPane1.setViewportView(TA_Instructions);

        JB_Ok.setText("Ok");
        JB_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_OkActionPerformed(evt);
            }
        });

        JB_Annuler.setText("Annuler");
        JB_Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AnnulerActionPerformed(evt);
            }
        });

        CB_PlaqueBelge.setText("Plaque belge");

        JB_New.setText("New");
        JB_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_NewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CB_TypeTravail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TF_TypeVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TF_Immatriculation, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(CB_Proprietaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(JB_New)
                                                .addComponent(CB_PlaqueBelge)))))
                                .addGap(47, 47, 47))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(RB_Entretien)
                        .addGap(68, 68, 68)
                        .addComponent(RB_Reparation)))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(JB_Ok)
                .addGap(94, 94, 94)
                .addComponent(JB_Annuler)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TF_TypeVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TF_Immatriculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_PlaqueBelge))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CB_Proprietaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_New))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RB_Reparation)
                    .addComponent(RB_Entretien))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CB_TypeTravail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Ok)
                    .addComponent(JB_Annuler))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AnnulerActionPerformed
        // TODO add your handling code here:
        TF_TypeVoiture.setText("");
        TF_Immatriculation.setText("");
        CB_PlaqueBelge.setSelected(false);
        CB_Proprietaire.setSelectedIndex(0);
        CB_TypeTravail.setSelectedIndex(0);
        TA_Instructions.setText("");
        RB_Entretien.setSelected(true);
        RB_Reparation.setSelected(false);
        this.setVisible(false);
    }//GEN-LAST:event_JB_AnnulerActionPerformed

    private void JB_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_OkActionPerformed
        // TODO add your handling code here:
        //Vector vec = new Vector();
        Reparation uneReparation = new Reparation();
        Entretien unEntretien = new Entretien();
        
        Reparation r = new Reparation();
        Voiture voiture = new Voiture();
        TypeVoiture type = new TypeVoiture();
        

        voiture.setID(TF_Immatriculation.getText());
        voiture.setProprietaire((Client)dmcbProprio.getSelectedItem());
        type.setMarque(TF_TypeVoiture.getText());
        voiture.setType(type);
        
        if(RB_Entretien.isSelected())
        {
            //On initialise un entretien
            unEntretien.setTravail(CB_TypeTravail.getSelectedItem().toString());
            unEntretien.setRemarque(TA_Instructions.getText());
            unEntretien.setVoiture(voiture);
            ((InterfaceApplication)getParent()).ajoutLinkedList(unEntretien);
            Entretien.enregistrer(oos, unEntretien);
        }
        else
        {
            uneReparation.setTravail(CB_TypeTravail.getSelectedItem().toString());
            uneReparation.setRemarque(TA_Instructions.getText());
            uneReparation.setVoiture(voiture);
            ((InterfaceApplication)getParent()).ajoutLinkedList(uneReparation);
            Reparation.enregistrer(oos,uneReparation);
        }
        
        ((InterfaceApplication)getParent()).PeC.ajouterLigneTable();
        this.JB_AnnulerActionPerformed(null);

                
    }//GEN-LAST:event_JB_OkActionPerformed
    
    private void RB_EntretienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_EntretienActionPerformed
        // TODO add your handling code here:
        RB_Reparation.setSelected(false);
        RB_Entretien.setSelected(true);
        CB_TypeTravail.setModel(dmcbTravailEntretien);
    }//GEN-LAST:event_RB_EntretienActionPerformed

    private void RB_ReparationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_ReparationActionPerformed
        // TODO add your handling code here:
        RB_Entretien.setSelected(false);
        RB_Reparation.setSelected(true);
        CB_TypeTravail.setModel(dmcbTravailReparation);
    }//GEN-LAST:event_RB_ReparationActionPerformed

    private void JB_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_NewActionPerformed
        // TODO add your handling code here:
        ((InterfaceApplication)getParent()).intNewClient.setVisible(true);
        
    }//GEN-LAST:event_JB_NewActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfaceRdv dialog = new InterfaceRdv(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(InterfaceRdv.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CB_PlaqueBelge;
    private javax.swing.JComboBox<String> CB_Proprietaire;
    private javax.swing.JComboBox<String> CB_TypeTravail;
    private javax.swing.JButton JB_Annuler;
    private javax.swing.JButton JB_New;
    private javax.swing.JButton JB_Ok;
    private javax.swing.JRadioButton RB_Entretien;
    private javax.swing.JRadioButton RB_Reparation;
    private javax.swing.JTextArea TA_Instructions;
    private javax.swing.JTextField TF_Immatriculation;
    private javax.swing.JTextField TF_TypeVoiture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
