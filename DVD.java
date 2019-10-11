public class DVD extends Media {
    private String auteur;
    private int duree;

    public DVD(String t, String a, int d){
        super(t);
        auteur = a;
        duree = d;
    }

    public String toString(){
        return this.idmed + " : " + this.titre + "\nAuteur(ice) : " + auteur + "\nDurée : " + duree + " minutes";
    }
}
