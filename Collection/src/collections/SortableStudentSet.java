package collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
public class SortableStudentSet {
    private SortedSet<SortableStudent> set;
    public SortableStudentSet() {
        set = new TreeSet<SortableStudent>();
    }
    public void addStudent(SortableStudent s){
        set.add(s);
    }
    public void verwijderStudent(SortableStudent s){
        set.remove(s);
    }
    public Iterator<SortableStudent> iterator(){
        return set.iterator();
    }
    public Iterator<SortableStudent> groterDanStudent(SortableStudent s){
        return set.tailSet(s).iterator();
    }
}

