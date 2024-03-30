package model;
import java.util.*;
import java.awt.*;

public class Robot extends Pion implements Deplacable { 
    private char direction = 'z';/* vers le haut  */
    public Robot ( String  map){
    
       switch(map){
        case "map1.txt":
            this.POINT = new Point(4, 6);
            break;
        case "map2.txt":
            this.POINT = new Point(9 , 13);
            break;
        case "map3.txt":
            this.POINT = new Point(9,6);
            break;
        default:
            this.POINT = new Point(0,0);
            break;
        }
        this.symbole = SYMBOLE.ROBOT;
    }

    public char getDirection() {
        return direction;
    }

    public ArrayList<Point> goLeft(int depX , int depY , ArrayList<StringBuilder> plan , ArrayList<ArrayList<Pion>> cartes){
        this.direction='q';
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX , depY-1);
        if( this.PushPossible(depX, depY-1, plan)){
            Caisse caisse =(Caisse) cartes.get(depX).get(depY-1) ;
            caisse.goLeft(depX, depY-1, plan , cartes);
        }
        if( ! Depimpossible(depX, depY-1, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depX);
            ArrayList<Pion> ligne_carte = cartes.get(depX);
            ligne_carte.set(depY,(Pion) new Chemin(depX , depY-1 ));
            tmp.setCharAt(depY, SYMBOLE.CHEMIN.getCaractere());
            this.setPosition(new Point(depX , depY-1));
            ligne_carte.set(depY-1, this);
            tmp.setCharAt(depY-1, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }
    public void setPosition(Point position) {
        this.POINT = position;
    }

    public ArrayList<Point> goRight(int depX , int depY , ArrayList<StringBuilder> plan , ArrayList<ArrayList<Pion>> cartes){
        this.direction='d';
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX , depY+1);
        if( this.PushPossible(depX, depY+1, plan)){
            Caisse caisse =(Caisse) cartes.get(depX).get(depY+1) ;
            caisse.goRight(depX, depY+1, plan, cartes);
        }
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
        this.direction = 'z';
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX-1 , depY);
        if( this.PushPossible(depX-1, depY, plan)){

            Caisse caisse =(Caisse) cartes.get(depX-1).get(depY) ;
            caisse.goUp(depX-1, depY , plan , cartes);


        }
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
        this.direction ='s';
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX+1 , depY);
        if( this.PushPossible(depX+1, depY, plan)){
            Caisse caisse =(Caisse) cartes.get(depX+1).get(depY) ;
            caisse.goDown(depX+1, depY , plan , cartes);
        }
        if( ! Depimpossible(depX+1, depY, plan)){
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



    public boolean Depimpossible( int xdest , int ydest , ArrayList<StringBuilder> plan){
        char c = plan.get(xdest).charAt(ydest);
            return c == '#' || c == '/' || c =='$' ;
        }

    public boolean PushPossible ( int x , int y , ArrayList<StringBuilder> plan ){
        char c = plan.get(x).charAt(y);
        return c =='$';

    }

    public Point getPosition() {
        return this.POINT;
    }

    public ArrayList<Point> caisseAdjacente(ArrayList<StringBuilder> plan){
        ArrayList<Point> caisses = new ArrayList<Point>();
        Point p ;
        for (int i =-1 ; i< 2 ; i++){
            for (int j = -1 ; j<2 ; j++){
                StringBuilder tmp = plan.get((int) this.POINT.getX()+i);    
                if(tmp.charAt((int) this.POINT.getY()+j) == SYMBOLE.CAISSE.getCaractere() ){
                        p = new Point((int) this.POINT.getX()+i , (int) this.POINT.getY()+j );
                        caisses.add(p);
                }
            }
        }
        return caisses ;
    }

    public void pousser( ){
        


    }
    public SYMBOLE getSymbole() {
        return symbole;
    }

    
}
