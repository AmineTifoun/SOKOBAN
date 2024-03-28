package model;
import vuetexte.*;
import java.util.ArrayList;

public class Carte {
    public int width ; 
    public int height ; 
    public ArrayList<StringBuilder> plan ; 

    public Carte ( String nomMap ){
        Lecture Lec = new Lecture(nomMap);
        this.width = Lec.getTaille() ;
        this.height = Lec.getNb_lignes();
        this.plan = new ArrayList<StringBuilder>(Lec.getTaille());
        setPlan(Lec.getListLigne());/* 6 strings */
        Robot robot = new Robot(nomMap);
        setPlan(robot.getPosition().x , robot.getPosition().y , robot.getSymbole().getCaractere() );
        
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

    public String toString(){
        StringBuilder temp = new StringBuilder();
        for( StringBuilder a  : this.plan){
                temp.append(a);
                temp.append('\n');
        }
        return temp.toString();
    }
}

