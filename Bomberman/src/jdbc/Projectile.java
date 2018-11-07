/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

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
    
    
    
}
