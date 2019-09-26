import TP1Package.Personne;

public class Test {
        public static void main(String[]args) {
            //Exercice 1
            //Question 1
            //Le type d'entrée de la fonction Main est un tableau d'argument et celle ci ne renvoie rien (elle est de type void)
            //Question 2
            int arg = 0;
            for (int i = 0; i < args.length; i++){
                arg++;
            }
            System.out.println(arg);
            //Question 3
            String bip = "HELLO";
            System.out.println(bip.toLowerCase());
            //Question 4
            //La fonction hypot appartient à la classe Math et renvoie la racine carrée de la somme des carrées de
            //ses arguments.
            System.out.println(Math.hypot(2, 5)); //Fait d'abord le carré de 2 (4) puis le carré de 5 (25), les additionne
                                                 //et renvoie leur somme (29) puis renvoie la racine carrée de celle ci avant
                                                 // de l'afficher.
            //Exercice 2
            //Question 1
            int [] a = {3, 8, 9};

        }
}
