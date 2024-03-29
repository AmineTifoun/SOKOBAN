package vuetexte;

import java.io.IOException;

public class Outil {

public static char lireCaractere(){
    int rep= ' ';
    int buf;
    try{
        System.out.println("_");
        rep = System.in.read();
        buf = rep;
        while (buf != '\n')
            buf = System.in.read();
        System.out.println("_");    
    } 
    catch (IOException e) {};
    return (char) rep;
}
}