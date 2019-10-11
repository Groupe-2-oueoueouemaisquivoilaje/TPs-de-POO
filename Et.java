public class Et extends Predicat {
    private Predicat p1;
    private Predicat p2;

    Et(Predicat pred1, Predicat pred2){
        p1 = pred1;
        p2 = pred2;
    }

    boolean estVrai(Media m){
        if(p1.estVrai(m) && p2.estVrai(m)){
            return !super.estVrai(m);
        }
        return false;
    }
}
