public class Levenshtein {

    public static int distance(String a, String b) {
        a = a.toLowerCase(); //Met a en minuscule
        b = b.toLowerCase(); //Met b en minuscule
        // i == 0           //Pour la première lettre de chaque mot
        int [] costs = new int [b.length() + 1]; //Création d'un tableau de coûts (distance entre les mots)
        for (int j = 0; j < costs.length; j++)  // Boucle for qui insère dans le tableau j 1, 2, 3, 4 ... b.length (taille de la String b)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }

    public static void main(String [] args) {
        String [] data = { "kitten", "sitting", "saturday", "sunday", "rosettacode", "raisethysword" };
        for (int i = 0; i < data.length; i += 2)
            System.out.println("distance(" + data[i] + ", " + data[i+1] + ") = " + distance(data[i], data[i+1]));
    }
}
