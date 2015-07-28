/*
 * A stream represents a sequence of elements and supports different kind of operations
 * to perform computations upon those elements.
 * Stream operations are either intermediate or terminal. 
 * Intermediate operations return a stream so we can chain multiple intermediate operations 
 * without using semicolons. 
 * Terminal operations are either void or return a non-stream result.
 * 
 * Intermediate operations do not perform any processing until a terminal operation is invoked 
 * on the stream pipeline; they are “lazy.”
 * 
 * tutorials:
 * http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html
 */

package collections.bulkoperations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Persoon> personen = vulPersonen();
		toonPersonen(personen, "alle personen");

		// nieuw in java 8:
		System.out.println("\nOverzicht van alle personen (via forEach van Stream):");
		personen.forEach(System.out::println);

		filterStream(personen);

		werkenMetSupplier();

		werkenMetNumericStreams();
	}

	private static void werkenMetSupplier() {
		/*
		 * Java 8 streams cannot be reused. As soon as you call any terminal
		 * operation the stream is closed. To overcome this limitation we have
		 * to create a new stream chain for every terminal operation we want
		 * to execute, e.g. we could create a stream supplier to construct a new
		 * stream with all intermediate operations already set up:
		 */
		Supplier<Stream<Persoon>> streamSupplier = Main::maakStreamMetPersonen;
		
		filterMetSupplier(streamSupplier);

		aggregateFuncties(streamSupplier);

		sorteren(streamSupplier);

		transformeren(streamSupplier);

		groeperen(streamSupplier);

		matchFuncties(streamSupplier);
	}

	private static void matchFuncties(Supplier<Stream<Persoon>> streamSupplier) {
		// bestaan ook: anyMatch, allMatch
		if (streamSupplier.get().noneMatch(p -> p.getLengte() <= 20)) {
			System.out.println("\nEr geen zijn kabouters aanwezig");
		} else {
			System.out.println("\nEr zijn kabouters aanwezig");
		}
	}

	private static void transformeren(Supplier<Stream<Persoon>> streamSupplier) {
		// transformeren mbv map
		System.out.println("\nPersonen met lengte 1m80 of groter, gesorteerd:");
		// in klasse DatatPersoon moet ctor met
		// param Persoon gedef zijn
		streamSupplier.get().filter(p -> p.getLengte() >= 180).map(DataPersoon::new)
				.sorted(Comparator.comparing(DataPersoon::getVolledigeNaam))
				.forEach(d -> System.out.println(d.getVolledigeNaam()));
	}

	private static void groeperen(Supplier<Stream<Persoon>> streamSupplier) {
		// groeperen mbv collect
		Map<Integer, List<Persoon>> personenPerLengte = streamSupplier.get()
				.collect(Collectors.groupingBy(Persoon::getLengte));
		System.out.println("\nOverzicht per lengte:");
		for (int lengte : personenPerLengte.keySet()) {
			System.out.printf("%nLengte %1$d cm:%n", lengte);
			personenPerLengte.get(lengte).forEach(System.out::println);
		}

		// overzicht eerste letter achternaam + aantal personen waarvan
		// achternaam met die letter begint
		System.out
				.println("\nOverzicht per letter, alfabetisch gesorteerd op eerste letter van naam:");
		Map<String, Long> aantalPersonenPerLetter = streamSupplier.get()
				.collect(
						Collectors.groupingBy(p -> ((Persoon) p).getNaam()
								.substring(0, 1), Collectors.counting()));
		aantalPersonenPerLetter.keySet()
				.stream()
				.sorted()
				// standaardsortering
				.forEach(
						k -> System.out.printf("%1$s:  %2$s\n", k, aantalPersonenPerLetter.get(k)));

		System.out
				.println("\nOverzicht gesorteerd op frequentie van eerste letter van naam:");
		aantalPersonenPerLetter
				.entrySet()
				.stream()
				.map(LetterFrequentie::new)
				.sorted(Comparator.comparing(LetterFrequentie::getFrequentie))
				.forEach(
						l -> System.out.printf("%1$d - %2$s%n",
								l.getFrequentie(), l.getLetter()));
	}

	private static void sorteren(Supplier<Stream<Persoon>> streamSupplier) {
		// sorteren mbv sorted
		System.out.println("\nalle personen, gesorteerd op naam:");
		streamSupplier.get().sorted(Comparator.comparing(Persoon::getNaam)).forEach(System.out::println);
	}

	private static void aggregateFuncties(
			Supplier<Stream<Persoon>> streamSupplier) {
		System.out.println("\nEerste persoon met een 'i' in de naam: ");
		streamSupplier.get().filter(p -> p.getNaam().contains("i"))
				.min(Comparator.comparing(Persoon::getNaam))
				.ifPresent(System.out::println);

		double gemiddelde = streamSupplier.get()
				.mapToDouble(Persoon::getLengte).average().getAsDouble();
		System.out.printf("%ngemiddelde lengte: %1$3.2f cm%n", gemiddelde);
	}

	private static void filterMetSupplier(Supplier<Stream<Persoon>> streamSupplier) {
		long aantal = streamSupplier.get().filter(p -> p.getNaam().contains("i")).count();
		System.out.printf("%nEr zijn %1$d personen met een 'i' in hun naam:%n", aantal);
		streamSupplier.get().filter(p -> p.getNaam().contains("i")).forEach(p -> System.out.println(p));

		aantal = streamSupplier.get().filter(p -> p.getNaam().contains("i")).filter(p -> p.getNaam().contains("o")).count();
		System.out.printf("%nEr zijn %1$d personen met een 'i' en een 'o' in hun naam%n", aantal);
	}

	private static void filterStream(List<Persoon> personen) {
		// filteren mbv filter

		// een Stream laat toe om sequentiele of paralelle aggregate functies
		// uit te voeren op een reeks elementen
		Stream<Persoon> personenStream = personen.stream();
		Stream<Persoon> personenGefilterd = personenStream.filter(p -> p.getNaam().contains("i"));
		/*
		 * // dit blok in comment om runtime fout te voorkomen bij volgende //
		 * oproep van toonPersonen // (IllegalStateException: stream has already
		 * been operated upon or closed)
		 * 
		 */
//		long aantal = personenGefilterd.count();
//		System.out.printf("%nEr zijn %1$d personen met een 'i' in hun naam%n" , aantal);

		toonPersonen(personenGefilterd.collect(Collectors.toList()), "personen met 'i' in de naam");
	}

	private static void werkenMetNumericStreams() {
		// Java SE 8 introduces special streams to perform operations on
		// numbers: IntStream, DoubleStream and LongStream
		// two static methods are available to help generate such ranges: range
		// and rangeClosed.
		// Both methods take the starting value of the range as the first
		// parameter and the end value
		// of the range as the second parameter. However, range is exclusive,
		// whereas rangeClosed is inclusive.
		System.out.println("\n3-vouden:");
		Supplier<IntStream> intSupplier = () -> IntStream.rangeClosed(1, 100);
		IntStream drievouden = intSupplier.get().filter(i -> i % 3 == 0);
		drievouden.forEach(System.out::println);

		System.out.println("\nEerste 5 3-vouden:");
		intSupplier.get().filter(i -> i % 3 == 0).limit(5).forEach(System.out::println);

	}

	private static Stream<Persoon> maakStreamMetPersonen() {
		return Stream.of(new Persoon("Jansen", "Jan", 170), new Persoon(
				"Pieters", "Piet", 175), new Persoon("Jorissen", "Joris", 180),
				new Persoon("Cornelis", "Corneel", 185), new Persoon(
						"Vermeulen", "Joske", 179), new Persoon("Praline",
						"Jeanine", 170));
	}

	private static void toonPersonen(Collection<Persoon> personen, String titel) {
		System.out.printf("%n***** %1$s ****%n", titel.toUpperCase());
		for (Persoon persoon : personen) {
			System.out.println(persoon);
		}
	}

	private static List<Persoon> vulPersonen() {
		List<Persoon> personen = new ArrayList<Persoon>();
		personen.add(new Persoon("Jansen", "Jan", 170));
		personen.add(new Persoon("Pieters", "Piet", 175));
		personen.add(new Persoon("Jorissen", "Joris", 180));
		personen.add(new Persoon("Cornelis", "Corneel", 185));
		personen.add(new Persoon("Vermeulen", "Joske", 179));
		personen.add(new Persoon("Praline", "Jeanine", 170));
		return personen;
	}
}

class DataPersoon {
	private String voornaam, naam;

	public DataPersoon(Persoon persoon) {
		this.voornaam = persoon.getVoornaam();
		this.naam = persoon.getNaam();
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVolledigeNaam() {
		return String.format("%1$s %2$s", getNaam().toUpperCase(),
				getVoornaam());
	}
}

class LetterFrequentie {
	private char letter;
	private int frequentie;

	public LetterFrequentie(Map.Entry<String, Long> entry) {
		this.letter = entry.getKey().charAt(0);
		this.frequentie = entry.getValue().intValue();
	}

	public LetterFrequentie(char letter, int frequentie) {
		this.letter = letter;
		this.frequentie = frequentie;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public int getFrequentie() {
		return frequentie;
	}

	public void setFrequentie(int frequentie) {
		this.frequentie = frequentie;
	}

}
