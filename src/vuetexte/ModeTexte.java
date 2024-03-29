package vuetexte;
import model.*;

public class ModeTexte {
    private Carte carte ;
    private String model ; /* nom du niveau */

    public ModeTexte(String model){
        this.model=model;
        carte= new Carte(model);
    }

    public void jouer(){
        System.out.println(carte);
        while(1 != 0){
        char c = Outil.lireCaractere();
        while(carte.deplacer(c) == 0){
            clearTermial();
            System.out.println(carte);
            c=Outil.lireCaractere();
        };
        clearTermial();
        System.out.println(carte);
        }
    }

    public void clearTermial(){
        for ( int i = 0 ; i<70 ; i++){
            System.out.println();
        }
    }

}
