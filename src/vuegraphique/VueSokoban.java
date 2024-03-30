package vuegraphique;
import model.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VueSokoban {
    private Carte carte ;
    private JFrame window ;
    private int Score = 1;
    
   

    public VueSokoban(String map) {
        this.carte = new Carte(map);
        setCarte();
        
    } 

    public void setCarte() {
        window = new JFrame();
        JPanel outside = new JPanel(new BorderLayout());
        JPanel scoreContainer = new JPanel(new BorderLayout());
        JLabel score = new JLabel("Nombre de Deplacement  : " + this.Score);
        scoreContainer.add(score , BorderLayout.WEST);
        scoreContainer.setBackground(Color.WHITE);
        outside.add(scoreContainer , BorderLayout.NORTH);
        outside.add(setGrille());
        window.getContentPane().add(outside);
        window.setTitle("SOKOBAN");
        window.pack(); // Ajuster automatiquement la taille de la fenêtre
        window.setVisible(true);
        window.addKeyListener(new KeyPressedListener(carte , this));
        window.requestFocusInWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
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
        
        inside.setBorder(BorderFactory.createEmptyBorder(20, 50, 50, 50));
        return inside ;
    }


    public void UpdateGrille() {
        JPanel outside = (JPanel) this.window.getContentPane().getComponent(0);
        JPanel scoreCon = (JPanel) outside.getComponent(0);
        JLabel score = (JLabel )scoreCon.getComponent(0);
        score.setText("Nombre de Deplacement  : " + this.Score);
        JPanel inside = (JPanel)outside.getComponent(1);
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
