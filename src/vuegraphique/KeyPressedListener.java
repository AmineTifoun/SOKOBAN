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
        switch (direction) {
            case KeyEvent.VK_LEFT:
                this.carte.deplacer('q');
                this.vue.UpdateGrille();
                
                break;
            case KeyEvent.VK_RIGHT:
                this.carte.deplacer('d');
                this.vue.UpdateGrille();
               
                break ;
            case KeyEvent.VK_UP:
                this.carte.deplacer('z');
                this.vue.UpdateGrille();
                
                break ;
            case KeyEvent.VK_DOWN:
                this.carte.deplacer('s');
                this.vue.UpdateGrille();
                break;
        
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
