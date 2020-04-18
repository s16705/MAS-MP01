package MP01;

import java.time.LocalDate;
import java.util.Random;

public class Kierownik extends Pracownik {

    int id_zarzadzanej_stacji;

    public Kierownik(String imie, String nazwisko, LocalDate data_urodzenia, LocalDate data_zatrudnienia) throws Exception {
        super(imie, nazwisko, data_urodzenia, data_zatrudnienia);
        this.id_zarzadzanej_stacji = new Random().nextInt(1000);
    }

    public String toString(){
        return "Dane Kierownika. Imie: "+imie+"\nNazwisko: "+nazwisko+"\nData urodzenia: "+data_urodzenia+"\nData zatrudnienia: "+data_zatrudnienia;
    }

}
