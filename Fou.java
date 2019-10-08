public class Fou extends Piece{

  public Fou(boolean c){
    super(c, "Fou");
  }

  boolean estValide(Deplacement d, Plateau p){
    if (!p.horsLimite(d) && super.estValide(d, p)){
      if (d.typeDeplacement() == 'd'){
        if (p.getTab()[d.y0][d.y1].getPiece() == null){
          p.remplirCase(d.y0, d.y1, this);
          return true;
        } else if (p.getTab()[d.y0][d.y1].getPiece().getCouleur() != this.getCouleur()){
          mange(d, p);
        }
      }
      return false;
    }
    return false;
  }
}
