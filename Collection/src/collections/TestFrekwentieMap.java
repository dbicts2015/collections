package collections;
import java.util.Iterator;
public class TestFrekwentieMap {
    public static void main(String[] args){
        FrekwentieMap map = new FrekwentieMap();
        map.addWoord("Karen");
        map.addWoord("Kristel");
        map.addWoord("Karen");
        map.addWoord("Kathleen");
        map.addWoord("Kristel");
        map.addWoord("Kristel");
        map.addWoord("Kathleen");
        map.addWoord("Karen");
        Iterator<String> it = map.iterator();
        while (it.hasNext()){
            String woord = it.next();
            int aantal = map.getAantal(woord);
            System.out.printf("Het woord %1$s kwam %2$d maal voor\n", woord, aantal);
        }
    }
}