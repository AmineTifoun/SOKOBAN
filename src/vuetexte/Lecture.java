package vuetexte;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Lecture {
    private ArrayList<StringBuilder> list_ligne  ; 
    private int nb_lignes = 0;
    private int taille = 0;

    public Lecture ( String Nomfichier ){
        this.list_ligne = new ArrayList<>();
        try{
            FileReader file = new FileReader("C:/Users/amine/OneDrive/Bureau/SOKOBAN/doc/map/"+Nomfichier);
            BufferedReader buffer = new BufferedReader(file);
            StringBuilder Line = new StringBuilder();
            String Content = buffer.readLine();
            Line.append(Content);
            this.setTaille(Line.length());
            while( Content != null){
                this.nb_lignes++;
                list_ligne.add(Line);
                Line =  new StringBuilder();
                Content = buffer.readLine();
                    if( Content != null){ 
                    Line.append(Content);
                    }
            }
        
            buffer.close() ;
        }catch(IOException e){
            System.out.println(e);
        }
    }

    
    public ArrayList<StringBuilder>  getListLigne(){
        return this.list_ligne;
    }

    public void setTaille( int taille){
        this.taille = taille ;
    }

    public String toString(){
       StringBuilder tmp = new StringBuilder();
       for( StringBuilder a : this.list_ligne){
        tmp.append(a.toString());
        tmp.append('\n');
       }
       return tmp.toString();
    }


  


    public int getNb_lignes() {
        return nb_lignes;
    }


    public int getTaille() {
        return taille;
    }
    
}
