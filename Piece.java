public class Piece{
  private boolean couleur; //Blanche = false Noire = true
  private String name;

  public Piece(boolean c, String n){
    couleur = c;
    name = n;
  }

  String getName(){return name;}
  boolean getCouleur(){return couleur;}

  int valeurAbsolue(int x){
    if (x < 0){
      return -x;
    }
    return x;
  }

  boolean mange(Deplacement d, Plateau p){
    if (this.couleur) {
      System.out.println(name + " noir(e) mange " + p.getTab()[d.y0][d.y1].getPiece() + " !");
      p.videCase(d.y0, d.y1);
      p.remplirCase(d.y0, d.y1, this);
      p.videCase(d.x0, d.x1);
      return true;
    } System.out.println(name + " blanc(he) mange " + p.getTab()[d.y0][d.y1].getPiece() + " !");
    p.videCase(d.y0, d.y1);
    p.remplirCase(d.y0, d.y1, this);
    p.videCase(d.x0, d.x1);
    return true;
  }

  boolean estValide(Deplacement d, Plateau p){
    if (!p.horsLimite(d)){
      return true;
    }
    return false;
  }

  public String toString(){
    if (couleur){
      return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    } else
      return Character.toLowerCase(name.charAt(0)) + name.substring(1);
  }
}
