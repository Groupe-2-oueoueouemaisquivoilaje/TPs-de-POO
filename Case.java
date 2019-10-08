public class Case{
  private boolean couleur; //Blanche = false Noire = true
  private Piece p;

  public Case(boolean c){
    couleur = c;
    p = null;
  }

  Piece getPiece(){return p;} //Getter
  boolean estVide(){return (p == null);}

  void remplirPiece(Piece pi){if (this.p == null) this.p = pi;}
  void enleverPiece(){if (p != null) p = null;}

  public String toString(){
    String s = "";
    if (p == null){
      if (couleur){
        return "* ";
      }
      return "- ";
    }
    s = p.toString().charAt(0) + " ";
    return s;
  }
}
