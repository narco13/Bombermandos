/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

/**
 *
 * @author pdolle
 */
public class Main extends javax.swing.JFrame {
    
    public static int ID;
    public static Joueur Moi=new Joueur(0,"erreur",300,300,1,"cut",1,1,1);
    public static BaseJoueur Adversaires = new BaseJoueur();
    private BufferedImage buffer;
    private Graphics2D contexteBuffer;
    public static ListeMur Murs=new ListeMur();
    private Jeu jeu;
    public static int largeurPersos=30;
    public static int hauteurPersos=30;

    /**
     * Creates new form Main
     */
     
    Runnable code = new Runnable() { 
  
        @Override 
        public void run() {
            int i = 1;
            
            while(i==1){
                
            //Début de la boucle infini
            
                //>>> Moi.Agir(); (à créer par équipe Jeu)
                
                Moi.Push();
                Adversaires.charger();
                
                //if (Moi.getId == 1){
                //    Projectiles.Avancer();  (à créer par équipe SQL)
                //    Projetciles.Push();
                //}
                
                //if (Moi.getId ==2){
                //    Bonus.Generer();
                //    Bonus.Push();         (à créer par équipe SQL)
                //}
                
            
                //>>> Map.Update(Moi,Adversaires,Projectiles,Bonus);  (à créer par équipe Graphisme)
                jeu.Update(Moi);
                jeu.Afficher(contexteBuffer);
                jLabel1.repaint();
                
                MAJHUD();
                MAJUHDAdversaires();
                MAJVieAdv1();
                MAJVieAdv2();
                MAJVieAdv3();
                MAJVieMoi();
            
            
            //fin de boucle infinie
            
            try {
            
                Thread.sleep(100);
            } catch (Exception e) {
            e.printStackTrace();
            }

            }
 
        } 
    }; 
    
    public Main(String args[]) {
        // initialisation
        System.out.println("Main lancé! Argument reçu: ID ="+args[0]);
        ID = parseInt(args[0]);
        Moi.setPseudo(""+args[1]);
        Moi.setId(ID);
        
        Adversaires.InitBaseAdversaires(ID);
        
        
        
        
        initComponents();
        Thread tache = new Thread(code);
        this.jeu = new Jeu(Moi);

        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
        this.buffer = new BufferedImage(this.jLabel1.getWidth(), this.jLabel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        jLabel1.setIcon(new ImageIcon(this.buffer));
        this.contexteBuffer = this.buffer.createGraphics();
        
        
        tache.start(); // lancement de la boucle infinie
        
        Murs.add(new Mur(0,0,577,30));
        Murs.add(new Mur(0,0,30,350));
        Murs.add(new Mur(547,0,577,350));
        Murs.add(new Mur(0,0,30,577));
        
        
    }
        public void MAJHUD(){
        //afficher pseudo joueur Moi
       
        jTextField1.setText(Moi.getPseudo());
    }
    public void MAJUHDAdversaires(){
        jTextField2.setText(Adversaires.joueur1.getPseudo());
        jTextField3.setText(Adversaires.joueur2.getPseudo());
        jTextField4.setText(Adversaires.joueur3.getPseudo());
    }

    public void MAJVieAdv1(){
        ImageIcon Vie = new ImageIcon("3coeurs.png");
        if(Adversaires.joueur1.getPv()==2){
            Vie = new ImageIcon("2coeurs.png");
        }
        if(Adversaires.joueur1.getPv()==1){
            Vie = new ImageIcon("1coeur.png");
        }
        if(Adversaires.joueur1.getPv()==0){
            Vie = new ImageIcon("0coeur.png");
        }
        jLabel2.setIcon(Vie);  
    }
    public void MAJVieAdv2(){
        ImageIcon Vie = new ImageIcon("3coeurs.png");
        if(Adversaires.joueur2.getPv()==2){
            Vie = new ImageIcon("2coeurs.png");
        }
        if(Adversaires.joueur2.getPv()==1){
            Vie = new ImageIcon("1coeur.png");
        }
        if(Adversaires.joueur2.getPv()==0){
            Vie = new ImageIcon("0coeur.png");
        }
        jLabel3.setIcon(Vie);  
    }
    public void MAJVieAdv3(){
        ImageIcon Vie = new ImageIcon("3coeurs.png");
        if(Adversaires.joueur3.getPv()==2){
            Vie = new ImageIcon("2coeurs.png");
        }
        if(Adversaires.joueur3.getPv()==1){
            Vie = new ImageIcon("1coeur.png");
        }
        if(Adversaires.joueur3.getPv()==0){
            Vie = new ImageIcon("0coeur.png");
        }
        jLabel4.setIcon(Vie);  
    }
    public void MAJVieMoi(){
        ImageIcon Vie = new ImageIcon("3coeurs.png");
        if(Moi.getPv()==2){
            Vie = new ImageIcon("2coeurs.png");
        }
        if(Moi.getPv()==1){
            Vie = new ImageIcon("1coeur.png");
        }
        if(Moi.getPv()==0){
            Vie = new ImageIcon("0coeur.png");
        }
        jLabel5.setIcon(Vie);  
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("jLabel1");
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel1KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:

        if(evt.getKeyCode() == evt.VK_RIGHT){
            Moi.deplacerDroite();
        }
        if(evt.getKeyCode() == evt.VK_LEFT && !Moi.EstOccupee(Moi.getX()-5, Moi.getY())){
            Moi.deplacerGauche();
        }
        if(evt.getKeyCode() == evt.VK_UP && !Moi.EstOccupee(Moi.getX(), Moi.getY()-5)){
            Moi.deplacerHaut();
        }
        if(evt.getKeyCode() == evt.VK_DOWN && !Moi.EstOccupee(Moi.getX(), Moi.getY()+5)){
            Moi.deplacerBas();
        }

        
    }//GEN-LAST:event_formKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Moi.setEtat(-1);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main(args).setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
