package model ;
import java.awt.Point ;


public abstract class NonDeplacable{
    protected SYMBOLE caractere ;
    protected Point POINT = new Point() ; 

    public NonDeplacable( int x , int y){
        POINT.setLocation(x, y);
    }


    public abstract boolean PlayerOnMe();
    public abstract boolean CaisseOnMe();

    @Override
    public String toString(){
        return this.caractere.toString();
    }

}