public class Deplacement{
  int x0,y0,x1,y1;//x0 et x1 : Départ        y0 et y1 : Arrivée
  public Deplacement(int xdep, int ydep, int xarr, int yarr){
    x0 = xdep;
    x1 = ydep;
    y0 = xarr;
    y1 = yarr;
  }

  int valeurAbsolue(int x){
    if (x < 0){
      return -x;
    }
    return x;
  }

  char typeDeplacement(){
    if (x0 == y0){
      return 'v';
    } if (x1 == y1){
      return 'h';
    } if (valeurAbsolue(x0 - y0) == valeurAbsolue(x1 - y1)) {
      return 'd';
    } if ((valeurAbsolue(y0 - x0) == 2 && valeurAbsolue(y1 - x1) == 1) || (valeurAbsolue(y0 - x0) == 1 && valeurAbsolue(y1 - x1) == 2)){
      return 'c';
    } else
      return 'x';
  }

  int dist(){
    if (typeDeplacement() == 'c' || typeDeplacement() == 'x'){
      return -1;
    } else {
      if (valeurAbsolue(x0 - y0) >= valeurAbsolue(x1 - y1))
        return (valeurAbsolue(x0 - y0));
      else
        return (valeurAbsolue(x1 - y1));
    }
  }

  public static void main(String[]args){
    Deplacement d = new Deplacement(1, 5, 1, 2);
    System.out.println(d.typeDeplacement());
    System.out.println(d.dist());
  }
}
