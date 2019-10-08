public class Roi extends Piece{

  public Roi(boolean c){
    super(c, "Roi");
  }

  boolean estValide(Deplacement d, Plateau p) {
    if (!p.horsLimite(d) && super.estValide(d, p)) {
      if (d.dist() == 1 && (d.typeDeplacement() == 'v' || d.typeDeplacement() == 'h' || d.typeDeplacement() == 'd')) {
        if (p.getTab()[d.y0][d.y1].getPiece() != null) {
          if (p.getTab()[d.y0][d.y1].getPiece().getCouleur() != this.getCouleur()) {
            mange(d, p);
            return true;
          }
          return false;
        } else {
          p.remplirCase(d.y0, d.y1, this);
          p.videCase(d.x0, d.x1);
          return true;
        }
      }
      return false;
    }
    return false;
  }
}
