/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import Activites.Travail;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import people.*;

/**
 *
 * @author Vince
 */
public class InterfaceApplication extends javax.swing.JFrame {
    Login Login;
    InterfaceAProposDe APropos = new InterfaceAProposDe(this,true);
    LinkedList<Travail> Travaux=new LinkedList<Travail>();
    Vector<Travail> TravailEnCours=new Vector<Travail>();
    Vector<Travail> TravailTermine=new Vector<Travail>();
    Vector<Client> vecClients=new Vector<Client>();
    Vector <String> temp = new Vector<String>();
    InterfaceCommande Pieces;
    InterfaceCommande Pneus;
    InterfaceCommande Lubrifiant;
    InterfacePeCVeh PeC;
    InterfaceRdv Rdv;
    InterfaceTermine End;
    InterfaceNewClient intNewClient;

    /**
     * Creates new form InterfaceApplication
     */
    public InterfaceApplication() {
        try
        {
            Client tabCli[] =
            {
                new Client("A520", "Peter", "Jordan", "Rue du Coq 5", "0485452536"),
                new Client("A530", "Dove", "David", "Rue de l'Yser 187", "0445253685")
            };
            
            if(Client.chargerVector()==null)// Si le vecteur est null, on en rajoute par défaut
            {
                for(int i=0; i<tabCli.length; i++)
                    vecClients.add(tabCli[i]);
            }
            else
                vecClients = Client.chargerVector();
            Travaux = Travail.chargerLL();
            TravailEnCours = Travail.chargerVec(1);
            
            TravailTermine = Travail.chargerVec(2);
            initComponents();
            //Une fois chargés les travaux en cours doivent être remis sur les différents ponts
            for(int i=0; i<TravailEnCours.size();i++)
                AfficheTF(TravailEnCours.get(i));
            Login= new Login(this,true);
            PeC= new InterfacePeCVeh(this, true);
            Rdv = new InterfaceRdv(this, true);
            End = new InterfaceTermine(this,true);
            Pieces = new InterfaceCommande(this,true,1);
            Pneus = new InterfaceCommande(this,true,2);
            Lubrifiant = new InterfaceCommande(this,true,3);
            intNewClient = new InterfaceNewClient(this, true);
            End.ajoutVector(TravailEnCours);
            Login.setVisible(true);
            PeC.ajouterVecTable();
            String maDate;
            Date date = new Date();
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
            TimeZone cetTime = TimeZone.getTimeZone("CET");
            df.setTimeZone(cetTime);
            maDate = df.format(date);
            jLabelDate.setText(maDate);
        }
        catch (IOException ex)
        {
            Logger.getLogger(InterfaceApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    public boolean isAvailable(String nom)
    {
        if(nom.equalsIgnoreCase("Pont 1"))
            if(JTFPont1.getText().equals(""))
                return true;
            else
                return false;
        else if(nom.equalsIgnoreCase("Pont 2"))
                if(JTFPont2.getText().equals(""))
                    return true;
                else
                    return false;
        else if(nom.equalsIgnoreCase("Pont 3"))
                if(JTFPont3.getText().equals(""))
                    return true;
                else
                    return false;
        else if(nom.equalsIgnoreCase("Sol"))
                if(JTFSol.getText().equals(""))
                    return true;
                else
                    return false;
            else
                return false;
            
    }
    public void ViderFichier(String cheminFichier)
    {
        //ObjectOutputStream oos;
        try
        {
            Rdv.fos.close();
            Rdv.fos=null;
            Rdv.oos=null;
            Rdv.fos = new FileOutputStream(cheminFichier);
            Rdv.oos = new ObjectOutputStream(Rdv.fos);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Erreur ! Fichier non trouvé [" + e + "]");
        }
        catch (IOException e)
        {
            System.err.println("Erreur ! ? [" + e + "]");
        }
    }
    public void AfficheTF(Travail t)
    {
        String nom = t.getPontTravail();
        if(nom.equalsIgnoreCase("Pont 1"))
            JTFPont1.setText(t.toString());
        else if(nom.equalsIgnoreCase("Pont 2"))
                    JTFPont2.setText(t.toString());
            else if(nom.equalsIgnoreCase("Pont 3"))
                    JTFPont3.setText(t.toString());
            else if(nom.equalsIgnoreCase("Sol"))
                JTFSol.setText(t.toString());
    }
    public void VideTF(String nom)
    {
        if(nom.equalsIgnoreCase("Pont 1"))
            JTFPont1.setText("");
        else if(nom.equalsIgnoreCase("Pont 2"))
                    JTFPont2.setText("");
            else if(nom.equalsIgnoreCase("Pont 3"))
                    JTFPont3.setText("");
            else if(nom.equalsIgnoreCase("Sol"))
                JTFSol.setText("");
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelAtelier = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        JTFPont1 = new javax.swing.JTextField();
        JTFPont2 = new javax.swing.JTextField();
        JTFPont3 = new javax.swing.JTextField();
        JTFSol = new javax.swing.JTextField();
        JTFDivers = new javax.swing.JTextField();
        jLabelBureau = new javax.swing.JLabel();
        jLabelBurCompta = new javax.swing.JLabel();
        jLabelBuCli = new javax.swing.JLabel();
        jLabelCom = new javax.swing.JLabel();
        JTFBuCli = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAtelier = new javax.swing.JMenu();
        jMenuAPrevoir = new javax.swing.JMenuItem();
        jMenuPeC = new javax.swing.JMenuItem();
        jMenuTerminé = new javax.swing.JMenuItem();
        jMenuListes = new javax.swing.JMenuItem();
        jMateriel = new javax.swing.JMenu();
        jMenuCommander = new javax.swing.JMenu();
        jMenuPiece = new javax.swing.JMenuItem();
        jMenuPneus = new javax.swing.JMenuItem();
        jMenuLub = new javax.swing.JMenuItem();
        jMenuReceptionner = new javax.swing.JMenuItem();
        jMenuListeCommandes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuInfoSysteme = new javax.swing.JMenuItem();
        jMenuAide = new javax.swing.JMenu();
        jMenuPourDebuter = new javax.swing.JMenuItem();
        jMenuAProposDe = new javax.swing.JMenuItem();

        jMenu7.setText("File");
        jMenuBar2.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar2.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Pont n 1:");

        jLabel2.setText("Pont n 2:");

        jLabel3.setText("Pont n 3:");

        jLabel4.setText("Sol:");

        jLabel5.setText("Divers:");

        jLabelAtelier.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelAtelier.setText("Atelier");

        jLabelDate.setText("Date/heure");

        JTFPont1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFPont1ActionPerformed(evt);
            }
        });

        JTFPont3.setToolTipText("");

        jLabelBureau.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelBureau.setText("Bureau");

        jLabelBurCompta.setText("Bureau comptabilité:");

        jLabelBuCli.setText("Bureau client:");

        jLabelCom.setText("Com");

        jMenuAtelier.setText("Atelier");

        jMenuAPrevoir.setText("A prévoir");
        jMenuAPrevoir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAPrevoirActionPerformed(evt);
            }
        });
        jMenuAtelier.add(jMenuAPrevoir);

        jMenuPeC.setText("Prise en charge");
        jMenuPeC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPeCActionPerformed(evt);
            }
        });
        jMenuAtelier.add(jMenuPeC);

        jMenuTerminé.setText("Terminé");
        jMenuTerminé.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTerminéActionPerformed(evt);
            }
        });
        jMenuAtelier.add(jMenuTerminé);

        jMenuListes.setText("Listes");
        jMenuAtelier.add(jMenuListes);

        jMenuBar1.add(jMenuAtelier);

        jMateriel.setText("Matériel");

        jMenuCommander.setText("Commander");

        jMenuPiece.setText("Commander une pièce");
        jMenuPiece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPieceActionPerformed(evt);
            }
        });
        jMenuCommander.add(jMenuPiece);

        jMenuPneus.setText("Commander des pneus");
        jMenuPneus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPneusActionPerformed(evt);
            }
        });
        jMenuCommander.add(jMenuPneus);

        jMenuLub.setText("Commander lubrifiant");
        jMenuLub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLubActionPerformed(evt);
            }
        });
        jMenuCommander.add(jMenuLub);

        jMateriel.add(jMenuCommander);

        jMenuReceptionner.setText("Réceptionner");
        jMateriel.add(jMenuReceptionner);

        jMenuListeCommandes.setText("Liste commandes");
        jMateriel.add(jMenuListeCommandes);

        jMenuBar1.add(jMateriel);

        jMenu3.setText("Clients");

        jMenuItem1.setText("Ajouter client");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Voir les clients");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Factures");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("                                                                                                                                                                      ");
        jMenu5.setContentAreaFilled(false);
        jMenu5.setEnabled(false);
        jMenu5.setFocusable(false);
        jMenu5.setRequestFocusEnabled(false);
        jMenu5.setRolloverEnabled(false);
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Paramètres");

        jMenuInfoSysteme.setText("Infos systèmes");
        jMenuInfoSysteme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInfoSystemeActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuInfoSysteme);

        jMenuBar1.add(jMenu6);

        jMenuAide.setText("Aide");

        jMenuPourDebuter.setText("Pour débuter");
        jMenuPourDebuter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPourDebuterActionPerformed(evt);
            }
        });
        jMenuAide.add(jMenuPourDebuter);

        jMenuAProposDe.setText("A propos de ...");
        jMenuAProposDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAProposDeActionPerformed(evt);
            }
        });
        jMenuAide.add(jMenuAProposDe);

        jMenuBar1.add(jMenuAide);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBurCompta)
                    .addComponent(jLabelBuCli))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTFSol)
                    .addComponent(JTFDivers)
                    .addComponent(JTFBuCli)
                    .addComponent(JTFPont2)
                    .addComponent(JTFPont3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCom)
                        .addGap(0, 323, Short.MAX_VALUE))
                    .addComponent(JTFPont1))
                .addGap(241, 241, 241))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelAtelier, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jLabelBureau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 595, Short.MAX_VALUE)
                .addComponent(jLabelDate)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabelAtelier)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFPont1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFPont2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFPont3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JTFSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JTFDivers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addComponent(jLabelBureau)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBuCli)
                    .addComponent(JTFBuCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBurCompta)
                    .addComponent(jLabelCom))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFPont1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFPont1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFPont1ActionPerformed

    private void jMenuAPrevoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAPrevoirActionPerformed
        // TODO add your handling code here:
        Rdv.setVisible(true);
    }//GEN-LAST:event_jMenuAPrevoirActionPerformed

    private void jMenuTerminéActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTerminéActionPerformed
        End.setVisible(true);
    }//GEN-LAST:event_jMenuTerminéActionPerformed

    private void jMenuPeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPeCActionPerformed
        PeC.setVisible(true);
    }//GEN-LAST:event_jMenuPeCActionPerformed

    private void jMenuAProposDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAProposDeActionPerformed
        // TODO add your handling code here:
        APropos.setVisible(true);
    }//GEN-LAST:event_jMenuAProposDeActionPerformed

    private void jMenuPourDebuterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPourDebuterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuPourDebuterActionPerformed

    private void jMenuInfoSystemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInfoSystemeActionPerformed
        String nomUser, userDir, repCourant, newLigne; 
        newLigne = System.getProperty("line.separator");
        nomUser = System.getProperty("user.name");
        userDir = System.getProperty("os.name");
        repCourant = System.getProperty("user.dir");
        
        JOptionPane.showMessageDialog(this, "Nom du user : "+nomUser+newLigne+"Nom de l'os : "+userDir+newLigne+"Repertoire courant : "+repCourant, "Informations système", JOptionPane.INFORMATION_MESSAGE, null);
    }//GEN-LAST:event_jMenuInfoSystemeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.intNewClient.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, vecClients);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Travail.enregistrerVec(this.TravailEnCours, 1);
        Travail.enregistrerVec(this.TravailTermine, 2);
        Travail.enregistrerLL(Travaux);
        Personne.enregistrerVector(Login.vecUtilisateurs);
        Client.enregistrerVector(vecClients);
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void jMenuPieceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPieceActionPerformed
        // TODO add your handling code here:
        Pieces.setVisible(true);  
    }//GEN-LAST:event_jMenuPieceActionPerformed

    private void jMenuPneusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPneusActionPerformed

        Pneus.setVisible(true);
    }//GEN-LAST:event_jMenuPneusActionPerformed

    private void jMenuLubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLubActionPerformed
       
        Lubrifiant.setVisible(true);
    }//GEN-LAST:event_jMenuLubActionPerformed

    
    public void ajoutLinkedList(Travail unTrav)
    {
        Travaux.add(unTrav);
    }
    
    public Vector getTravauxEnCours()
    {
        return this.TravailEnCours;
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
            java.util.logging.Logger.getLogger(InterfaceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTFBuCli;
    private javax.swing.JTextField JTFDivers;
    private javax.swing.JTextField JTFPont1;
    private javax.swing.JTextField JTFPont2;
    private javax.swing.JTextField JTFPont3;
    private javax.swing.JTextField JTFSol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAtelier;
    private javax.swing.JLabel jLabelBuCli;
    private javax.swing.JLabel jLabelBurCompta;
    private javax.swing.JLabel jLabelBureau;
    private javax.swing.JLabel jLabelCom;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JMenu jMateriel;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuItem jMenuAPrevoir;
    private javax.swing.JMenuItem jMenuAProposDe;
    private javax.swing.JMenu jMenuAide;
    private javax.swing.JMenu jMenuAtelier;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuCommander;
    private javax.swing.JMenuItem jMenuInfoSysteme;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuListeCommandes;
    private javax.swing.JMenuItem jMenuListes;
    private javax.swing.JMenuItem jMenuLub;
    private javax.swing.JMenuItem jMenuPeC;
    private javax.swing.JMenuItem jMenuPiece;
    private javax.swing.JMenuItem jMenuPneus;
    private javax.swing.JMenuItem jMenuPourDebuter;
    private javax.swing.JMenuItem jMenuReceptionner;
    private javax.swing.JMenuItem jMenuTerminé;
    // End of variables declaration//GEN-END:variables
}
