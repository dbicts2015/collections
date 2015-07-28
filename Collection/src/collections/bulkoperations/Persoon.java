package collections.bulkoperations;

public class Persoon {
	private String naam, voornaam;
	private int lengte;

	public int getLengte() {
		return lengte;
	}

	public void setLengte(int lengte) {
		this.lengte = lengte;
	}

	public Persoon(String naam, String voornaam, int lengte) {
		this.naam = naam;
		this.voornaam = voornaam;
		this.lengte = lengte;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	@Override
	public String toString() {
		return String.format("%1$s %2$s is %3$dcm lang.", voornaam, naam.toUpperCase(), lengte);
	}
	
	
}
