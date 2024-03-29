package model ;
import java.awt.Point ;


public abstract class NonDeplacable extends Pion{
    protected SYMBOLE caractere ; 

    public NonDeplacable( int x , int y){
        super(x , y);
    }


    public abstract boolean PlayerOnMe();
    public abstract boolean CaisseOnMe();

    @Override
    public String toString(){
        return this.caractere.toString();
    }

}