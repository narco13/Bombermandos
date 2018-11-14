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

    public ArrayList<Projectile> getListe() {
        return Liste;
    }

    public void setListe(ArrayList<Projectile> Liste) {
        this.Liste = Liste;
    }
    
    public void remove(Projectile proj){
        this.Liste.remove(proj);
    }
    
    public void add(Projectile proj){
        this.Liste.add(proj);
    }
    
    
    
    
    public void Pull(){
        ArrayList<Projectile> ListeACharger=new ArrayList();
        Projectile NewProj= new Projectile("erreur",0,0,0,0,0,0,0,0);
        
        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/20182019_s1_vs2_tp1_bomberman?serverTimezone=UTC", "tutur", "bomberman");

            PreparedStatement requete = connexion.prepareStatement("SELECT type,x,y,timer,vitesse x,vitesse y,hauteur,largeur,numero_lanceur FROM Projectiles");
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                NewProj.setType(resultat.getString("type"));
                NewProj.setX(resultat.getInt("x"));
                NewProj.setY(resultat.getInt("y"));
                NewProj.setNaissance(resultat.getLong("timer"));
                NewProj.setVitessex(resultat.getInt("vitesse x"));
                NewProj.setVitessey(resultat.getInt("vitesse y"));
                NewProj.setHauteur(resultat.getInt("hauteur"));
                NewProj.setLargeur(resultat.getInt("largeur"));
                NewProj.setNumero_lanceur(resultat.getInt("numero_lanceur"));
                
                ListeACharger.add(NewProj);
            }

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        this.Liste = ListeACharger;
        
        
        
    }
    
    
    public void Push(){
        
        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/20182019_s1_vs2_tp1_bomberman?serverTimezone=UTC", "tutur", "bomberman");

            
            for(Projectile proj : this.Liste){
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO projectiles VALUES (?,?,?,?,?,NOW())");
            requete.setString(1,proj.getType() );
            requete.setInt(2,proj.getX() );
            requete.setInt(3,proj.getY() );
            requete.setLong(4,proj.getNaissance() );
            requete.setInt(5,proj.getVitessex() );
            requete.setInt(6,proj.getVitessey());
            requete.setInt(7,proj.getHauteur() );
            requete.setInt(8,proj.getLargeur() );
            requete.setInt(9,proj.getNumero_lanceur());

            //System.out.println(requete);
            requete.executeUpdate();
            requete.close();
            }
            

            
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
    }
    
    
}
