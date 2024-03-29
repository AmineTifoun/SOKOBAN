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
        clearTermial();
        System.out.println(" **************************  VEUILLEZ INTRODUIRE L'UN DES CARACTERES  Z[z]( HAUT ) Q[q]( BAS ) S[s]( BAS ) D[d]( DROITE )*******************************");
        System.out.println(carte);
        while( ! this.carte.findepartie()){
        System.out.println("SAISISSEZ VOTRE CARACTETRE : \t ");
        char c = Outil.lireCaractere();
        while(carte.deplacer(c) == 0){
            clearTermial();
            System.out.println(carte);
            System.out.println("SAISISSEZ VOTRE CARACTETRE : \t ");
            c=Outil.lireCaractere();
        };
        clearTermial();
        System.out.println(carte);
        }
    }

    public void clearTermial(){
        for ( int i = 0 ; i<500 ; i++){
            System.out.println();
        }
    }

}
