package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class NamenCollection implements Iterable<String> {

	/**
	 * declaratie van een collectie Strings
	 */
	private Collection<String> lijst;

	/**
	 * lege constructor, maakt een collection aan met een initiele capaciteit
	 * van 10
	 */
	public NamenCollection() {
		lijst = new ArrayList<String>();
	}

	/**
	 * maakt een collection aan met een bepaalde initiële capaciteit
	 */
	public NamenCollection(int capaciteit) {
		lijst = new ArrayList<String>(capaciteit);
	}

	/**
	 * voegt een element toe aan de collection
	 */
	public void addNaam(String naam) {
		lijst.add(naam);
	}

	/**
	 * geeft het aantal elementen in de collection terug
	 */
	public int getLengte() {
		return lijst.size();
	}

	/**
	 * verwijdert een bepaalde naam
	 */
	public void verwijderNaam(String naam) {
		lijst.remove(naam);
	}

	/**
	 * geeft de lijst iterator terug om de collection te overlopen
	 */
	public Iterator<String> iterator() {
		return lijst.iterator();
	}

	/**
	 * Verwijder alles behalve de opgegeven waarde 
	 * @param string
	 */
	public void houOver(String string) {
		lijst.retainAll(Arrays.asList(string));
	}
}