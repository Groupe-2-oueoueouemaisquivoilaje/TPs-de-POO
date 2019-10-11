public class TitreCommenceParS extends Predicat {

    boolean estVrai(Media m){
        if(Character.toLowerCase(m.titre.charAt(0)) == 's'){
            return !super.estVrai(m);
        }
        return false;
    }
}
