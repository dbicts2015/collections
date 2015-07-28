package collections;

public class TestCollection {
	public static void main(String[] args) {
		NamenCollection lijst = new NamenCollection(3);
		lijst.addNaam("Karen");
		lijst.addNaam("Kristel");
		lijst.addNaam("Kathleen");
		lijst.addNaam("Jelle");
		System.out.printf("Er zijn %1$s namen aanwezig in de lijst\n", lijst.getLengte());
		lijst.verwijderNaam("Jelle");
		System.out.printf("Na verwijdering van Jelle zijn er %1$s namen aanwezig in de lijst\n",lijst.getLengte());

		lijst.iterator().forEachRemaining(p -> {
			System.out.println(p);
		});

		lijst.houOver("Karen");
		System.out.println("En nu blijft Karen alleen nog over:");

		lijst.iterator().forEachRemaining(p -> {
			System.out.println(p);
		});
		System.out.println("-----");
		for (String s : lijst) {
			System.out.println(s);
		}
	}
}