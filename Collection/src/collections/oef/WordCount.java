package collections.oef;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordCount implements Iterable<Entry<String, Integer>> {

	private final Map<String, Integer> woorden = new TreeMap<>();

	public void setZin(String zin) {
		for (String woord : zin.split(" ")) {
			woorden.put(woord, woorden.getOrDefault(woord, 0) + 1);
		}
	}

	@Override
	public Iterator<Entry<String, Integer>> iterator() {
		return woorden.entrySet().iterator();
	}

	public Iterator<Entry<String, Integer>> iteratorAantal() {
		Set<Entry<String, Integer>> set = new TreeSet<Entry<String, Integer>>( (o1, o2) -> {
			return o1.getValue() == o2.getValue() ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue();
		});
		set.addAll(woorden.entrySet());
		return set.iterator();
	}

	public String toString() {
		StringBuilder bldr = new StringBuilder();
		for (Entry<String, Integer> kvp : this)
			bldr.append(kvp.getKey() + ": " + kvp.getValue()).append("\n");
		return bldr.toString();
	}

}
