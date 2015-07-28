package collections.oef;

import java.util.Iterator;
import java.util.Map.Entry;

public class WordCountTest {

	public static void main(String[] args) {
		String zin = "de kat krabt de krollen van de trap";
		WordCount wordCount = new WordCount();
		wordCount.setZin(zin);
		System.out.println(wordCount);
		System.out.println("via enhanced for:");
		for (Iterator<Entry<String, Integer>> it = wordCount.iteratorAantal(); it.hasNext();  ) {
			Entry<String, Integer> kvp = it.next();
			System.out.println(kvp.getKey() + ": " + kvp.getValue());
		}

	}

}
