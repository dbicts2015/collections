package collections;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
public class GemeenteCollection implements Iterable<Gemeente> {
    private SortedSet<Gemeente> set;
    public GemeenteCollection() {
        set = new TreeSet<Gemeente>();
    }
    public void addGemeente(Gemeente g){
        set.add(g);
    }
    public Iterator<Gemeente> iteratorPostnr(){
		Set<Gemeente> set = new TreeSet<Gemeente>((o1,o2) -> {
			return o1.getPostcode().compareTo(o2.getPostcode());
		});
		set.addAll(this.set);
		return set.iterator();
    }
	public Iterator<Gemeente> iteratorGemeente() {
		Set<Gemeente> set = new TreeSet<Gemeente>((o1,o2) -> {
			return o1.getNaam().compareTo(o2.getNaam());
		});
		set.addAll(this.set);
		return set.iterator();
	}
	@Override
	public Iterator<Gemeente> iterator() {
		return set.iterator();
	}
}
