import java.util.Scanner;

public class Joueur {

	public String nom;
	public Scanner scanReponse= new Scanner(System.in);
	
	public Joueur() {
		this.nom = "Anonyme";
		System.out.println("Quel est ton nom ?");
		this.nom = scanReponse.next();
	}
	public void setName(String n) {
		this.nom=n;	
	}
	public void finish() {
		this.scanReponse.close();
	}
	public int largeur() {
		System.out.println("Donnez la largeur du plateau");
		return scanReponse.nextInt();
	}
	public int hauteur() {
		System.out.println("Donnez la hauteur du plateau");
		return scanReponse.nextInt();
	}
	public int mines() {
		System.out.println("Donnez le nombre de mines");
		return scanReponse.nextInt();
	}
	public boolean vouloirJouer() {
		System.out.println("Voulez vous jouer? oui ou non ?");
		String reponse = scanReponse.next();
		return (reponse.equals("oui"));
	}
	public boolean continuerJouer() {
		System.out.println("Voulez vous continuer à jouer? oui ou non ?");
		String reponse = scanReponse.next();
		return (reponse.equals("oui"));
	}
	public int abcisse() {
		System.out.println("En quelle position x ?");
		return scanReponse.nextInt();
		
		}
	public int ordonnee() {
		System.out.println("En quelle position y ?");
		return scanReponse.nextInt();
	}
	public boolean voulezVousPoserDrapeau() {
		System.out.println("Voulez poser un drapeau ? oui ou non ");
		String reponse = scanReponse.next();
		return (reponse.equals("oui"));
	}
}
