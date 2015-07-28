package collections;

public class Student {

	private String naam;
	private int nr;

	public Student(String naam, int nr) {
		this.naam = naam;
		this.nr = nr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

}
