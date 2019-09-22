package TP1Package;

import java.util.Random;

public class Personnage {
    final String nom; //Le nom ne change jamais -> accesseurs et modifieurs inutiles
    private final Informations etatI; //Attention : Le caractère "final" ne protège pas du changement du contenu de l'objet
    private Informations etatA;

    public Personnage(String n, int v, int f, int a){
        nom = n;
        this.etatI = new Informations(v, f, a);
        this.etatA = new Informations(etatI);
    }

    public static int rand(int max, int min){
        Random rd = new Random();
        int r = rd.nextInt(100);
        if (r <= 0)
            rand(max, min);
        return r;
    }


    public boolean estVivant(){
        if (etatA.getVie() > 0)
            return true;
        else
            return false;
    }

    public void rebirth(){
        etatA = etatI;
    }

    void attaque (Personnage def){
        System.out.println(def.etatA.getVie());
        int n = rand(1, Integer.max(1, etatI.getForce() - def.etatI.getForce()));
        if (def.etatA.getAgilite() < this.etatA.getAgilite()){
            def.etatA.setVie(def.etatA.getVie() - n);
        } else if (def.etatA.getAgilite() >= this.etatA.getAgilite()){
            def.etatA.setVie(def.etatA.getVie() - (n/2));
            def.etatA.setAgilite(def.etatA.getAgilite() - def.etatA.getAgilite()/3);
        }
        System.out.println(def.etatA.getVie());
    }

    void lutteI(Personnage p){
        int vit = 0;
        while (p.estVivant() && this.estVivant()){
            vit = p.etatA.getVie();
            int n = rand(1, Integer.max(1, etatI.getForce() - p.etatI.getForce()));
            if (p.etatA.getAgilite() < this.etatA.getAgilite()){
                p.etatA.setVie(p.etatA.getVie() - n);
            } else if (p.etatA.getAgilite() >= this.etatA.getAgilite()){
                p.etatA.setVie(p.etatA.getVie() - (n/2));
                p.etatA.setAgilite(p.etatA.getAgilite() - p.etatA.getAgilite()/3);
            }
            System.out.println(p.nom + " a pris " + (vit - p.etatA.getVie()) + " dégâts !");
            if (!p.estVivant()){
                break;
            } else {
                vit = this.etatA.getVie();
                n = rand(1, Integer.max(1, etatI.getForce() - p.etatI.getForce()));
                if (this.etatA.getAgilite() < p.etatA.getAgilite()){
                    this.etatA.setVie(this.etatA.getVie() - n);
                } else if (this.etatA.getAgilite() >= p.etatA.getAgilite()){
                    this.etatA.setVie(this.etatA.getVie() - (n/2));
                    this.etatA.setAgilite(this.etatA.getAgilite() - this.etatA.getAgilite()/3);
                }
            }
            System.out.println(this.nom + " a pris " + (vit - this.etatA.getVie()) + " dégâts !");
       }
        if (!p.estVivant()){
            System.out.println(p.nom + " est hors combat.");
        } else
            System.out.println(this.nom + " est hors combat.");
    }

    Personnage lutteR(Personnage p){
        int vit = 0;
            vit = p.etatA.getVie();
            int n = rand(1, Integer.max(1, etatI.getForce() - p.etatI.getForce()));
            if (p.etatA.getAgilite() < this.etatA.getAgilite()){
                p.etatA.setVie(p.etatA.getVie() - n);
            } else if (p.etatA.getAgilite() >= this.etatA.getAgilite()){
                p.etatA.setVie(p.etatA.getVie() - (n/2));
                p.etatA.setAgilite(p.etatA.getAgilite() - p.etatA.getAgilite()/3);
            }
            System.out.println(p.nom + " a pris " + (vit - p.etatA.getVie()) + " dégâts !");
            if (!p.estVivant()) {
                System.out.println(p.nom + " est hors combat !");
                return this;
            } else
                return p.lutteR(this);
    }
    Personnage lutteRec(Personnage p){
        if (!this.estVivant()){
            System.out.println(p.nom + " est hors combat !");
            return p;
        } else if (!p.estVivant()) {
            System.out.println(nom + " est hors combat !");
            return this;
        } else {
            return lutteR(p);
        }
    }
}
