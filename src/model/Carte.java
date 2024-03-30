package model;
import vuetexte.*;
import java.util.*;
import java.awt.*;

public class Carte {
    private int width ; 
    private int height ; 
    private ArrayList<StringBuilder> plan ; /* Tableau dans lequel on recupere la map */
    private ArrayList<ArrayList<Pion>> cartes = new ArrayList<ArrayList<Pion>>() ; /* Carte contenant les object PIONs */
    private ArrayList<Destination> PointsDest ;/* Carte contenant les coordonnees des destinations */
    private Robot robot ;/* robot jouant dans la map */

    public ArrayList<StringBuilder> getPlan() {
        return plan;
    }

    public Carte ( String nomMap ){
        Lecture Lec = new Lecture(nomMap);
        this.width = Lec.getTaille() ;
        this.height = Lec.getNb_lignes();
        this.plan = new ArrayList<StringBuilder>(Lec.getTaille());
        setPlan(Lec.getListLigne());/* 6 strings */
        robot = new Robot(nomMap);
        setPlan(robot.getPosition().x , robot.getPosition().y , robot.getSymbole().getCaractere() );
        ContruireCarte();/* Construction  de la table objet de carte */
        PointsDest = this.PointsArrive(this.width, this.height , plan);/* contient les coordonnées des destinations */
        
    }

    public void setPlan(ArrayList<StringBuilder> b){
      this.plan.clear();
      for ( StringBuilder c : b){
            this.plan.add(c);
      }
    }

    public void setPlan( int x , int y , char C){
        StringBuilder col = this.plan.get(x);
        col.setCharAt(y, C);
    }
    


    public Robot getRobot() {
        return robot;
    }

    public int deplacer(char c){/* Q gauche Z haut D right S ver le bas  */
        Point position = this.robot.getPosition();
        Point nvposition = null;
        ArrayList<Point> positions ;/* Contient lancienne coordonnée et la nouvelle pour pouvoir mettre a jour la carte */
            switch(c){
                case 'q':
                case 'Q':
                    positions = this.robot.goLeft((int) position.getX(),(int) position.getY(),plan , this.cartes);
                    if(positions != null){
                        nvposition =positions.get(1);
                    }
                    break;
                case 'z':
                case 'Z':
                positions =this.robot.goUp((int)position.getX(),(int)position.getY(),plan , this.cartes);
                    if(positions != null){
                        nvposition =positions.get(1);
                    }
                    break;
                case 'd':
                case 'D':
                    positions = this.robot.goRight((int) position.getX(),(int) position.getY(),plan , this.cartes);
                    if(positions != null){
                        nvposition = positions.get(1);
                    };
                    break;
                case 's':
                case 'S':
                    positions = this.robot.goDown((int) position.getX(),(int) position.getY(),plan , this.cartes);
                    if(positions != null){
                        nvposition = positions.get(1);
                    }
                    
                    break;
                default:
                    System.out.println("\tCLIQUEZ SUR Q(GAUCHE) Z(HAUT) D(DROITE) S(BAS)\t");
                    return 0 ;
                    
            }
            if( nvposition == null){
                return 0 ;
            }else{/* deplacement reussi */
                this.robot.setPosition(nvposition);
                if( ROBOTONDEST(nvposition)){/* ROBOT SUR DESTINATION ROBOT CHANGE DE DE SYMBOLE*/
                    setPlan((int) nvposition.getX() , (int) nvposition.getY() , SYMBOLE.ROBOT_DEST.getCaractere());
                }
                if( ROBOTONDEST(position)){/* Robot etait sur DEST ON NE CHANGE PAS LE SSYMBOLE DE DESTINATION*/
                    setPlan((int) position.getX() , (int) position.getY() , SYMBOLE.DESTINATION.getCaractere());
                }
                return 1 ;
            }
        }

    public ArrayList<Destination> PointsArrive(int width , int height , ArrayList<StringBuilder> plan){
        ArrayList<Destination> Points = new ArrayList<Destination>();
        Destination dest ;
        for ( int i =0 ; i< height ; i++){
            for( int j = 0 ; j < width ; j++){
                StringBuilder tmp = plan.get(i);
                if ( tmp.charAt(j) == '.'){
                    dest =  new Destination(i, j); 
                    Points.add(dest);
                }
            }
        }
        return Points ;
    }

    public void ContruireCarte(){
        Pion carte ;
        ArrayList<Pion> ligne_carte = new ArrayList<Pion>() ;
        for ( int i = 0 ; i< this.height ; i++){
            StringBuilder tmp = this.plan.get(i);
            for( int j = 0 ; j<this.width; j++){
                char c = tmp.charAt(j);
                switch(c){
                    case '#':
                        carte = new Murs(i , j);
                        break;
                    case '/':
                        carte = new Vide(i , j);
                        break;
                    case '.':
                        carte = new Destination(i , j);
                        break;
                    case '$':
                        carte = new Caisse(i,j);
                        break;
                    case '@':
                        Pion robot = new Robot("map1.txt");
                        robot.setPosition(new Point(i,j));
                        carte = robot ;
                        break;
                    case ' ':
                        carte = new Chemin(i, j);
                        break;
                    default:
                        carte = new Chemin(i, j);
                }
                ligne_carte.add(carte);
            }
            this.cartes.add(ligne_carte);
            ligne_carte = new ArrayList<Pion>() ;

        }
        
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean findepartie(){
        boolean fin = true ;
        for (Destination p : this.PointsDest){
             ArrayList<Pion> ligne = this.cartes.get((int) p.getPosition().getX());
             Pion c = ligne.get((int) p.getPosition().getY());
             fin = fin &&  c.getSymbole().getCaractere() == '$';
        }
            return fin;
    }

    public boolean ROBOTONDEST( Point point){
        if ( point != null){
            for ( Destination b : this.PointsDest){
                if( point.equals(b.getPosition())){
                    return b.PlayerOnMe();/* Robot sur Case destination*/
                }
            }
        }
            return false ;
        }

    public String toString(){
        StringBuilder temp = new StringBuilder();
        temp.append("\n");
        int consoleWidth = 150; // Largeur de la console, ajustez selon vos besoins
        // Calcul de l'espacement nécessaire pour centrer le texte
        int padding = (consoleWidth - this.plan.size()) / 2;
        for( StringBuilder a  : this.plan){
            // Affiche l'espacement avant le texte pour le centrer
            for (int i = 0; i < padding; i++) {
                temp.append(" ");
            }
                temp.append(a);
                temp.append('\n');
        }
        return temp.toString();
    }

}

