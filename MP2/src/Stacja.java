import java.util.ArrayList;
import java.util.List;

public class Stacja {

    String nazwa, adres;
    List<Pracownik> pracownikList = new ArrayList<>(); // *

    public Stacja(String nazwa, String adres){
        this.nazwa = nazwa;
        this.adres = adres;

        //Zwykla asocjacja
        //this.pracownik = pracownik;
    }


    public void addPracownik(Pracownik pracownik) {
        if(!pracownikList.contains(pracownik)){
            pracownikList.add(pracownik);
            // I odwrotnie
            pracownik.addStacja(this);
        }
    }

    /*
    public Stacja findStacja(int id) throws Exception {
        for(Stacja s : ){
            if(p.id == id){
                return p;
            }
        }
        throw new Exception("Nie udało się znaleźć pracownika"+id);
    }

     */

    public String toString() {
        String info = "Stacja: " + nazwa + "\n";
        for(Pracownik p : pracownikList) {
            info += "Pracownicy stacji: " + p.imie +" "+p.nazwisko + "\n";
        }
        return info;
    }


}
