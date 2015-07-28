package collections;

public class Gemeente implements Comparable<Gemeente> {

	private String postcode;
	private String naam;

	public Gemeente(String postcode, String naam) {
		this.postcode = postcode;
		this.naam = naam;
	}

	@Override
	public int compareTo(Gemeente o) {
		return naam.compareTo(o.naam);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		result = prime * result
				+ ((postcode == null) ? 0 : postcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gemeente other = (Gemeente) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gemeente [postcode=" + postcode + ", naam=" + naam + "]";
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

}