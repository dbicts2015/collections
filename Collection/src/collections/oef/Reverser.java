package collections.oef;

import java.util.Deque;
import java.util.LinkedList;

public class Reverser {

	private Deque<Character> deque = new LinkedList<>();
	
	public void addZin(String zin) {
		for (char c : zin.toCharArray()) {
			deque.addLast(c);
		}
	}

	public String reverse() {
		StringBuilder bldr = new StringBuilder();
		while ( !deque.isEmpty() ) {
			bldr.append(deque.removeLast());
		}
		return bldr.toString();
	}

}