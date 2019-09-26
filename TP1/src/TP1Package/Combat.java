package TP1Package;

public class Combat {
    public static void main (String [] args){
        Personnage p1 = new Personnage("Chelton", 100, 75, 35);
        Personnage p2 = new Personnage("Axel", 100, 60, 50);
        p1.lutteR(p2);
    }
}

