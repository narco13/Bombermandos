/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pdolle
 */
public class ListeProjectiles {
    
    private ArrayList<Projectile> Liste;
    
    public ListeProjectiles() {
        this.Liste = new ArrayList<>();
    }
    
    public void Pull(){
        ArrayList<Projectile> ListeACharger;
        
        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/20182019_s1_vs2_tp1_bomberman?serverTimezone=UTC", "tutur", "bomberman");

            PreparedStatement requete = connexion.prepareStatement("SELECT pseudo, x, y, pv, arme, direction, etat, munitions FROM Projectiles");
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                //this.joueur1.setPseudo(resultat.getString("pseudo"));
                
                
                
                
            }

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
    }
    
    
}
