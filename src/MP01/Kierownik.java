package MP01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kierownik extends Pracownik {

    int id_zarzadzanej_stacji;
    LocalDate data_zostania_kierownikiem;
    List<Zamowienie> listaZamowien = new ArrayList<>();

    public Kierownik(String imie, String nazwisko, LocalDate data_urodzenia, LocalDate data_zatrudnienia, LocalDate data_zostania_kierownikiem) throws Exception {
        super(imie, nazwisko, data_urodzenia, data_zatrudnienia);
        if (data_zostania_kierownikiem.isBefore(data_zatrudnienia))
            throw new Exception("Data zostania kierwonikiem nie może być przed datą rozpoczęcia pracy");
        this.id_zarzadzanej_stacji = new Random().nextInt(1000);
    }

    public void addZamowienie(Zamowienie zamowienie) {
        if(!listaZamowien.contains(zamowienie)){
            listaZamowien.add(zamowienie);
            // I odwrotnie
            zamowienie.addKierownik(this);
        }
    }

    public String toString(){
        return"Dane Kierownika. Imie: "+imie+"\nNazwisko: "+nazwisko+"\nData urodzenia: "+data_urodzenia+"\nData zatrudnienia: "+data_zatrudnienia+"\nStacja na ktorej jest kierownikiem: "+id_zarzadzanej_stacji+"\n";
    }
}
