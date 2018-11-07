/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.imageio.ImageIO;

/**
 *
 * @author pdolle
 */

/**
 * Exemple de jeu
 *
 * @author guillaume.laurent
 */
public class Jeu {

    private BufferedImage nyancat, fond, spritegauche, spritedroite, spritebas, mur;
    private Joueur Moi;

    public Jeu(Joueur moi) {
        try {
            this.fond = ImageIO.read(new File("fond.jpg"));
            this.nyancat = ImageIO.read(new File("nyancat.png"));
            this.spritegauche = ImageIO.read(new File("SpriteVersGauche.png"));
            this.spritedroite = ImageIO.read(new File("SpriteVersDroite.png"));
            this.spritebas = ImageIO.read(new File("SpriteVersBas.png"));
            this.mur = ImageIO.read(new File("mur.jpg"));
            this.Moi= moi;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void Afficher(Graphics2D contexte) {
        int x = this.Moi.getX();
        
        for (int i=0; i<=20; i++){
            for (int j=0; j<=20; j++){
                contexte.drawImage(this.fond, 0+30*i, 0+30*j, null);
            }
        }
        contexte.drawImage(this.spritebas, x, 150, null);
        if (this.Moi.getDirection()==4){    
        contexte.drawImage(this.spritegauche, x, 150, null);
        }
        
        if (this.Moi.getDirection()==2){    
        contexte.drawImage(this.spritedroite, x, 150, null);
        }
         for (int i=0; i<=20; i++){
        
                contexte.drawImage(this.mur, 0+30*i, 0, null);
            
        }
         for (int i=0; i<=20; i++){
        
                contexte.drawImage(this.mur, 0+30*i, 350, null);
            
        }
         for (int i=0; i<=20; i++){
        
                contexte.drawImage(this.mur, 0, 0+30*i, null);
            
        }
         for (int i=0; i<=20; i++){
        
                contexte.drawImage(this.mur, 577, 0+30*i, null);
            
        }
    }



}

    

