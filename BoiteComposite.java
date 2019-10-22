import java.util.LinkedList;
public class BoiteComposite extends Boite {
    private LinkedList<Boite> list;

    BoiteComposite(){
        list = new LinkedList<>();
    }

    boolean isEmpty(){
        return list.isEmpty();
    }

    void addBoite(Boite b){
        list.add(b);
    }

    public int length(){
        int i = 0;
        int t = 0;
        if(!isEmpty()) {
            while (i < list.size()){
                t = t + list.get(i).length();
                i++;
            }
        }
        return t;
    }

    public String toString(){
        int i = 0;
        String st = "";
        if (!isEmpty()){
            while(i<list.size()){
                st += list.get(i).toString();
                i++;
            }
        }
        return st;
    }

    protected boolean isEtirable(){
        Boite tmp = list.getFirst();
        while(tmp != list.getLast()){
            if (tmp.isEtirable())
                return true;
            tmp = list.get(list.indexOf(tmp) + 1);
        }
        return false;
    }

    public String toString(int tailleVoulue){
        String s = "";
        int espnes = tailleVoulue - length();
        int i = 0;
        int nb = 0;
        while (i < list.size()){
            if (list.get(i) instanceof BoiteEspace){
                nb++;
            }
            i++;
        }
        i = 0;
        //System.out.print(nb+" "+espnes+ " ");
        int div = 0;
        int reste=0;
        if(espnes>0) {
            div = espnes / nb;
            reste=espnes%nb;
        }
        if(list.getLast() instanceof BoiteEspace)
            reste+=1;
        while (i < list.size()){
            if (list.get(i) instanceof BoiteEspace){
                if(reste>0){
                    s+=new BoiteEspace().toString();
                    reste --;
                }
                BoiteEspace boo = new BoiteEspace();
                s+=boo.toString(div);
                //System.out.println(div);
            }else{
                s+=list.get(i).toString();
            }
            i++;
        }
        /*i = 0;
        if (espnes%nb != 0){
            int tmp = nb;
            while (i < list.size()){
                if (list.get(i) instanceof BoiteEspace){
                    BoiteEspace boo = new BoiteEspace();
                    if (nb == 1) {
                        boo.toString((espnes / nb)+1);
                    }
                    boo.toString(espnes/nb);
                }
                i++;
                tmp--;
            }

        } else {
            while (i < list.size()){
                if (list.get(i) instanceof BoiteEspace){
                    BoiteEspace boo = new BoiteEspace();
                    boo.toString(espnes/nb);
                }
                i++;
            }
        }*/
        return s;
    }
}
