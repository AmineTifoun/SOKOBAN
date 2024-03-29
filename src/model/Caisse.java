package model;

import java.util.ArrayList;
import java.awt.* ;
public class Caisse extends Pion implements Deplacable  {
   

    public Caisse ( int x , int y){
        super(x,y);
        this.symbole = SYMBOLE.CAISSE ;
    }


    public ArrayList<Point> goRight(int depX , int depY , ArrayList<StringBuilder> plan , ArrayList<ArrayList<Pion>> cartes){
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX , depY+1);
        if( ! Depimpossible(depX, depY+1, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depX);
            ArrayList<Pion> ligne_carte = cartes.get(depX);
            ligne_carte.set(depY,(Pion) new Chemin(depX , depY ));
            tmp.setCharAt(depY, SYMBOLE.CHEMIN.getCaractere());
            this.setPosition(new Point(depX , depY+1));
            ligne_carte.set(depY+1, this);
            tmp.setCharAt(depY+1, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }
    public ArrayList<Point> goUp(int depX , int depY , ArrayList<StringBuilder> plan , ArrayList<ArrayList<Pion>> cartes){
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX-1 , depY);
        if( ! Depimpossible(depX-1, depY, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depX);
            ArrayList<Pion> ligne_carte = cartes.get(depX);
            ligne_carte.set(depY,(Pion) new Chemin(depX , depY ));
            tmp.setCharAt(depY, SYMBOLE.CHEMIN.getCaractere());
            tmp = plan.get(depX-1);
            ligne_carte = cartes.get(depX-1);
            this.setPosition(new Point(depX-1 , depY));
            ligne_carte.set(depY, this);
            tmp.setCharAt(depY, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }

    public ArrayList<Point> goDown(int depX , int depY , ArrayList<StringBuilder> plan , ArrayList<ArrayList<Pion>> cartes){
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX-1 , depY);
        if( ! Depimpossible(depX-1, depY, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depX);
            ArrayList<Pion> ligne_carte = cartes.get(depX);
            ligne_carte.set(depY,(Pion) new Chemin(depX , depY ));
            tmp.setCharAt(depY, SYMBOLE.CHEMIN.getCaractere());
            tmp = plan.get(depX+1);
            ligne_carte = cartes.get(depX+1);
            this.setPosition(new Point(depX+1 , depY));
            ligne_carte.set(depY, this);
            tmp.setCharAt(depY, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }


    public ArrayList<Point> goLeft(int depX , int depY , ArrayList<StringBuilder> plan , ArrayList<ArrayList<Pion>> cartes){
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX , depY-1);
        if( ! Depimpossible(depX, depY-1, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depX);
            ArrayList<Pion> ligne_carte = cartes.get(depX);
            ligne_carte.set(depY,(Pion) new Chemin(depX , depY ));
            tmp.setCharAt(depY, SYMBOLE.CHEMIN.getCaractere());
            this.setPosition(new Point(depX , depY-1));
            ligne_carte.set(depY-1, this);
            tmp.setCharAt(depY-1, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }

    public boolean Depimpossible( int xdest , int ydest , ArrayList<StringBuilder> plan){
        char c = plan.get(xdest).charAt(ydest);
            return c == '#' || c == '/' || c=='$';
        }

    
    
}
