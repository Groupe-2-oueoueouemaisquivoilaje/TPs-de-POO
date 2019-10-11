public class EstUnLivre extends Predicat {

    @Override
    boolean estVrai(Media m) {
        if (m instanceof Livre)
            return !super.estVrai(m);
        return false;
    }
}
