package model;

public class Murs extends NonDeplacable{
    public Murs (int x , int y){
        super(x,y);
        this.symbole = SYMBOLE.MURS ;
    }

    public boolean PlayerOnMe(){
        return false;
    }

    public boolean CaisseOnMe(){
        return false ;
    }
}

