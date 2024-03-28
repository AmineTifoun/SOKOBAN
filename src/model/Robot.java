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
        if( ! impossible(depX, depY-1, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depY-1);
            tmp.setCharAt(depX, ' ');
            tmp = plan.get(depY-1);
            tmp.setCharAt(depX, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }
    public ArrayList<Point> goRight(int depX , int depY , ArrayList<StringBuilder> plan){
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX , depY+1);
        if( ! impossible(depX, depY+1, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depY+1);
            tmp.setCharAt(depX, ' ');
            tmp = plan.get(depY+1);
            tmp.setCharAt(depX, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }
    public ArrayList<Point> goUp(int depX , int depY , ArrayList<StringBuilder> plan){
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX-1 , depY);
        if( ! impossible(depX-1, depY, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depY);
            tmp.setCharAt(depX, ' ');
            tmp = plan.get(depY);
            tmp.setCharAt(depX-1, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }
    public ArrayList<Point> goDown(int depX , int depY , ArrayList<StringBuilder> plan){
        Point point = new Point(depX , depY);
        ArrayList<Point> dep = new ArrayList<Point>();
        dep.add(point);
        point = new Point(depX+1 , depY);
        if( ! impossible(depX+1, depY, plan)){
            dep.add(point);
            StringBuilder tmp = plan.get(depY);
            tmp.setCharAt(depX, ' ');
            tmp = plan.get(depY);
            tmp.setCharAt(depX+1, this.symbole.getCaractere());
            return dep;
        }
        return null ;
    }

    public boolean impossible( int xdest , int ydest , ArrayList<StringBuilder> plan){
        char c = plan.get(ydest).charAt(xdest);
            return c == '#' || c == '/';
        }

    public Point getPosition() {
        return position;
    }

    public SYMBOLE getSymbole() {
        return symbole;
    }

    
}
