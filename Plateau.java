public class Plateau{
  private int x;
  private int y;
  private Case [][] tab;

  public Plateau (int longueur, int largeur){
    x = largeur;
    y = longueur;
    tab = new Case [largeur][longueur];
    for (int i = 0; i < tab.length; i++){
      for (int j = 0; j < tab[i].length; j++){
        if (j%2 == 0){
          tab[i][j] = new Case (true);
        } else
            tab[i][j] = new Case(false);
      }
    }
  }

  Case [][] getTab(){return tab;}

  void videCase(int x, int y){tab[x][y].enleverPiece();}

  void remplirCase(int x, int y, Piece p){tab[x][y].remplirPiece(p);}

  public boolean horsLimite(Deplacement d){
    if (d.x0 < 0 || d.x0 >= x || d.y0 < 0 || d.y0 >= x){
      return true;
    } if (d.x1 < 0 || d.y1 >= y){
      return true;
    }
    return false;
  }

  public boolean horsLimite(int x, int y){
    if (x < 0 || x >= this.x){
      return true;
    } if (y <= 0 || y >= this.y){
      return true;
    }
    return false;
  }

  public void afficher(){
    for(int i = 0; i < tab.length; i++){
      for (int j = 0; j < tab[i].length; j++){
        System.out.print(tab[i][j]);
      }
      System.out.println();
    }
  }
}
