package model;
import java.awt.Point;
import java.util.ArrayList;

public interface  Deplacable{
    public ArrayList<Point> goLeft(int xdep , int ydep ,  ArrayList<StringBuilder> plan, ArrayList<ArrayList<Pion>> cartes);
    public ArrayList<Point> goRight(int xdep , int ydep,ArrayList<StringBuilder> plan, ArrayList<ArrayList<Pion>> cartes );
    public ArrayList<Point> goUp(int xdep , int ydep ,ArrayList<StringBuilder> plan, ArrayList<ArrayList<Pion>> cartes);
    public ArrayList<Point> goDown(int xdep , int ydep , ArrayList<StringBuilder> plan, ArrayList<ArrayList<Pion>> cartes );
    public boolean Depimpossible( int xdest , int ydest , ArrayList<StringBuilder> plan);
}
