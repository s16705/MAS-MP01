import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pracownik {

    int id;
    String imie, nazwisko;
    List<Stacja> stacjaList = new ArrayList<>(); // *
    //private static List<Pracownik> pracownikList = new ArrayList<>();

    public Pracownik(int id, String imie, String nazwisko){
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public void addStacja(Stacja stacja){
        if(!stacjaList.contains(stacja)){
            stacjaList.add(stacja);
            // I odwrotnie
            stacja.addPracownik(this);
        }
    }

    /*
    public Pracownik findPracownik(int id) throws Exception {
        for(Pracownik p : pracownikList){
            if(p.id == id){
                return p;
            }
        }
        throw new Exception("Nie udało się znaleźć pracownika"+id);
    }

     */

    public String toString() {
        String info = "Dane Pracownika: " + imie+" "+nazwisko+ "\n";
        for(Stacja s : stacjaList) {
            info += "Stacja na ktorej pracuje: " + s.nazwa +" Adres: "+s.adres + "\n";
        }
        return info;
    }
}
