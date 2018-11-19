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
    
    private String type;
    private int x;
    private int y;
    private int vitessex;
    private int vitessey;
    private int hauteur;
    private int largeur;
    private int numero_lanceur;
    private long naissance;

    
    /*constructeur*/
    public Projectile(String type, int x, int y, int vitessex, int vitessey, int hauteur, int largeur, int numero_lanceur, long naissance) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.vitessex = vitessex;
        this.vitessey = vitessey;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.numero_lanceur = numero_lanceur;
        this.naissance = naissance;

    }

    public Projectile() {
    }
    
    /*getters*/

    public String getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVitessex() {
        return vitessex;
    }

    public int getVitessey() {
        return vitessey;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getNumero_lanceur() {
        return numero_lanceur;
    }

    public long getNaissance() {
        return naissance;
    }
    
    
    /*setter*/

    public void setType(String type) {
        this.type = type;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVitessex(int vitessex) {
        this.vitessex = vitessex;
    }

    public void setVitessey(int vitessey) {
        this.vitessey = vitessey;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setNumero_lanceur(int numero_lanceur) {
        this.numero_lanceur = numero_lanceur;
    }

    public void setNaissance(long naissance) {
        this.naissance = naissance;
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
    
    public Projectile estCouteau(Projectile proj,Joueur joueur){
        proj = new Projectile("couteau",joueur.getX(),joueur.getY(),0,0,10,10,joueur.getId(),System.currentTimeMillis());
        return proj;
    }
    
    public boolean EstPerime(){
        boolean EstPerime =false;
        
        String type = this.getType();
        
        if (type == "Couteau" && System.currentTimeMillis()-25> this.getNaissance()){
            EstPerime = true;
        }
        
        
        return EstPerime;
    }
    
}
