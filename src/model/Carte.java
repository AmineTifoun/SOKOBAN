package model;
import vuetexte.*;
import java.util.ArrayList;

public class Carte {
    public int width ; 
    public int height ; 
    public ArrayList<StringBuilder> plan ; 

    public Carte ( int width , int height , String nomMap ){
        this.width = width ;
        this.height = height;
        this.plan = new ArrayList<StringBuilder>(width);
        Lecture Lec = new Lecture(nomMap);
        setPlan(Lec.getListLigne());
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
        StringBuilder col = this.plan.get(y);
        col.setCharAt(x, C);
    }
    public String toString(){
        System.out.println(plan);
        StringBuilder temp = new StringBuilder();
        for( StringBuilder a  : this.plan){
                temp.append(a);
                temp.append('\n');
        }
        
        return temp.toString();
    }
}

