package collections;
import java.util.ArrayList;
import java.util.Collection;
public class TestLetterNaamCollection {
    public static void main(String[] args){
        Collection<String> k3 = new ArrayList<String>();
        k3.add("Karen");
        k3.add("Kristel");
        k3.add("Kathleen");
        k3.add("Jelle");
        LetterNaamCollection ln = new LetterNaamCollection("K");
        ln.addAll(k3);
        ln.add("Josje");
        System.out.printf("Er zijn %1$s namen die met een 'K' beginnen\n",
        		ln.getAantalNamen());
        
        // een LetterNaamCollection moet gebruikt kunnen worden als Collection
        Collection<String>  collectie = ln;
        for(String naam : collectie){
        	System.out.println(naam);
        }
    }    
}
