public class BoiteMot extends Boite {
    String s;

    BoiteMot(String txt){
        s = txt;
    }

    public int length(){
        return s.length();
    }

    public String toString(){
        return s;
    }
}
