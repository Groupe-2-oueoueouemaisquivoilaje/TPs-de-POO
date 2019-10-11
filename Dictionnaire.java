public class Dictionnaire extends Media {
    protected String auteur;
    protected int nbPages;
    protected String langue;
    protected int nbTomes;

    public Dictionnaire(String t, String auteur, int nbPages, String langue, int nbTomes) {
        super(t);
        this.auteur = auteur;
        this.nbPages = nbPages;
        this.langue = langue;
        this.nbTomes = nbTomes;
    }

    public String toString(){
        return this.idmed + " : " + this.titre + "\nAuteur(ice) : " + auteur + "\nNombre de pages : " + nbPages
                + "\nLangue : " + langue + "\nNombre de tomes : " + nbTomes;
    }
}
