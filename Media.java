public class Media {
    protected final String titre;
    protected int idmed;

    private static int id = 0;

    public Media(String n){
        titre = n;
        this.idmed = id;
        id++;
    }

    public String getTitre(){return titre;}
    public int getNumero(){return idmed;}

    public String toString(){
        return idmed + " : " + titre;
    }

    boolean plusPetit(Media doc){ return idmed < doc.idmed; }

    boolean plusPetit(Livre doc){
        if (!(doc instanceof Livre)) return false;
        return idmed < doc.idmed;
    }

    int ordreMedia(){
        if (this instanceof Roman) return 2;
        if (this instanceof LightNovel) return 6;
        if (this instanceof Manga) return 5;
        if (this instanceof BandeDessinee) return 7;
        if (this instanceof Livre) return 1;
        if (this instanceof Dictionnaire) return 3;
        if (this instanceof DictionnaireBilingue) return 4;
        if (this instanceof DVD) return 8;
        return -1;
    }

    boolean plusPetitOrdre(Media doc){ return ordreMedia() < doc.ordreMedia(); }
}
