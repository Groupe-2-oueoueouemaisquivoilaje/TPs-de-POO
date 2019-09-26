public class Lanceur {

	public static void main(String []args) {

		boolean run;
		Joueur a = new Joueur();	// le constructeur demandera le nom
		run=a.vouloirJouer();
		int hauteur;
		int largeur;
		int nbMines;

		while(run) {
			largeur=a.largeur();
			hauteur=a.hauteur();
			nbMines=a.mines();
			Jeu demineur = new Jeu(a,largeur,hauteur,nbMines);
			demineur.jouer();
			run = a.continuerJouer();
		}
		a.finish();
		System.out.println("Au revoir");
	}
}
