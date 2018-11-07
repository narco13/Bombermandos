package exempledejeu;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Exemple de jeu
 *
 * @author guillaume.laurent
 */
public class Jeu {

    private BufferedImage nyancat, fond, spritegauche, spritedroite, spritebas, mur;
    private int x;
    private boolean gauche, droite;

    public Jeu() {
        try {
            this.fond = ImageIO.read(new File("fond.jpg"));
            this.nyancat = ImageIO.read(new File("nyancat.png"));
            this.spritegauche = ImageIO.read(new File("SpriteVersGauche.png"));
            this.spritedroite = ImageIO.read(new File("SpriteVersDroite.png"));
            this.spritebas = ImageIO.read(new File("SpriteVersBas.png"));
            this.mur = ImageIO.read(new File("mur.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.x = 100;
        this.gauche = false;
        this.droite = false;
    }

    public void MettreAJour() {
        if (this.gauche) {
            x -= 5;
        }
        if (this.droite) {
            x += 5;
        }
        if (x > 50*this.fond.getWidth() - this.nyancat.getWidth()) {
            x = 50*this.fond.getWidth() - this.nyancat.getWidth();
        }
        if (x < 0) {
            x = 0;
        }
    }

    public void Afficher(Graphics2D contexte) {
        for (int i=0; i<=20; i++){
            for (int j=0; j<=20; j++){
                contexte.drawImage(this.fond, 0+30*i, 0+30*j, null);
            }
        }
        contexte.drawImage(this.spritebas, x, 150, null);
        if (this.gauche){    
        contexte.drawImage(this.spritegauche, x, 150, null);
        }
        
        if (this.droite){    
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
    tdgifbjxdfnikjhnbdgxsgb
            uytrfytgfyh

    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
    }

}
