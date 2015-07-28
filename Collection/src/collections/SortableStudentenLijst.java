package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortableStudentenLijst {

	private final List<SortableStudent> studenten = new ArrayList<SortableStudent>();

	public void addStudent(SortableStudent sortableStudent) {
		studenten.add(sortableStudent);
		Collections.sort(studenten);
	}

	public Iterator<SortableStudent> iterator() {
		return studenten.iterator();
	}

}
