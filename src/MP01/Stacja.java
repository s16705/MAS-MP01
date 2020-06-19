package MP01;
import java.util.ArrayList;
import java.util.List;

public class Stacja extends MainExt {

    String nazwa, adres;
    List<Pracownik> pracownikList = new ArrayList<>(); // *
    //Asocjacja z atrybutem
    //KlientStacja ks;
    List<Zakupy> klientList;
    List<String> sprzedawanePaliwo = new ArrayList<>();

    public Stacja(String nazwa, String adres){
        this.nazwa = nazwa;
        this.adres = adres;
        this.klientList = new ArrayList<Zakupy>();
        sprzedawanePaliwo.add("Benzyna");
        sprzedawanePaliwo.add("Diesel");
        sprzedawanePaliwo.add("LPG");
    }

    //Zwykla asocjacja
    public void addPracownik(Pracownik pracownik) {
        if(!pracownikList.contains(pracownik)){
            pracownikList.add(pracownik);
            // I odwrotnie
            pracownik.addStacja(this);
        }
    }

    public String toString() {
        String info = "Stacja: " + nazwa + "\n";
        for(Pracownik p : pracownikList) {
            info += "Pracownicy stacji: " + p.imie +" "+p.nazwisko + "\n";
        }
        for(Zakupy k : klientList){
            info += "KlientStacja: "+k.klient+k.stacja+k.kupioneProdukty.toArray();
        }
        return info;
    }


}
