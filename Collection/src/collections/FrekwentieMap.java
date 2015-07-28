package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FrekwentieMap {

	private final Map<String, Integer> woorden = new HashMap<>();

	public void addWoord(String woord) {
		if (woorden.containsKey(woord)) {
			woorden.put(woord, woorden.get(woord) + 1);
		}
		else {
			woorden.put(woord, 1);
		}
	}

	public Iterator<String> iterator() {
		return woorden.keySet().iterator();
	}

	public int getAantal(String woord) {
		return woorden.get(woord);
	}

}
