public class Dame extends Piece{

  public Dame(boolean c) {
    super(c, "Dame");
  }
  boolean estValide(Deplacement d, Plateau p){
    if (!p.horsLimite(d) && super.estValide(d, p)){
      if (d.typeDeplacement() == 'v'){
        if (p.getTab()[d.y0][d.y1].getPiece() == null){
          p.remplirCase(d.y0, d.y1, this);
          p.videCase(d.x0, d.x1);
          return true;
        } else if (p.getTab()[d.y0][d.y1].getPiece().getCouleur() != this.getCouleur() &&
                !p.getTab()[d.y0][d.y1].getPiece().getName().equals("Roi")){
          mange(d, p);
        }
      } if (d.typeDeplacement() == 'd'){
        if (p.getTab()[d.y0][d.y1].getPiece() == null){
          p.remplirCase(d.y0, d.y1, this);
          p.videCase(d.x0, d.x1);
          return true;
        } else if (p.getTab()[d.y0][d.y1].getPiece().getCouleur() != this.getCouleur() &&
                !p.getTab()[d.y0][d.y1].getPiece().getName().equals("Roi")){
          mange(d, p);
        }
      } if (d.typeDeplacement() == 'h'){
        if (p.getTab()[d.y0][d.y1].getPiece() == null){
          p.remplirCase(d.y0, d.y1, this);
          p.videCase(d.x0, d.x1);
          return true;
        } else if (p.getTab()[d.y0][d.y1].getPiece().getCouleur() != this.getCouleur() &&
                !p.getTab()[d.y0][d.y1].getPiece().getName().equals("Roi")){
          mange(d, p);
        }
      } else
        return false;
    }
    return false;
  }
}
