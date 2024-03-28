package model;

public class Destination extends NonDeplacable {
    public Destination( int x , int y){
        super(x,y);
        this.caractere = SYMBOLE.DESTINATION;
    }

    public boolean PlayerOnMe(){
        return true ; /* temp */
    }

    public boolean CaisseOnMe(){
        return true ;
    }

}
