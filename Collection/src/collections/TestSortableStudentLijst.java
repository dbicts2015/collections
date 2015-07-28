package collections;
import java.util.Iterator;
public class TestSortableStudentLijst {
    public static void main(String[] args){
        SortableStudentenLijst lijst = new SortableStudentenLijst();
        lijst.addStudent(new SortableStudent(1, "Jan"));
        lijst.addStudent(new SortableStudent(4, "Corneel"));
        lijst.addStudent(new SortableStudent(3, "Joris"));
        lijst.addStudent(new SortableStudent(2, "Piet"));
        Iterator<SortableStudent> it = lijst.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
/* OUTPUT:
1, Jan
2, Piet
3, Joris
4, Corneel
*/