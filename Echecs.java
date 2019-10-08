public class Echecs{
  private Plateau p;

  boolean joueur; //False = blanc True = noir

  public Echecs(int x, int y){
    p = new Plateau (x, y);
    for (int i =  0; i < p.getTab().length; i++){
      for (int j = 0; j < p.getTab()[i].length; j++){
        if (i == 0){ //Mise en place des pièces pour une partie de mini-echec en 4x5
          p.getTab()[i][0].remplirPiece(new Tour(false));
          p.getTab()[i][1].remplirPiece(new Dame(false));
          p.getTab()[i][2].remplirPiece(new Roi(false));
          p.getTab()[i][3].remplirPiece(new Tour(false));
        }
        if (i == 1){
          p.getTab()[i][j].remplirPiece(new Pion(false));
        }
        if (i == p.getTab().length-2){
          p.getTab()[i][j].remplirPiece(new Pion(true));
        }
        if (i == p.getTab().length-1){
          p.getTab()[i][0].remplirPiece(new Tour(true));
          p.getTab()[i][1].remplirPiece(new Dame(true));
          p.getTab()[i][2].remplirPiece(new Roi(true));
          p.getTab()[i][3].remplirPiece(new Tour(true));
        }
      }
    }
    p.afficher();
    joueur = false;
  }

  void jouerTour(Deplacement d, Plateau p, boolean j){
    if (j == p.getTab()[d.x0][d.x1].getPiece().getCouleur()){
      p.getTab()[d.x0][d.x1].getPiece().estValide(d, p);
      p.afficher();
      joueur = !joueur;
    } else {
      System.out.println("Ce n'est pas àvotre tour de jouer !");
    }
  }

  public static void main(String[]args){

    Echecs e = new Echecs(4, 5);
    System.out.println(e.p.getTab()[1][0].getPiece());
    Deplacement d = new Deplacement(1, 0, 2, 0);
    System.out.println(e.p.horsLimite(d));
    e.jouerTour(d, e.p, e.joueur);                                      //plusieurs tests ont soulevé des problèmes précédents : les fonctions "horsLimite"
    Deplacement d1 = new Deplacement(3, 1, 2, 0);// et "estValide" posaient problèmes à cause de problèmes de '>=' problèmes résolus
    e.jouerTour(d1, e.p, e.joueur);
  }
}
