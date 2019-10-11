public class TitreEstAPeuPres extends Predicat {
    private String titre;
    private int distance;

    TitreEstAPeuPres(String ti, int d){
        titre = ti;
        distance = d;
    }

    private static String tailleMin(String s1, String s2){ //Renvoie la chaine de plus petite taille
        if (s1.length() > s2.length()){
            return s2;
        } else
            return s1;
    }

    private static String tailleMax(String s1, String s2){ //Renvoie la chaine de plus grande taille
        if (s1.length() > s2.length()){
            return s1;
        } else
            return s2;
    }

    private static int valeurAbsolue(int x){ //Renvoie la valeur absolue d'un entier
        if (x < 0) return -x;
        return x;
    }

    static int LevenDist(String s, String t){ //Renvoie la distance de Hamming entre deux chaines de caractères
        s = s.toLowerCase();
        t = t.toLowerCase();
        int [] couts = new int [t.length() + 1];
        for (int j = 0; j < couts.length; j++)
            couts[j] = j;
        for (int i = 1; i <= s.length(); i++) {
            couts[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= t.length(); j++) {
                int cj = Math.min(1 + Math.min(couts[j], couts[j - 1]), s.charAt(i - 1) == t.charAt(j - 1) ? nw : nw + 1);
                nw = couts[j];
                couts[j] = cj;
            }
        }
        return couts[t.length()];
    }

    boolean estVrai(Media m){ //Regarde si la distance de Hamming est inférieur ou égale à la distance voulue
        if (LevenDist(m.titre, titre) <= distance)
            return !super.estVrai(m);
        return false;
    }

    public static void main(String[]args){
        System.out.println(LevenDist("Naruto", "SNaruto"));
    }
}
