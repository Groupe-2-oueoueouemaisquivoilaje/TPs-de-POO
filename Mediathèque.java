import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.ArrayList;

public class Mediathèque {
    private final LinkedList<Media> bdd;
    Mediathèque(){
        bdd = new LinkedList<Media>();
    }

    public void afficher(){
        if (bdd.isEmpty()){
            System.out.println("Votre médiathèque est VIDE");
            return;
        }
        int i = 0;
        while(bdd.get(i) != bdd.getLast()){
            System.out.println(bdd.get(i) + " " + bdd.get(i).ordreMedia());
            System.out.println();
            i++;
        }
        System.out.println(bdd.get(i) + " " + bdd.get(i).ordreMedia());
    }

    void ajouter(Media doc) {
        if (bdd.isEmpty()){
            bdd.add(doc);
        } else {
            Media tmp = bdd.getFirst();
            boolean done = false;
            while (!done && tmp != bdd.getLast()) {
                if (doc.ordreMedia() == tmp.ordreMedia()) {
                    bdd.add(bdd.indexOf(tmp)+1, doc);
                    done = true;
                    triId(doc);
                }
                tmp=bdd.get(bdd.indexOf(tmp)+1);
            }
            if(!done) {
                bdd.add(doc);
                done = true;
            }
        }
    }

    void triId(Media m){
            if(bdd.indexOf(m)+1 < bdd.size()){
                Media suivant = bdd.get(bdd.indexOf(m)+1);
                if(suivant.plusPetit(m) && suivant.ordreMedia() == m.ordreMedia()){
                    Media tempm = m;
                    Media tempsuiv = suivant;
                    int tempdocind = bdd.indexOf(m);
                    int tempprecind = bdd.indexOf(suivant);
                    bdd.remove(m);
                    bdd.remove(suivant);
                    bdd.add(tempdocind, tempsuiv);
                    bdd.add(tempprecind, tempm);
                    triId(bdd.get(tempdocind));
                }
            }
    }

    void tousLesDictionnaires(){
        if(bdd.isEmpty()){
            System.out.println("La médhiathèque est VIDE");
            return;
        }
        Media tmp = bdd.getFirst();
        while (tmp != bdd.getLast()){
            if (tmp instanceof Dictionnaire){
                System.out.println(tmp);
            }
            tmp = bdd.get(bdd.indexOf(tmp)+1);
        }
    }

    ArrayList<Media> recherche(Predicat p){
        Media tmp = bdd.getFirst();
        ArrayList<Media> isTrue = new ArrayList<Media>();
        while(tmp != bdd.getLast()){
            if (p.estVrai(tmp))
                isTrue.add(tmp);
            tmp = bdd.get(bdd.indexOf(tmp)+1);
        }
        return isTrue;
    }


    public static void main (String[]args){
        //Tests toString
        Roman l = new Roman ("SHarry Potter", "JKRowling", 189);
        Dictionnaire d = new Dictionnaire ("Larousse", "Auteur", 468, "Français", 8);
        Manga m = new Manga ("One Piece", "Eichiro Oda", 160);
        Manga m1 = new Manga ("Naruto", "Masashi Kishimoto", 178);
        Dictionnaire d1 = new Dictionnaire("Dico des Enfants", "Julie Laro", 126, "Français", 1);
        DVD dvd = new DVD ("Predestination", "Michael Sprierig", 97);
        Manga m2 = new Manga ("Dragon Ball", "Akira Toriyama", 184);
        Manga m3 = new Manga ("SDemon Slayer", "Koyoharu gotoge", 127);
        Manga m4 = new Manga ("Demon Slayer", "Koyoharu gotoge", 127);
        Mediathèque med = new Mediathèque();
        Mediathèque ne = new Mediathèque();
        //Tests ajouter + afficher
        med.ajouter(l);
        med.ajouter(m);
        med.ajouter(d);
        med.ajouter(m3);
        med.ajouter(m1);
        med.ajouter(dvd);
        med.ajouter(m4);
        med.ajouter(d1);
        med.ajouter(m2);
        /*med.afficher();
        //Test tousLesDictionnaires
        med.tousLesDictionnaires();
        //Tests OrdreMedia*/
        //System.out.println(med.bdd.size());
        //med.afficher();
        //Tests Prédicat
        Predicat p = new EstUnLivre();
        Predicat p1 = new TitreCommenceParS();
        Predicat dos = new Et(p, p1);
        //System.out.println(med.recherche(dos));
        //Test distance
        Predicat apeup = new TitreEstAPeuPres("Demon Layer", 1);
        System.out.println(med.recherche(apeup));

    }
}
