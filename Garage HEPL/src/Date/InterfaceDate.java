/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date;

import Gui.InterfaceApplication;
import javax.swing.*;

/**
 *
 * @author Vince
 */
public class InterfaceDate extends javax.swing.JDialog {

    /**
     * Creates new form FormatDate
     */
    DefaultComboBoxModel dcbmPays = new DefaultComboBoxModel();
    DefaultComboBoxModel dcbmDate = new DefaultComboBoxModel();
    DefaultComboBoxModel dcbmTemps = new DefaultComboBoxModel();
    ThreadDate thread;
    public InterfaceDate(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        dcbmPays.addElement("France");dcbmPays.addElement("Royaume Uni");dcbmPays.addElement("Allemagne");dcbmPays.addElement("Italie");dcbmPays.addElement("U.S.A.");CB_Pays.setModel(dcbmPays);
        dcbmDate.addElement("Full");dcbmDate.addElement("Long");dcbmDate.addElement("Medium");dcbmDate.addElement("Short");CB_FormatDate.setModel(dcbmDate);
        dcbmTemps.addElement("Full");dcbmTemps.addElement("Long");dcbmTemps.addElement("Medium");dcbmTemps.addElement("Short");CB_FormatTemps.setModel(dcbmTemps);
        //System.out.println(dcbmPays.getSelectedItem().toString() + " " + dcbmDate.getSelectedItem().toString()+" "+dcbmTemps.getSelectedItem().toString());
        thread = new ThreadDate(dcbmPays.getSelectedItem().toString(), dcbmDate.getSelectedItem().toString(), dcbmTemps.getSelectedItem().toString());
        
        thread.setIA(((InterfaceApplication)getParent()));
        thread.start();
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
        CB_Pays = new javax.swing.JComboBox<>();
        CB_FormatDate = new javax.swing.JComboBox<>();
        CB_FormatTemps = new javax.swing.JComboBox<>();
        JB_Enregistrer = new javax.swing.JButton();
        JB_Quitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Date");
        setModal(true);
        setResizable(false);

        jLabel1.setText("Pays:");

        jLabel2.setText("Format de la date:");

        jLabel3.setText("Format du temps:");

        CB_Pays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CB_FormatDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CB_FormatTemps.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JB_Enregistrer.setText("Enregistrer");
        JB_Enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_EnregistrerActionPerformed(evt);
            }
        });

        JB_Quitter.setText("Quitter");
        JB_Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_QuitterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_Enregistrer)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_Quitter)
                    .addComponent(CB_FormatTemps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_Pays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_FormatDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CB_Pays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CB_FormatDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CB_FormatTemps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Enregistrer)
                    .addComponent(JB_Quitter))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_QuitterActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_JB_QuitterActionPerformed

    private void JB_EnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_EnregistrerActionPerformed
        // TODO add your handling code here:
        thread.setPays(dcbmPays.getSelectedItem().toString());
        thread.setFormatDate(dcbmDate.getSelectedItem().toString());
        thread.setFormatTemps(dcbmTemps.getSelectedItem().toString());
    }//GEN-LAST:event_JB_EnregistrerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look nd feel */
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
            java.util.logging.Logger.getLogger(InterfaceDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceDate dialog = new InterfaceDate(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_FormatDate;
    private javax.swing.JComboBox<String> CB_FormatTemps;
    private javax.swing.JComboBox<String> CB_Pays;
    private javax.swing.JButton JB_Enregistrer;
    private javax.swing.JButton JB_Quitter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
