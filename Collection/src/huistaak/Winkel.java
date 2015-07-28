package huistaak;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Winkel {

	/**
	 * Collectie van producten
	 */
	private final Set<Product> producten = new HashSet<Product>();
	
	/**
	 * Voegt een product toe als het nog niet aanwezig is
	 * @param product
	 */
	public void add(Product product) {
		if (!producten.add(product)) {
			throw new IllegalStateException("Er staat al een product in de winkelwagen met deze id");
		}
	}

	/**
	 * Zoekt een product adhv zijn id
	 * 
	 * @param id
	 * @return
	 */
	public Product get(String id) {
		for (Product product : producten) {
			if (product != null && product.getId().equals(id)) {
				return product;
			}
		}
		throw new ProductNotFoundException();
	}

	@Override
	public String toString() {
		return producten.stream().map(p -> p.getId() + " - " + p.toString()).collect(Collectors.joining("\n"));
	}

	/**
	 * Kijkt of een product met de gegeven id al bestaat
	 * @param id
	 * @return
	 */
	public boolean contains(String id) {
		return producten.stream().filter(p -> p.getId().equals(id)).count() > 0;
	}

}