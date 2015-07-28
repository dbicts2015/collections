package collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class GemeentenMap {
    
    private Map<String,String>map;
    public GemeentenMap() {
        map= new HashMap<String, String>();
    }
    public void addGemeente(String postnr, String gemeente){
        map.put(postnr,  gemeente);
    }
    public String getGemeente(String postnr){
        return map.get(postnr);
    }
    public Iterator<String> iterator(){
        return map.keySet().iterator();
    }
}
