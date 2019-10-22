import java.util.LinkedList;
import java.util.Scanner;

public class FormateurLimite extends Formateur {
    int taille;
    LinkedList<LinkedList<BoiteComposite>> lis;

    FormateurLimite(String fic, int i){ //Constructeur
        super(fic);
        taille = i;
        lis = new LinkedList<>();
    }

    public void print(){
       if (!lis.isEmpty()){
            int i = 0;
            while(i < lis.size()){
                int j = 0;
                while(j < lis.get(i).size()){
                    System.out.println(lis.get(i).get(j));
                    j++;
                }
                System.out.println();
                i++;
            }
        } else
            System.out.println("Il n'y a rien à formater.");
    }

    public void read() {
            sc.useDelimiter("\n\\s*\n");
            while (sc.hasNext()) { /* tant qu’il reste un paragraphe à lire */
                LinkedList<BoiteComposite> fin = readParagraphe();
                lis.add(fin);
            }
    }

    public LinkedList<BoiteComposite> readParagraphe(){
        BoiteComposite ligne = new BoiteComposite();
        LinkedList<BoiteComposite> paragraphe = new LinkedList<>();
        String para = sc.next();
        Scanner s = new Scanner(para);
        int lon = 0;
        while(s.hasNext()){
            String tmp = s.next();
            lon = ligne.length();
            if (lon + tmp.length() >= taille){
                paragraphe.add(ligne);
                ligne = new BoiteComposite();
            }
            ligne.addBoite(new BoiteMot(tmp));
            //if (ligne.length() + 1 < taille)
            ligne.addBoite(new BoiteEspace());
        }
        paragraphe.add(ligne);
        return paragraphe;
    }

    public void printJustifie(){
        if (!lis.isEmpty()){
            int i = 0;
            while(i < lis.size()){
                int j = 0;
                while(j < lis.get(i).size()-1){
                    System.out.println(lis.get(i).get(j).toString(taille));
                    j++;
                }
                System.out.println(lis.get(i).get(j).toString());
                System.out.println();
                i++;
            }
        } else
            System.out.println("Il n'y a rien à formater.");
    }
}
