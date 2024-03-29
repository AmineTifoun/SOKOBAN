package model;
import java.util.*;
import java.awt.*;

public class Robot implements Deplacable {
    private SYMBOLE symbole ; 
    private Point position ; 

    public Robot ( String  map){
       switch(map){
        case "map1.txt":
            position = new Point(4, 6);
            break;
        case "map2.txt":
            position = new Point(9 , 13);
            break;
        case "map3.txt":
            position = new Point(9,6);
            break;
        default:
            position = new Point(0,0);
            break;
        }
        this.symbole = SYMBOLE.ROBOT;
    }

    public ArrayList<Point> goLeft(int depX , int depY , ArrayList<StringBuilder> plan){
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX , depY-1);
        if( ! Depimpossible(depX, depY-1, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depX);
            tmp.setCharAt(depY, ' ');
            tmp = plan.get(depX);
            tmp.setCharAt(depY-1, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }
    public void setPosition(Point position) {
        this.position = position;
    }

    public ArrayList<Point> goRight(int depX , int depY , ArrayList<StringBuilder> plan){
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX , depY+1);
        if( ! Depimpossible(depX, depY+1, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depX);
            tmp.setCharAt(depY, ' ');
            tmp = plan.get(depX);
            tmp.setCharAt(depY+1, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }
    public ArrayList<Point> goUp(int depX , int depY , ArrayList<StringBuilder> plan){
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX-1 , depY);
        if( ! Depimpossible(depX-1, depY, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depX);
            tmp.setCharAt(depY, ' ');
            tmp = plan.get(depX-1);
            tmp.setCharAt(depY, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }
    public ArrayList<Point> goDown(int depX , int depY , ArrayList<StringBuilder> plan){
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX+1 , depY);
        if( ! Depimpossible(depX+1, depY, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depX);
            tmp.setCharAt(depY, ' ');
            tmp = plan.get(depX+1);
            tmp.setCharAt(depY, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }



    public boolean Depimpossible( int xdest , int ydest , ArrayList<StringBuilder> plan){
        char c = plan.get(xdest).charAt(ydest);
            return c == '#' || c == '/';
        }

    public Point getPosition() {
        return position;
    }

    public SYMBOLE getSymbole() {
        return symbole;
    }

    
}
