/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Arthur
 */
public class Joueur {
    private static int id;
    private static String pseudo;
    private static int x;
    private static int y;
    private static int pv;
    private static String arme;
    private static int direction;
    private static int etat;
    private static int munition;

    /*constructeur*/
    public Joueur(int id, String pseudo, int x, int y, int pv, String Arme, int direction, int etat, int munition) {
        this.id = id;
        this.pseudo = pseudo;
        this.x = x;
        this.y = y;
        this.pv = pv;
        this.arme = Arme;
        this.direction = direction;
        this.etat = etat;
        this.munition = munition;
    }

    /*setter*/
    public void setId(int id) {
        this.id = id;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setArme(String arme) {
        this.arme = arme;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setMunition(int munition) {
        this.munition = munition;
    }

    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPv() {
        return pv;
    }

    public String getArme() {
        return arme;
    }

    public int getDirection() {
        return direction;
    }

    public int getEtat() {
        return etat;
    }

    public int getMunition() {
        return munition;
    }
    
    
    //constructeur pour chaque joueur     
    
    public void JoueurDefault(int id) {
        this.id = id;
        this.pseudo = "Libre";
        this.x = 0;
        this.y = 0;
        this.pv = 5;
    }
    
    
    public void Joueur1() {
        this.pseudo = pseudo;
        this.x = 0;
        this.y = 0;
        this.pv = 5;
    }
    
    public void Joueur2() {
        this.pseudo = pseudo;
        this.x = 50;
        this.y = 0;
        this.pv = 5;
    }
    
    public void Joueur3() {
        this.pseudo = pseudo;
        this.x = 0;
        this.y = 50;
        this.pv = 5;
    }
    
    public void Joueur4() {
        this.pseudo = pseudo;
        this.x = 50;
        this.y = 50;
        this.pv = 5;
    }
    
     public void deplacerEst(){
        this.x = this.x +1;
        this.direction = 1;
    }
    public void deplacerOuest(){
        this.x=this.x+1;
        this.direction = 2;
    }
    public void deplacerHaut(){
        this.y= this.y-1;
        this.direction = 3;
    }      
    public void deplacerBas(){
        this.y= this.y+1;
        this.direction = 4;
    }
    
    public void Push(){
        
        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/20182019_s1_vs2_tp1_bomberman?serverTimezone=UTC", "tutur", "bomberman");

            PreparedStatement requete = connexion.prepareStatement("UPDATE joueur SET pseudo = ?, x = ?, y = ?, pv = ?, arme = ?, etat = ?, direction = ?, munitions = ? WHERE id = ?");
            requete.setString(1,this.pseudo );
            requete.setInt(2,this.x );
            requete.setInt(3,this.y );
            requete.setInt(4,this.pv );
            requete.setString(5,this.arme );
            requete.setInt(6,this.etat );
            requete.setInt(7,this.direction );
            requete.setInt(8,this.munition );
            requete.setInt(9,this.id);

            System.out.println(requete);
            requete.executeUpdate();

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}