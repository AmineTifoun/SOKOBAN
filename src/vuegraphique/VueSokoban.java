package vuegraphique;
import model.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.*;
import java.net.URI;

public class VueSokoban {
    private Carte carte ;
    private JFrame window ;
    
   

    public VueSokoban(String map) {
        this.carte = new Carte(map);
        setCarte();
        
    } 

    public void setCarte() {
        window = new JFrame();
        window.getContentPane().add(setGrille());
        window.setTitle("SOKOBAN");
        window.pack(); // Ajuster automatiquement la taille de la fenêtre
        window.setVisible(true);
        window.addKeyListener(new KeyPressedListener(carte , this));
        window.requestFocusInWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public JPanel setGrille (){
        JPanel inside = new JPanel(new GridBagLayout());
        for (int i = 0; i < this.carte.getHeight(); i++) {
            StringBuilder ligne = this.carte.getPlan().get(i);
            for (int j = 0; j < this.carte.getWidth(); j++) {
                JLabel btn = setImage(ligne.charAt(j));
                btn.setPreferredSize(new Dimension(30, 30));
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = j; // Position de la colonne dans la grille
                gbc.gridy = i; // Position de la ligne dans la grille
                gbc.fill = GridBagConstraints.BOTH; // Remplissage des composants dans les deux directions
                gbc.weightx = 1.0; // Poids horizontal pour que les colonnes soient également réparties
                gbc.weighty = 1.0; // Poids vertical pour que les lignes soient également réparties
                inside.add(btn, gbc); // Ajout du bouton avec les contraintes spécifiées
            }
        }
        
        inside.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        return inside ;
    }


    public void UpdateGrille() {
        JPanel inside = (JPanel) this.window.getContentPane().getComponent(0);
        inside.removeAll();
        for (int i = 0; i < this.carte.getHeight(); i++) {
            StringBuilder ligne = this.carte.getPlan().get(i);
            for (int j = 0; j < this.carte.getWidth(); j++) {
                JLabel btn = setImage(ligne.charAt(j));
                btn.setPreferredSize(new Dimension(30, 30));
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = j; // Position de la colonne dans la grille
                gbc.gridy = i; // Position de la ligne dans la grille
                gbc.fill = GridBagConstraints.BOTH; // Remplissage des composants dans les deux directions
                gbc.weightx = 1.0; // Poids horizontal pour que les colonnes soient également réparties
                gbc.weighty = 1.0; // Poids vertical pour que les lignes soient également réparties
                inside.add(btn, gbc); // Ajout du bouton avec les contraintes spécifiées
            }
        }
        inside.revalidate(); 
        inside.repaint(); 
    }
    
    public JLabel setImage( char c1){
        JLabel btn ;
        ImageIcon image ;
        switch (c1) {
            case '#':
                image = FindImage("C:/Users/amine/OneDrive/Bureau/SOKOBAN/doc/img/mur.gif");
                break;
            case '$':
                image = FindImage("C:/Users/amine/OneDrive/Bureau/SOKOBAN/doc/img/caisse1.gif");
                break;
            case ' ':
                image = FindImage("C:/Users/amine/OneDrive/Bureau/SOKOBAN/doc/img/sol.gif");
                break;
            case '@':
            case '+':
                switch (this.carte.getRobot().getDirection()) {
                    case 'z':
                        image = FindImage("C:/Users/amine/OneDrive/Bureau/SOKOBAN/doc/img/Haut.gif");
                        break;
                    case 'q':
                        image = FindImage("C:/Users/amine/OneDrive/Bureau/SOKOBAN/doc/img/Gauche.gif");
                        break;
                    case 'd':
                        image = FindImage("C:/Users/amine/OneDrive/Bureau/SOKOBAN/doc/img/Droite.gif");
                        break ;
                    case 's':
                        image = FindImage("C:/Users/amine/OneDrive/Bureau/SOKOBAN/doc/img/Bas.gif");
                        break;
                    default:
                        image = FindImage("C:/Users/amine/OneDrive/Bureau/SOKOBAN/doc/img/Bas.gif");
                        break;
                }
               
                break;
            case '.':
                image = FindImage("C:/Users/amine/OneDrive/Bureau/SOKOBAN/doc/img/but.gif");
                break; 
            default:
                image = null;
                break;

        }
        btn = new JLabel(image);
        return btn;
    }

    public JFrame getWindow() {
        return window;
    }

    public ImageIcon FindImage( String path ){
            ImageIcon file  = new ImageIcon(path);
            return file ;
      
    }

    
    
    
}
