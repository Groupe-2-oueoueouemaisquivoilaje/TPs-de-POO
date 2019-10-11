public class DictionnaireBilingue extends Dictionnaire {
    private String deuxiemelangue;
    public DictionnaireBilingue(String t, String a, int nbPages, String langue, String langue2, int nbTomes) {
        super(t, a, nbPages, langue, nbTomes);
        deuxiemelangue = langue2;
    }

    public String toString(){
        return this.idmed + " : " + this.titre + "\nAuteur(ice) : " + auteur + "\nNombre de pages : " + nbPages
                + "\nLangues : " + langue + "-" + deuxiemelangue + "\nNombre de tomes : " + nbTomes;
    }
}
