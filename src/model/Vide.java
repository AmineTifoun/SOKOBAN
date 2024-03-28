package model;

public class Vide extends NonDeplacable{
    public Vide( int x , int y){
        super(x,y);
        this.caractere = SYMBOLE.VIDE;
    }

    public boolean PlayerOnMe(){
        return false ;
    }

    public boolean CaisseOnMe(){
        return false ;
    }
    
}
