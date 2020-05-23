package MP01;

import java.time.LocalDate;
import java.util.Random;

public class Kierownik extends Pracownik {

    int id_zarzadzanej_stacji;

    public Kierownik(String imie, String nazwisko, LocalDate data_urodzenia, LocalDate data_zatrudnienia, int id) throws Exception {
        super(imie, nazwisko, data_urodzenia, data_zatrudnienia, id);
        this.id_zarzadzanej_stacji = new Random().nextInt(1000);
    }

    public String toString(){
        String info = "Dane Kierownika. Imie: "+imie+"\nNazwisko: "+nazwisko+"\nData urodzenia: "+data_urodzenia+"\nData zatrudnienia: "+data_zatrudnienia+"\n";
        for(Stacja s : stacjaList) {
            info += "Stacja na ktorej jest kierownikiem: " + s.nazwa +" Adres: "+s.adres + "\n";
        }
        return info;
    }

}
