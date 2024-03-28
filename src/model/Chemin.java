package model;

public class Chemin extends NonDeplacable {
    public Chemin( int x , int y){
        super(x,y);
        this.caractere=SYMBOLE.CHEMIN;
    }
    public boolean PlayerOnMe(){
        return true ; /* temp */
    }

    public boolean CaisseOnMe(){
        return true ;
    }

    
}
