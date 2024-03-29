package vuetexte;
import model.*;

public class ModeTexte {
    private Carte carte ;
    

    public ModeTexte(String model){
        carte= new Carte(model);
    }

    public void jouer(){
        clearTermial();
        System.out.print("\u001B[31m");
        System.out.println(" **************************  VEUILLEZ INTRODUIRE L'UN DES CARACTERES  Z[z]( HAUT ) Q[q]( BAS ) S[s]( BAS ) D[d]( DROITE )*******************************");
        System.out.print("\u001B[0m");
        System.out.println(carte);
        while( ! this.carte.findepartie()){
        System.out.println("SAISISSEZ VOTRE CARACTETRE : \t ");
        char c = Outil.lireCaractere();
        while(carte.deplacer(c) == 0){
            clearTermial();
            System.out.print("\u001B[31m");
            System.out.println(" **************************  VEUILLEZ INTRODUIRE L'UN DES CARACTERES  Z[z]( HAUT ) Q[q]( BAS ) S[s]( BAS ) D[d]( DROITE )*******************************");
            System.out.print("\u001B[0m");
            System.out.println(carte);
            System.out.println("SAISISSEZ VOTRE CARACTETRE : \t ");
            c=Outil.lireCaractere();
        };
        clearTermial();
        System.out.print("\u001B[31m");
        System.out.println(" **************************  VEUILLEZ INTRODUIRE L'UN DES CARACTERES  Z[z]( HAUT ) Q[q]( BAS ) S[s]( BAS ) D[d]( DROITE )*******************************");
        System.out.print("\u001B[0m");
        System.out.println(carte);
        }

        clearTermial();
        System.out.print("\u001B[32m");
        System.out.println("                                                              [PARTIE FINIE]                                              ");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println();
    }




    public void clearTermial(){
        for ( int i = 0 ; i<200 ; i++){
            System.out.println();
        }
    }

}
