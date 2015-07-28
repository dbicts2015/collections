package huistaak;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	/**
	 * De text die getoont wordt als aan de gebruiker iets gevraagd wordt.
	 */
	private static final String INPUT_TEXT_ADD = "Welk product wilt u toevoegen";
	private static final String INPUT_TEXT_AMT = "Hoe veel keer wilt u dit product toevoegen";

	/**
	 * De text die tevoorschijn komt als de gebruiker verkeerde waarden ingeeft
	 */
	private static final String EXCEPTION_TEXT_ADD = "U kan enkel een id geven van een van de producten.";
	private static final String EXCEPTION_TEXT_AMT = "Gelieve een geldige hoeveelheid mee te geven.";

	public static void main(String[] args) {
		Winkel winkel = new Winkel();
		winkel.add(new Product("0", "Auto", new BigDecimal(15)));
		winkel.add(new Product("1", "LP van K3", new BigDecimal(20)));
		winkel.add(new Product("2", "Handboek Java", new BigDecimal(49)));
		winkel.add(new Product("3", "Hannes", new BigDecimal(100)));
		
		System.out.println(winkel);
		
		WinkelWagen winkelwagen = new WinkelWagen();

		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Wilt u een product toevoegen aan de winkelwagen? (Y/n): ");
				String input = scanner.nextLine();
				if (input == null || input.equals("") || input.equalsIgnoreCase("y")) {
					String id = getInput(INPUT_TEXT_ADD, scanner, winkel::contains, EXCEPTION_TEXT_ADD);
					String aantal = getInput(INPUT_TEXT_AMT, scanner, s -> s.matches("[0-9]*"), EXCEPTION_TEXT_AMT);
					
					winkelwagen.add(winkel.get(id), Integer.parseInt(aantal));
				}
				else if (input.equalsIgnoreCase("n")) {
					break;
				}
			} catch (Exception ex) {
				System.out.println("Gelieve enkel geldige invoerwaarden te voorzien.");
			}
		}
		scanner.close();
		System.out.println(winkelwagen);
	}

	/**
	 * Vraag input aan de gebruiker
	 * 
	 * @param text De text die weergegeven moet worden aan de gebruiker.
	 * @param scanner De scanner die de invoer van de gebruiker inleest
	 * @param verifier De klasse die kijkt of de waarde ingevoerd door de gebruiker geldig is
	 * @param exception De klasse die de exception afhandelt en dan een string waarde weergeeft aan de gebruiker
	 * @return De door de gebruiker ingevoerde waarde
	 * @throws Exception zie Callable<T>
	 */
	private static String getInput(String text, Scanner scanner, StringVerifier verifier, String exception) throws Exception {
		System.out.print(text + ": ");
		String line = scanner.nextLine();
		if (verifier.verify(line)) {
			return line;
		}
		System.out.println(exception);
		return getInput(text, scanner, verifier, exception);
	}

}