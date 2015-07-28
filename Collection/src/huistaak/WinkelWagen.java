package huistaak;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class WinkelWagen {

	/**
	 * De collectie van producten
	 */
	private final Map<Product, Integer> lijst = new HashMap<>();

	/**
	 * Voegt een of meerdere producten toe aan de producten lijst
	 * 
	 * @param product Het product om toe te voegen
	 * @param aantal Het aantal producten toe te voegen
	 * @throws IllegalArgumentException Als aantal <= 0
	 */
	public void add(Product product, int aantal) {
		if (aantal <= 0) {
			throw new IllegalArgumentException("Het aantal moet strikt positief zijn.");
		}
		lijst.put(product, lijst.getOrDefault(product, 0) + aantal);
	}

	/**
	 * 
	 * @param product
	 * @param aantal
	 */
	public void remove(Product product, int aantal) {
		if (!lijst.containsKey(product)) {
			throw new ProductNotFoundException();
		}
		if (lijst.get(product) - aantal < 0) {
			throw new IllegalStateException("Het aantal mag niet negatief zijn");
		}
		lijst.put(product, lijst.get(product) - aantal);
	}

	/**
	 * Berekent de totale waarde
	 * @return De totale waarde als BigDecimal
	 */
	public BigDecimal getTotal() {
		return lijst.entrySet().stream().map(e -> e.getKey().getPrijs().multiply(new BigDecimal(e.getValue()))).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Override
	public String toString() {
		return new StringBuilder("De winkelwagen: \n").append(
				lijst.entrySet().stream().map(WinkelWagen::formatProduct).collect(Collectors.joining("\n")))
				.append("\nTotaal: ").append(getTotal()).append("€").toString();
	}

	/**
	 * Hulpmethode voor toString() om die wat leesbaarder te maken
	 * 
	 * @param e
	 * @return
	 */
	private static String formatProduct(Entry<Product, Integer> e) {
		return String.format("%dx %s", e.getValue(), e.getKey().toString());
	}

}