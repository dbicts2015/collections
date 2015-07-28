package collections;
public class Namen1 {
    private String[] namen;
    public Namen1(int aantal) {
        namen = new String[aantal];
    }
    public void setNaam(int positie, String naam){
        namen[positie]=naam;
    }
    public String getNaam(int positie){
        return namen[positie];
    }
    public int getLengte(){
        return namen.length;
    }
}