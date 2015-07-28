package collections;
import java.util.Iterator;
public class TestGemeenteCollection {
    public static void main(String[] args) {
        GemeenteCollection lijst = new GemeenteCollection();
        lijst.addGemeente(new Gemeente("1000","Brussel"));
        lijst.addGemeente(new Gemeente("2000","Antwerpen"));
        lijst.addGemeente(new Gemeente("9000","Gent"));
        lijst.addGemeente(new Gemeente("8000", "Brugge"));
        lijst.addGemeente(new Gemeente("3500","Hasselt"));
        lijst.addGemeente(new Gemeente("3000","Leuven"));
        Iterator<Gemeente> it = lijst.iteratorPostnr();
        System.out.println("Gesorteerd op postnr");
        while (it.hasNext()){
            System.out.println(it.next());
        }
        
        it = lijst.iteratorGemeente();
        System.out.println("Gesorteerd op gemeentenaam");
        while (it.hasNext()){
            System.out.println(it.next());
        } 
        System.out.println("Nogmaals gesorteerd op gemeentenaam, nu met enhanced for");
        for(Gemeente gemeente: lijst){
        	System.out.println(gemeente);
        }
        
    }  
}