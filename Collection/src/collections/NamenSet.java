package collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
public class NamenSet {
    //declaratie van een collectie Strings
    private Set <String> lijst;
    /** lege constructor, maakt een set aan met een initiele capaciteit van 16 buckets  */
    public NamenSet() {
        lijst = new HashSet<String>();
    }
    /** maakt een set aan met een bepaalde initiële capaciteit  */
    public NamenSet(int capaciteit){
        lijst = new HashSet<String>(capaciteit);
    }
    /**voegt een element toe aan de set */
    public void addNaam(String naam){
        lijst.add(naam);
    }
    /**geeft het aantal elementen in de set terug */
    public int getLengte(){
        return lijst.size();
    }
    /**verwijdert een bepaalde naam */
    public void verwijderNaam(String naam){
        lijst.remove(naam);
    }
    /**geeft de iterator terug om de set te overlopen */ 
    public Iterator<String> iterator(){
        return lijst.iterator();
    }
}
