package collections;

import java.util.Collection;


public class TestLetterNaam {
    public static void main(String[] args){
        LetterNaam ln = new LetterNaam("K");
        ln.addNaam("Karen");
        ln.addNaam("Kristel");
        ln.addNaam("Kathleen");
        ln.addNaam("Josje");
        System.out.printf("Er zijn %1$s namen die met een 'K' beginnen\n",ln.getAantalNamen());  // 3
        
        
        for(String naam:ln){
        	System.out.println(naam);
        }
        
        System.out.println("Deze namen beginnen met een K");
        ln.verwijderNamen();  // verwijder alle namen die beginnen met een 'K'
        ln.forEach(naam -> {
        	System.out.println(naam);
        });
        
        Collection<String> collectie = ln; // compileerfout;
        // want LetterNaam is GEEN implementatie van Collection
    }  
}