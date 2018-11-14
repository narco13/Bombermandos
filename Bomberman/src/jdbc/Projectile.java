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
    private static long duree_de_vie;
    private static long naissance;

    
    /*constructeur*/
    public Projectile(String type, int x, int y, int vitessex, int vitessey, int hauteur, int largeur, int numero_lanceur, long duree_de_vie, long naissance) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.vitessex = vitessex;
        this.vitessey = vitessey;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.numero_lanceur = numero_lanceur;
        this.duree_de_vie = duree_de_vie;
        this.naissance = naissance;

    }
    
    /*getters*/

    public static String getType() {
        return type;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static int getVitessex() {
        return vitessex;
    }

    public static int getVitessey() {
        return vitessey;
    }

    public static int getHauteur() {
        return hauteur;
    }

    public static int getLargeur() {
        return largeur;
    }

    public static int getNumero_lanceur() {
        return numero_lanceur;
    }

    public static long getDuree_de_vie() {
        return duree_de_vie;
    }

    public static long getNaissance() {
        return naissance;
    }
    
    
    /*setter*/

    public static void setType(String type) {
        Projectile.type = type;
    }

    public static void setX(int x) {
        Projectile.x = x;
    }

    public static void setY(int y) {
        Projectile.y = y;
    }

    public static void setVitessex(int vitessex) {
        Projectile.vitessex = vitessex;
    }

    public static void setVitessey(int vitessey) {
        Projectile.vitessey = vitessey;
    }

    public static void setHauteur(int hauteur) {
        Projectile.hauteur = hauteur;
    }

    public static void setLargeur(int largeur) {
        Projectile.largeur = largeur;
    }

    public static void setNumero_lanceur(int numero_lanceur) {
        Projectile.numero_lanceur = numero_lanceur;
    }

    public static void setDuree_de_vie(long duree_de_vie) {
        Projectile.duree_de_vie = duree_de_vie;
    }

    public static void setNaissance(long naissance) {
        Projectile.naissance = naissance;
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
    
    public void Couteau(Joueur joueur){
        Projectile couteau = new Projectile ("couteau",joueur.getX(),joueur.getY(),0,0,10,10,joueur.getId(),25,System.currentTimeMillis());
    }
    
}
