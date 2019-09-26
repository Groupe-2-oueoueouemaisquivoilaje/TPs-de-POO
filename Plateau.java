import java.util.Random;

public class Plateau {
	public int hauteur;
	public int largeur;
	public int nbMines;
	public int nbDrapeaux;
	private boolean [][]mines;
	private int [][]etats;	// O:cachés sans drapeau	1:cachés avec drapeau	2: reveler
	private int [][]adja;

	public Plateau(int h, int l, int m) {
		this.hauteur = h;
		this.largeur = l;
		if(m>h*l) {
			this.nbMines=h*l;
		}
		else {
			this.nbMines=m;
		}
		this.mines = new boolean[l+2][h+2];
		this.etats = new int[l+2][h+2];
		this.adja = new int[l+2][h+2];

		this.ajouteMinesAlea();
		this.calculeAdjacence();
	}
	
	private void ajouteMinesAlea(){
		int n=this.nbMines;
		Random random=new Random();
		while(n!=0) {
			int larg=random.nextInt(this.largeur)+1;
			int haut=random.nextInt(this.hauteur)+1;
			if(this.mines[larg][haut]!=true) {
				this.mines[larg][haut]=true;
				n--;
			}
		}
	}

	private void calculeAdjacence() {
		for(int i=1;i<=this.largeur;i++) {
			for(int j=1;j<=this.hauteur;j++) {
				if(this.mines[i][j]==true) {
					this.adja[i-1][j-1]+=1;
					this.adja[i-1][j]+=1;
					this.adja[i-1][j+1]+=1;
					this.adja[i][j-1]+=1;
					this.adja[i][j+1]+=1;
					this.adja[i+1][j-1]+=1;
					this.adja[i+1][j]+=1;
					this.adja[i+1][j+1]+=1;
				}
			}
		}
	}
	public void revelerCase(int l,int h) {
		this.etats[l][h]= 2;
	}
	public void drapeauCase(int l, int h) {
		if(this.etats[l][h]!=2) {
			this.etats[l][h]=1;
			this.nbDrapeaux++;
		}

	}
	public void affichage() {
		System.out.println("*********************");
		System.out.println("*   MINES/DRAPEAUX  *");
		System.out.println("*     "+this.nbMines+"      "+this.nbDrapeaux+"      *");
		System.out.println("*********************");
		System.out.print(" ");
		for(int i=1;i<=this.hauteur;i++) {
			System.out.print(" "+(i));
		}
		System.out.println("");
		System.out.println("");
		for(int i=1; i<=this.largeur;i++) {
			System.out.print(i);
			for(int j=1; j<=this.hauteur;j++) {
				if(this.etats[i][j]==0) {
					System.out.print(" X");
				}
				else if(this.etats[i][j]==1) {
					System.out.print(" ?");
				}
				else {
					if(this.adja[i][j]==0) {
						System.out.print(" .");
					}
					else if (this.mines[i][j]) {
						System.out.print(" B");
					}
					else {
						System.out.print(" "+this.adja[i][j]);
					}
				}
			}
			System.out.println("");
		}
	}

	public boolean jeuPerdu() {
		for(int i=1; i<=this.largeur;i++) {
			for(int j=1; j<=this.hauteur;j++) {
				if(this.etats[i][j]==2 && this.mines[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean jeuGagne() {
		int compteur=0;
		for(int i=1; i<=this.largeur;i++) {
			for(int j=1; j<=this.hauteur;j++) {
				if(this.etats[i][j]!=2) {
					compteur++;
				}
			}
		}
		return(compteur==this.nbMines);
	}
	public boolean verifCoordonnees(int x, int y) {
		if (x<1 || x>this.largeur) {
			return false;
		}
		else if (y<1 || y>this.largeur) {
			return false;
		}
		return true;
	}




}
