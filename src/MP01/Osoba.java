package MP01;

import java.time.LocalDate;

public class Osoba extends MainExt {

    String imie, nazwisko;
    LocalDate data_urodzenia;

    public Osoba(String imie, String nazwisko, LocalDate data_urodzenia){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.data_urodzenia = data_urodzenia;
    }



}
