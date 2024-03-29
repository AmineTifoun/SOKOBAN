package model ; 

import java.awt.*;

public class Pion {
    protected Point POINT  ; 
    protected SYMBOLE symbole ;

    public Pion( int x , int y){
        this.POINT = new Point(x,y);
    }
    public Pion(){};

    public void setPosition(Point position) {
        this.POINT = position;
    }

    public SYMBOLE getSymbole() {
        return symbole;
    }
}