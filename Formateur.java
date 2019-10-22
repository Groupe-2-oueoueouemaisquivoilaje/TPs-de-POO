import java.util.*;
import java.io.*;
public class Formateur {
    protected Scanner sc;
    LinkedList<BoiteComposite> liste;

    public Formateur(String fic) {
        sc = null;
        try {
            sc = new Scanner(new File(fic));
        } catch (Exception e) {
            System.out.println("Erreur lors d?ouverture fichier:");
            e.printStackTrace();
            System.exit(1);
        }
        liste = new LinkedList<BoiteComposite>();
    }

    public void print(){
        if (!liste.isEmpty()){
            int i = 0;
            while(i < liste.size()-1){
                System.out.println(liste.get(i).toString());
                System.out.println();
                i++;
            }
            System.out.println(liste.get(i).toString());
        } else
            System.out.println("Il n'y a rien à formater.");
    }

    public void read() {
        sc.useDelimiter("\n\\s*\n");
        while (sc.hasNext()) { /* tant qu’il reste un paragraphe a lire */
            BoiteComposite p = readParagraphe();
            liste.add(p);
        }
    }

    private BoiteComposite readParagraphe(){
        BoiteComposite paragraphe = new BoiteComposite();
        String para = sc.nextLine(); /* on extrait le paragraphe suivant */
        Scanner s = new Scanner(para); /* on initialise un nouveau scanner sur ce paragraphe */ /* s.useDelimiter("\\s+"); pas n ́ecessaire puisque \\s+ est le d ́elimiteur par d ́efaut */
        while(s.hasNext()){
            paragraphe.addBoite(new BoiteMot(s.next()));
            paragraphe.addBoite(new BoiteEspace());
        }
        return paragraphe;
    }

    public static void main(String[]args){
        /*Formateur f1 = new Formateur("texte"); //Tests Formateur
        f1.read();
        f1.print();*/

        /*FormateurLimite f2 = new FormateurLimite("texte", 80);
        f2.read();
        f2.printJustifie();*/
    }
}
