package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NamenLijst implements Iterable<String> {
	private List<String> lijst;

	public NamenLijst() {
		lijst = new ArrayList<String>();
	}

	public void addNaam(String naam) {
		lijst.add(naam);
	}

	public int geefPositie(String naam) {
		return lijst.indexOf(naam) + 1;
	}

	public Iterator<String> iterator() {
		return lijst.iterator();
	}
}
