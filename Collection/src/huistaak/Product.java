package huistaak;

import java.math.BigDecimal;

public class Product {

	private final String id;
	private final String naam;
	private final BigDecimal prijs;

	public Product(String id, String naam, BigDecimal prijs) {
		this.id = id;
		this.naam = naam;
		this.prijs = prijs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s aan %s€", naam, prijs.toString());
	}

	public String getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

}