package vuegraphique;
import model.Carte;
import javax.swing.*;
import java.awt.event.*;

public class KeyPressedListener implements KeyListener {
    private Carte carte ;
    private VueSokoban vue ; 
    
    

    public KeyPressedListener(Carte carte , VueSokoban Vue) {
        this.carte = carte;
        this.vue = Vue ;
    }

    @Override
    public void keyPressed( KeyEvent e){
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
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
