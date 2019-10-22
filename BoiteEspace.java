import java.util.Arrays;
public class BoiteEspace extends BoiteEtirable {
    String sp;

    BoiteEspace(){
        sp = " ";
    }

    public int length(){
        return 1;
    }

    public String toString(){
        return sp;
    }

    boolean isEtirable(){
        return true;
    }

    public String toString(int k){
        char [] spaces = new char[k];
        Arrays.fill(spaces, ' ');
        return toString() + new String(spaces);
    }
}
