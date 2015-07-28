package collections;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LetterNaamCollection extends AbstractCollection<String> {

	private final List<String> list = new ArrayList<>();

	private final String letter;

	public LetterNaamCollection(String letter) {
		this.letter = letter;
	}

	public void addNaam(String string) {
		list.add(string);
	}

	public int getAantalNamen() {
		int aantal = 0;
		for (String naam : list)
			if (naam.startsWith(letter))
				aantal++;
		return aantal;
	}

	public void verwijderNamen() {
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
			if (!iterator.next().startsWith(letter)) {
				iterator.remove();
			}
		}
	}

	@Override
	public Iterator<String> iterator() {
		return list.iterator();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		return list.addAll(c);
	}
	
	@Override
	public boolean add(String e) {
		return list.add(e);
	}
}
