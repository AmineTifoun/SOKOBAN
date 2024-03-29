package model;
import java.awt.*;
public class Destination extends NonDeplacable {
    public Destination( int x , int y){
        super(x,y);
        this.symbole = SYMBOLE.DESTINATION;
    }

    public boolean PlayerOnMe(){
        return true ;
    }

    public boolean CaisseOnMe(){
        return true ;
    }
    public Point getPosition() {
       return this.POINT;
    }

}
