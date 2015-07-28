package collections;
import java.util.*;
public class TestSortableSet {
    public static void main(String[] args){
        SortableStudentSet studenten = new SortableStudentSet();
        studenten.addStudent(new SortableStudent(4, "Jan"));
        studenten.addStudent(new SortableStudent(2, "Piet"));
        studenten.addStudent(new SortableStudent(1, "Joris"));
        studenten.addStudent(new SortableStudent(3, "Corneel"));
        Iterator<SortableStudent> it = studenten.iterator();             
        while (it.hasNext()){
            System.out.println(it.next());
        }
        SortableStudent piet = new SortableStudent(2,"Piet");
        System.out.println("Iedereen met een nummer >= Piet:");
        it = studenten.groterDanStudent(piet);             
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
