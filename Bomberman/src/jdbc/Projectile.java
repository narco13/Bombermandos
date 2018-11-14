/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import static jdbc.Main.hauteurPersos;
import static jdbc.Main.largeurPersos;

/**
 *
 * @author pdolle
 */
public class Projectile {
    
    private static String type;
    private static int x;
    private static int y;
    private static int vitessex;
    private static int vitessey;
    private static int hauteur;
    private static int largeur;
    private static int numero_lanceur;

    
    /*constructeur*/
    public Projectile(String type, int x, int y, int vitessex, int vitessey, int hauteur, int largeur, int numero_lanceur) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.vitessex = vitessex;
        this.vitessey = vitessey;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.numero_lanceur = numero_lanceur;

    }
    
    public boolean TestChoc(Joueur joueur){
        boolean Choc = false;
        
        //Génération des 4 points délimitant le rectangle du joueur, en commencant 
        //par en haut à gauche et en tournant dans le sens horaire
        
        int x1=joueur.getX()-largeurPersos/2;
        int y1=joueur.getY()-hauteurPersos/2;
        int x2=joueur.getX()+largeurPersos/2;
        int y2=y1;
        int x3=x2;
        int y3=joueur.getY()+hauteurPersos/2;
        int x4=x1;
        int y4=y3;
        
        if ((this.x-this.largeur/2)<x1 & (this.x+this.largeur/2)>x1 & (this.y-this.hauteur/2)<y1 & (this.y+this.largeur/2)>y1){
            Choc = true;
        }
        if ((this.x-this.largeur/2)<x2 & (this.x+this.largeur/2)>x2 & (this.y-this.hauteur/2)<y2 & (this.y+this.largeur/2)>y2){
            Choc = true;
        }
        if ((this.x-this.largeur/2)<x3 & (this.x+this.largeur/2)>x3 & (this.y-this.hauteur/2)<y3 & (this.y+this.largeur/2)>y3){
            Choc = true;
        }
        if ((this.x-this.largeur/2)<x4 & (this.x+this.largeur/2)>x4 & (this.y-this.hauteur/2)<y4 & (this.y+this.largeur/2)>y4){
            Choc = true;
        }
        
        return Choc;
    }
    
}
