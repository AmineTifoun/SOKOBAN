package model;

public enum SYMBOLE {
    MURS('#'),VIDE('/'),ROBOT('@'),CAISSE('$') , DESTINATION('.') , CHEMIN(' ');
    private final char caractere ;

    private SYMBOLE( char caractere){
        this.caractere = caractere;
    }

    public char  getCaractere(){
        return this.caractere;
    }
}
