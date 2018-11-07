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

    private BufferedImage nyancat, fond, spritegauche, spritedroite, spritebas, mur, spritehaut;
    private Joueur Moi;

    public Jeu(Joueur moi) {
        try {
            this.fond = ImageIO.read(new File("fond.jpg"));
            this.nyancat = ImageIO.read(new File("nyancat.png"));
            this.spritegauche = ImageIO.read(new File("SpriteVersGauche.png"));
            this.spritedroite = ImageIO.read(new File("SpriteVersDroite.png"));
            this.spritehaut = ImageIO.read(new File("SpriteVersHaut.png"));
            this.spritebas = ImageIO.read(new File("SpriteVersBas.png"));
            this.mur = ImageIO.read(new File("mur.jpg"));
            this.Moi= moi;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Update(Joueur Moi){
        this.Moi = Moi;
    }


    public void Afficher(Graphics2D contexte) {
        int x = this.Moi.getX();
        int y = this.Moi.getY();
        for (int i=0; i<=20; i++){
            for (int j=0; j<=20; j++){
                contexte.drawImage(this.fond, 0+30*i, 0+30*j, null);
            }
        }
        contexte.drawImage(this.spritebas, x, y, null);
        if (this.Moi.getDirection()==4){    
        contexte.drawImage(this.spritegauche, x, y, null);
        }
        
        if (this.Moi.getDirection()==2){    
        contexte.drawImage(this.spritedroite, x, y, null);
        }
        if (this.Moi.getDirection()==1){    
        contexte.drawImage(this.spritebas, x, y, null);
        }
        if (this.Moi.getDirection()==3){    
        contexte.drawImage(this.spritehaut, x, y, null);
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

    

