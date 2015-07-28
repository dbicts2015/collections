package collections;
import java.util.Iterator;
public class TestGemeentenMap {
       public static void main(String[] args){
        GemeentenMap map = new GemeentenMap();
        map.addGemeente("1000", "Brussel");
        map.addGemeente("2000", "Antwerpen");
        map.addGemeente("8000", "Brugge");
        map.addGemeente("3500", "Hasselt");
        map.addGemeente("3000", "Leuven");
        map.addGemeente("9000", "Gent");
        Iterator<String> it= map.iterator();
        while(it.hasNext()){
            String postnr = it.next();
            String gemeente = map.getGemeente(postnr);
            System.out.printf("%1$s: %2$s\n", postnr, gemeente);
        }
    }
}
