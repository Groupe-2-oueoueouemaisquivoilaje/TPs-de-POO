package TP1Package;

public class Informations {
    int vie;
    int force;
    int agilite;

    public Informations(int v, int f, int a){
        vie = v;
        force = f;
        agilite = a;
    }

    public Informations (Informations inf){
        this(inf.vie, inf.force, inf.agilite);
    }

    //Getteurs
    public int getVie(){ return vie; }
    public int getForce(){return force;}
    public int getAgilite(){return agilite;}
    //

    //Setteurs
    void setVie(int v){vie = v;}
    void setAgilite(int a){agilite = a;}
    //

    public String myToString(String dec){
        String rep = dec + "Vie : " + vie + "\n" + dec;
        rep += "Force : " + force + "\n" + dec;
        rep += "Agilité : " + agilite + "\n";
        return rep;
    }

    public String toString(){
        return myToString("\t");
    }
}
