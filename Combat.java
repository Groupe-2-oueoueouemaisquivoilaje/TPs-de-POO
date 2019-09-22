package TP1Package;

public class Combat {
    public static void main (String [] args){
        Personnage p1 = new Personnage("Medine", 100, 60, 35);
        Personnage p2 = new Personnage("Nicolas", 100, 40, 45);
        p1.lutteR(p2);
    }
}

