package collections;

public class SortableStudent extends Student implements
		Comparable<SortableStudent> {
	public SortableStudent(int nr, String naam) {
		super(naam, nr);
	}

	public int compareTo(SortableStudent s) {
//		 resultaat < 0 => this komt voor s
//		 resultaat == 0 => this komt bij sortering op dezelfde plaats als s
//		 resultaat > 0 => s komt voor this
		return getNr() < s.getNr() ? -1 : getNr() > s.getNr() ? 1 : 0;
	}

	@Override
	public String toString() {
		return "SortableStudent [naam=" + getNaam() + ", nr="
				+ getNr() + "]";
	}

}