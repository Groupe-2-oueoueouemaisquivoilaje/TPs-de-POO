public class Jeu {
	public Joueur joueur;
	public Plateau plateau;

	public Jeu(Joueur a, int l,int h, int m) {
		this.joueur=a;
		this.plateau=new Plateau(l,h,m);
	}

	public void jouer() {
		while(!this.plateau.jeuGagne() && !this.plateau.jeuPerdu()) {
			this.plateau.affichage();
			System.out.println("");
			if(this.joueur.voulezVousPoserDrapeau()) {
				
				int x=this.joueur.abcisse();
				int y=this.joueur.ordonnee();
				if(this.plateau.verifCoordonnees(x, y)) {
					this.plateau.drapeauCase(x, y);
				}
				else {
					System.out.println("Vos coordonnées ne sont pas comprises dans le plateau");
				}

			}
			else {
				System.out.println("Quelle case vous voulez vous révélez ?");
				
				int abs=this.joueur.abcisse();
				int ord=this.joueur.ordonnee();
				if(this.plateau.verifCoordonnees(abs, ord)) {
					this.plateau.revelerCase(abs,ord);
				}
				else {
					System.out.println("Vos coordonnées ne sont pas comprises dans le plateau");
				}
			}
		}
		if(this.plateau.jeuGagne()) {
			System.out.println("Bravo vous avez gagné, vous etes trop fort");
		}
		else {
			System.out.println("Dommage vous avez perdu car vous avez explosé une mine");
		}

	}
}
