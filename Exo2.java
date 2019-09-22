package TP1Package;

public class Exo2 {

    static void affiche(int[] t){
        for (int i = 0; i < t.length; i++){
            System.out.print(" " + t[i]);
        }
    }

    static int [] multiplication(int[] a, int[] b){
        int [] c = new int [Math.max(a.length, b.length)];
        for (int i = 0; i < c.length; i++){
            if (a.length >= b.length){
                if(i >= b.length) {
                    c[i] = a[i];
                } else{
                    c[i] = a[i] * b[i];
                }
            } else if (b.length >= a.length){
                if(i >= a.length) {
                    c[i] = b[i];
                } else {
                    c[i] = a[i] * b[i];
                }
            }
        }
        return c;
    }

    static int [] split(int [] a){
        int size = 0; String nbrs = "";
        for(int i = 0; i < a.length; i++){
            size = size + String.valueOf(a[i]).length();
            nbrs = nbrs + String.valueOf(a[i]);
        }
        int [] fin = new int [size];
        for (int j = 0; j < nbrs.length(); j++) {
            fin[j] = Character.getNumericValue(nbrs.charAt(j));
        }
        return fin;
    }

    public static void main (String [] args){
        int [] a = {3,7,35, 9};
        int [] b = {4, 8,8};
        affiche(multiplication(a, b));
        System.out.println();
        affiche(split(a));
    }
}
