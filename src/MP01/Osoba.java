package MP01;

import java.time.LocalDate;

public class Osoba extends MainExt {

    String imie, nazwisko;
    LocalDate data_urodzenia;
    static LocalDate data_urodzenia_static;

    public Osoba(String imie, String nazwisko, LocalDate data_urodzenia){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.data_urodzenia_static = data_urodzenia;
    }

    //Metoda klasowa
    public static void policzWiek(){
        System.out.println("Wiek wynosi (w latach): "+LocalDate.now().compareTo(data_urodzenia_static));
    }

    public String toString(){
        return "Dane Osoby. Imie: "+imie+"\nNazwisko: "+nazwisko+"\nData urodzenia: "+data_urodzenia+"\n";
    }
}
