package MP01;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Stacja extends MainExt {

    String nazwa, adres;
    List<Pracownik> pracownikList = new ArrayList<>(); // *
    //Asocjacja z atrybutem
    //KlientStacja ks;
    List<Zakupy> klientList;
    List<String> sprzedawanePaliwo = new ArrayList<>();
    private static Map<Class, List<Stacja>> mapaStacji = new Hashtable<>();
    static List<Stacja> listaStacji = new ArrayList<>();


    public Stacja(String nazwa, String adres){
        this.nazwa = nazwa;
        this.adres = adres;
        this.klientList = new ArrayList<Zakupy>();
        sprzedawanePaliwo.add("Benzyna");
        sprzedawanePaliwo.add("Diesel");
        sprzedawanePaliwo.add("LPG");
        listaStacji.add(this);
        mapaStacji.put(Stacja.class, listaStacji);
    }

    //Zwykla asocjacja
    public void addPracownik(Pracownik pracownik) {
        if(!pracownikList.contains(pracownik)){
            pracownikList.add(pracownik);
            // I odwrotnie
            pracownik.addStacja(this);
        }
    }

    public static List<Stacja> getAllStacje(){
        return listaStacji;
    }

    public String getNazwa(){
        return nazwa;
    }

    public String toString() {
        String info = "Stacja: " + nazwa + "\n";
        for(Pracownik p : pracownikList) {
            info += "Pracownicy stacji: " + p.imie +" "+p.nazwisko + "\n";
        }
        for(Zakupy k : klientList){
//            info += "KlientStacja: "+k.klient+k.stacja+k.kupioneProdukty.toArray();
            info += "KlientStacja: "+k.klient+k.stacja;
        }
        return info;
    }


}
