package collections;

public class TestNamen1 {

	public static void main(String[] args) {
		Namen1 namen = new Namen1(3);
		namen.setNaam(2, "Josje");
		namen.setNaam(0, "Karen");
		namen.setNaam(1, "Kristel");
		int aantal = namen.getLengte();
		for (int i = 0; i < aantal; i++) {
			String naam = namen.getNaam(i);
			System.out.println(naam);
			
		}
	}

}
/*  OUTPUT:
Karen
Kristel
Josje
 */
