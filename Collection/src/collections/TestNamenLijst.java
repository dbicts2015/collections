package collections;

public class TestNamenLijst {
    public static void main(String[] args){
        NamenLijst lijst = new NamenLijst();
        lijst.addNaam("Karen");
        lijst.addNaam("Kristel");
        lijst.addNaam("Kathleen");
        lijst.addNaam("Karen");
        lijst.addNaam("Kristel");
        lijst.addNaam("Kathleen");
        System.out.printf("Kathleen staat op positie %1$d\n", lijst.geefPositie("Kathleen"));
        
        lijst.forEach(System.out::println);
//        for(String naam: lijst){
//        	System.out.println(naam);
//        }
    }
}
