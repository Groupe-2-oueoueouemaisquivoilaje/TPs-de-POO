public class Pion extends Piece{

  public Pion(boolean c){
    super(c, "Pion");
  }


  boolean estValide(Deplacement d, Plateau p){
    if (!p.horsLimite(d) && super.estValide(d, p)){
      if (valeurAbsolue(d.x0 - d.y0) == 1) {
        if ((this.getCouleur() && d.x0 > d.y0) || (!this.getCouleur() && d.x0 < d.y0)) {
          if (d.x1 == d.y1) {
            p.remplirCase(d.y0, d.y1, this);
            p.videCase(d.x0, d.x1);
            return true;
          } else if (valeurAbsolue(d.x0 - d.y0) == (valeurAbsolue(d.x1 - d.y1))) {
            if (p.getTab()[d.y0][d.y1].getPiece() != null && p.getTab()[d.y0][d.y1].getPiece().getCouleur() != this.getCouleur())
              mange(d, p);
          }
        }
      }
      return false;
    }
    return false;
  }
}
