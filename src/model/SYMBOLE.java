package model;
public enum SYMBOLE {
    MURS('#'),VIDE('/'),ROBOT('@'),CAISSE('$') , DESTINATION('.') , ROBOT_DEST('+') , CHEMIN(' ');
    private final char caractere ;

    private SYMBOLE( char caractere){
        this.caractere = caractere;
    }

    public char  getCaractere(){
        return this.caractere;
    }

    public SYMBOLE fromChar( char c){
        for ( SYMBOLE a : SYMBOLE.values()){
            if ( a.getCaractere() == c){
                return a ;
            }
        }
        return null ;
    }
}