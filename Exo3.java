package TP1Package;

public class Exo3 {

    static String shift(String a){
        String nouv = "";
        a = a.toLowerCase();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'a')
                nouv = nouv + 'e';
            else if (a.charAt(i) == 'e')
                nouv = nouv + 'i';
            else if (a.charAt(i) == 'i')
                nouv = nouv + 'o';
            else if (a.charAt(i) == 'o')
                nouv = nouv + 'u';
            else if (a.charAt(i) == 'u')
                nouv = nouv + 'y';
            else if (a.charAt(i) == 'y')
                nouv = nouv + 'a';
            else
                nouv = nouv + a.charAt(i);
        }
        String fin = nouv.substring(0, 1).toUpperCase() + nouv.substring(1);
        return fin;
    }

    public static void main (String [] args){
        String s = "";
        if (args.length != 0){
            for (int i = 0; i < args.length; i++) {
                s = s + args[i] + " ";
            }
        }
        System.out.println((shift(s)));
    }
}
