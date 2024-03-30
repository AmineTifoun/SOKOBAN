package vuegraphique;
import model.Carte;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;;

public class KeyPressedListener implements KeyListener {
    private Carte carte ;
    private VueSokoban vue ; 
    
    

    public KeyPressedListener(Carte carte , VueSokoban Vue) {
        this.carte = carte;
        this.vue = Vue ;
    }

    @Override
    public void keyPressed( KeyEvent e){
        System.out.println(this.carte);
        int direction = e.getKeyCode();
        int depReussi = 0 ;
        if( ! this.carte.findepartie()){
        switch (direction) {
            case KeyEvent.VK_LEFT:
                depReussi= this.carte.deplacer('q');
                this.vue.UpdateGrille();
                
                break;
            case KeyEvent.VK_RIGHT:
                depReussi= this.carte.deplacer('d');
                this.vue.UpdateGrille();
               
                break ;
            case KeyEvent.VK_UP:
                depReussi= this.carte.deplacer('z');
                System.out.println(depReussi);
                this.vue.UpdateGrille();
                
                break ;
            case KeyEvent.VK_DOWN:
                depReussi= this.carte.deplacer('s');
                this.vue.UpdateGrille();
                break;
        
            default:
                break;
            }
        if(depReussi == 1){
                 this.vue.setScore( 1+this.vue.getScore());
            }
  
        }else{
            JFrame finalite = new JFrame();
            JPanel plan = new JPanel( new BorderLayout());
            JLabel Label = new JLabel("BRAVO !! TOUTES LES DESTINATIONS SONT ROMPLIES  \n");
            JLabel label = new JLabel("<html>ET VOUS AVEZ EFFECTUÉ <font color='red'>" + this.vue.getScore() + "     </font> DÉPLACEMENTS.</html>");
            plan.add(Label , BorderLayout.NORTH);
            plan.add(label);
            plan.setBackground(Color.CYAN);
            finalite.getContentPane().add(plan);
            finalite.setSize(360 , 75);
            finalite.setTitle("PARTIE FINIE");
            finalite.setVisible(true);
        }
        
    }

    public void updateListener( Carte carte){
        this.carte = carte ;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
