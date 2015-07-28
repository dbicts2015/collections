package collections.oef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListMerge<T extends Comparable<T>> {
	
	public List<T> merge(List<T> list_a, List<T> list_b) {
		List<T> list = new ArrayList<>();
		list.addAll(list_a);
		list.addAll(list_b);
		Collections.sort(list);
		return list;
	}

}
