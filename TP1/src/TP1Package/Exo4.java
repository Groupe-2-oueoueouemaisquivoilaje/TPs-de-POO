package TP1Package;
import java.util.Scanner;
import java.util.Random;

public class Exo4 {

    public static int rand9(){
        Random rd = new Random();

        int r = rd.nextInt(9);
        if (r == 0){
            r = rand9();
        }

        return r;
    }

    public static int question(){
        double  nb1 = rand9(); double nb2 = rand9();
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est le résultat de " + nb1 + " * " + nb2 + " ?");
        String rep = sc.nextLine();
        int tentatives = 1;
        while (Integer.valueOf(rep) != nb1 * nb2 ){
            tentatives++;
            System.out.println("Vous êtes bien sûr ?");
            rep = sc.nextLine();
        }
        return tentatives;
    }

    public static int evaluation (int n){
        int note = n;
                n = n % 20;
        if (n == 0)
            n = 1;
        int i = 0;
        Scanner sc = new Scanner(System.in);
        while (i < n){
            int a = rand9();
            int b = rand9();
            System.out.println("Combien font " + a + " * " + b + " ?");
            int rep = Integer.valueOf(sc.nextLine());
            if (rep != a * b){
                note--;
            }
            i++;
        }
        return (note * 20)/n;
    }

    public static void main (String [] args){
        System.out.println(evaluation(4));
    }
}
