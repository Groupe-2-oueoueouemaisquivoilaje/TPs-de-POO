public class Livre extends Media {
    private String auteur;
    private int nbPages;

    public Livre (String n, String a, int nb){
        super(n);
        auteur = a;
        nbPages = nb;
    }

    boolean plusPetit(Media doc){
        if (!(doc instanceof Livre)) return false;
        return idmed < doc.idmed;
    }

    public String toString(){
        return this.idmed + " : " + this.titre + "\nAuteur(ice) : " + auteur + "\nNombre de pages : " + nbPages;
    }
}
