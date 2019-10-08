public class Cavalier extends Piece{
  public Cavalier(boolean c){
    super(c, "Cavalier");
  }

  boolean estValide(Deplacement d, Plateau p){
    if (!p.horsLimite(d) && super.estValide(d, p)){
      if (d.typeDeplacement() == 'c'){
        if (p.getTab()[d.y0][d.y1].getPiece() == null){
          p.remplirCase(d.y0, d.y1, this);
          p.videCase(d.x0, d.x1);
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
