package collections;
import java.util.*;
public class TestSet {
       public static void main(String[] args){
        NamenSet ns = new NamenSet();
        ns.addNaam("Karen");
        ns.addNaam("Kristel");
        ns.addNaam("Kathleen");
        ns.addNaam("Kristel");
        Iterator<String> it = ns.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }     
    }
}
