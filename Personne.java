package TP1Package;

public class Personne {
    private String nom;
    private String prenom;
    int age;
    int monnaie;

    public Personne(String n, String p, int a, int m){
        nom = n;
        prenom = p;
        age = a;
        monnaie = m;
    }

    public void setPrenom(String p){
        prenom = p;
    }

    public void anniversaire(){
        age++;
    }

    public void setNom(String n){
        nom = n;
    }

    public String toString(){
        return "Je m'appelle : " + prenom + " " + nom + ". J'ai " + age + " ans.";
    }

    boolean donne(Personne p, int montant){
        int tmp = monnaie;
        int tmp2 = p.monnaie;
        monnaie = monnaie - montant;
        p.monnaie = tmp2 + montant;
        if (monnaie == tmp - montant && p.monnaie == tmp2+montant)
            return true;
        return false;
    }
}
