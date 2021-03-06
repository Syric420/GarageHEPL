/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import Bean.*;
import java.beans.Beans;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import network.NetworkBasicServer;
import network.NetworkBasicClient;
/**
 *
 * @author tibha
 */
public class InterfaceCentrale extends javax.swing.JDialog {

    
    NetworkBasicServer server;
    NetworkBasicClient Client;
    /**
     * Creates new form InterfaceCentrale
     */ 
     DefaultTableModel dtm;
     DefaultComboBoxModel dmcb;
     ReicivingBean ReicivingBean;
     SearchBean SearchBean;
     public int type;
    public InterfaceCentrale(java.awt.Frame parent, boolean modal,int num) {
        super(parent, modal);
        initComponents();
        type = num;
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {},
        new String [] {
        "Caractéristiques", "Valeur"
        }
        ));
        dmcb = (DefaultComboBoxModel)this.jComboBox1.getModel();
        dtm = (DefaultTableModel)this.jTable1.getModel();
        switch (type){
                case 1:
                    jTextArea1.setText("Pièces");
                    //server = new NetworkBasicServer(50001, getCBMessDispo());
                    break;
                case 2:
                   // server = new NetworkBasicServer(50002, getCBMessDispo());
                    jTextArea1.setText("Pneus");
                    break;
                case 3:
                    //server = new NetworkBasicServer(50003, getCBMessDispo());
                    jTextArea1.setText("Lubrifiants");
                    break;
        }
        
        ReicivingBean = null;
         try {
             ReicivingBean = (ReicivingBean) Beans.instantiate(null, "Bean.ReicivingBean");
             
              switch (type){
                case 1:
                   
                    ReicivingBean.setServer(50001,getCBMessDispo());
                    break;
                case 2:
                    ReicivingBean.setServer(50002,getCBMessDispo());
                    break;
                case 3:
                    ReicivingBean.setServer(50003,getCBMessDispo());
                    break;
              }
             /*String message;
             while(!MessageEntrant.isSelected())
             {}*/
         } catch (IOException ex) {
             Logger.getLogger(InterfaceCentrale.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(InterfaceCentrale.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         SearchBean = null;
         
         try {
             
             SearchBean = (SearchBean) Beans.instantiate(null, "Bean.SearchBean");
             SearchBean.setIc(this);
         } catch (IOException ex) {
             Logger.getLogger(InterfaceCentrale.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(InterfaceCentrale.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         ReicivingBean.addPropertyChangeListener(SearchBean);
         ReicivingBean.setIc(this);
         SearchBean.Charger();
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        SendAnswer = new javax.swing.JButton();
        Dispo = new javax.swing.JRadioButton();
        NonDispo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonLire = new javax.swing.JButton();
        MessageEntrant = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        TFMessage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        BuActif = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        SendAnswer.setText("Envoyer réponse");
        SendAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendAnswerActionPerformed(evt);
            }
        });

        buttonGroup1.add(Dispo);
        Dispo.setText("disponible");
        Dispo.setEnabled(false);
        Dispo.setFocusable(false);
        Dispo.setRequestFocusEnabled(false);

        buttonGroup1.add(NonDispo);
        NonDispo.setText("non disponible");
        NonDispo.setEnabled(false);
        NonDispo.setFocusable(false);

        jLabel1.setText("Détails de la commande");

        jLabel2.setText("Commande en cours:");

        jButtonLire.setText("Lire");
        jButtonLire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLireActionPerformed(evt);
            }
        });

        MessageEntrant.setText("Message entrant");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        TFMessage.setText(">>");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Caractéristique", "Valeur"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 102));
        jTextArea1.setColumns(1);
        jTextArea1.setFont(new java.awt.Font("Modern No. 20", 0, 48)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(51, 51, 255));
        jTextArea1.setRows(1);
        jTextArea1.setTabSize(1);
        jTextArea1.setText("Pièces");
        jTextArea1.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea1);

        jButton3.setText("Vérification disponnibilité");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        BuActif.setText("Actif");
        BuActif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuActifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(79, 79, 79)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(69, 69, 69)
                                .addComponent(Dispo)
                                .addGap(146, 146, 146)
                                .addComponent(NonDispo)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonLire)
                            .addComponent(MessageEntrant))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TFMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BuActif)
                        .addGap(145, 145, 145))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SendAnswer)
                .addGap(261, 261, 261))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MessageEntrant)
                            .addComponent(jLabel2))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonLire)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(TFMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BuActif)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(Dispo)
                    .addComponent(NonDispo))
                .addGap(32, 32, 32)
                .addComponent(SendAnswer)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLireActionPerformed

        ReicivingBean.run();
        /*String message;
        message = server.getMessage();
        if(!message.equalsIgnoreCase("RIEN"))
        {
            LireMessage(message);
        }*/
        
    }//GEN-LAST:event_jButtonLireActionPerformed
    public void LireMessage(String message)
    {
        TFMessage.setText(message);
        AfficherJTableM(message);
        AjouterComboBox(message);
    }
    private void AfficherJTableM(String message)
    {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {},
        new String [] {
        "Caractéristiques", "Valeur"
        }
        ));
        dtm = (DefaultTableModel)this.jTable1.getModel();
        
        String Temp[],Var[] = new String[2];
        Temp=message.split("Libelle: ");
        Temp=Temp[1].split(" Quantite: ");
        Var[0]="Libelle";
        Var[1]=Temp[0];
        dtm.addRow(Var);
        Temp=Temp[1].split(" Type: ");
        Var[0]="Quantite";
        Var[1]=Temp[1];
        dtm.addRow(Var);
        Var[0]="Type";
        Var[1]=Temp[0];
        dtm.addRow(Var);
    }
     private void AfficherJTableCB(String message)
    {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {},
        new String [] {
        "Caractéristiques", "Valeur"
        }
        ));
        dtm = (DefaultTableModel)this.jTable1.getModel();
        
        String Temp[],Var[] = new String[2],libelle,piece,pneu;
        Temp=message.split(" ");
        
        Var[0]="Libelle";
        Var[1]=Temp[0];
        dtm.addRow(Var);
        
        Var[0]="Quantite";
        Var[1]=Temp[2];
        dtm.addRow(Var);
        Var[0]="Type";
        Var[1]=Temp[4];
        dtm.addRow(Var);

    }
    private void AjouterComboBox(String message)
    {
        String Temp[] = new String[2],libelle,piece,pneu;
        Temp=message.split("Libelle: ");
        Temp=Temp[1].split(" Quantite: ");
        libelle=Temp[0];
        Temp=Temp[1].split(" Type: ");
        piece=Temp[1];
        pneu=Temp[0];
        message=libelle + "  " + piece + "  " + pneu;
        dmcb.addElement(message);
        jComboBox1.setSelectedIndex(jComboBox1.getItemCount()-1);
    }
    
    private void SendAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendAnswerActionPerformed
        if(Dispo.isSelected())
            server.sendMessage("OK");
        else      
            server.sendMessage("Not ok");
    }//GEN-LAST:event_SendAnswerActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Random randomGenerator = new Random();
        int D=randomGenerator.nextInt(2);
        if(D == 1)
        {
            Dispo.setSelected(true);
            SearchBean.notifyEvent(TFMessage.getText(), true);
        }
            
        else
        {
            NonDispo.setSelected(true);
            SearchBean.notifyEvent(TFMessage.getText(), false);
        }
            
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        AfficherJTableCB(jComboBox1.getSelectedItem().toString());
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void BuActifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuActifActionPerformed
        // TODO add your handling code here:
        
        if(BuActif.getText().equals("Actif"))
        {
            BuActif.setText("Non actif");
            System.out.println("Envoyé" + type + " Pause");
            Client.sendStringWithoutWaiting(type + " Pause");
        }   
        else
        {
            BuActif.setText("Actif");
            System.out.println("Envoyé" + type + " Pause");
            Client.sendStringWithoutWaiting(type + " Actif");
            String message;
            message = server.getMessage();
            while(!message.equalsIgnoreCase("rien"))
            {
                LireMessage(message);
                message = server.getMessage();
            }
        }
            
    }//GEN-LAST:event_BuActifActionPerformed

    public void Connection(int port)
    {
        /*String message;
        message = server.getMessage();
        TFMessage.setText(message);*/
        Client = new NetworkBasicClient("localhost",port);
    }
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
            java.util.logging.Logger.getLogger(InterfaceCentrale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceCentrale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceCentrale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceCentrale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
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
                /*dialog1.InstantiateBean();
                dialog2.InstantiateBean();
                dialog3.InstantiateBean();*/
            }   
        });
        
    }
            public javax.swing.JCheckBox getCBMessDispo() {
            return MessageEntrant;
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BuActif;
    private javax.swing.JRadioButton Dispo;
    private javax.swing.JCheckBox MessageEntrant;
    private javax.swing.JRadioButton NonDispo;
    private javax.swing.JButton SendAnswer;
    private javax.swing.JTextField TFMessage;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonLire;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
