package MP01;

import java.time.LocalDate;

public class Klient extends Osoba {

    //Atrybut klasowy
    static int pktNaKarcie = 0;

    //Atrybut złożony i opcjonalny
    Faktura daneDoFaktury;

    //Przeciążenie metod
    public Klient(String imie, String nazwisko, LocalDate data_urodzenia) {
        super(imie, nazwisko, data_urodzenia);
    }

    public Klient(String imie, String nazwisko, LocalDate data_urodzenia, Faktura faktura) {
        super(imie, nazwisko, data_urodzenia);
        this.daneDoFaktury = faktura;
    }

    public void podajDaneDoFaktury(Faktura faktura){
        this.daneDoFaktury = faktura;
    }

    public static void dodajPunktyDoKarty(int iloscPunktow){
        pktNaKarcie +=iloscPunktow;
    }

    public static void odejmijPunktyZKarty(int iloscPunktow){
        pktNaKarcie -=iloscPunktow;
    }

    public static void sprawdzIloscPunktow(){
        System.out.println("Klient posiada "+ pktNaKarcie+" punktow na karcie lojanościowej");
    }

    //Przesłonięcie metody
    public String toString() {
        if (daneDoFaktury == null){
            return "Dane Klienta. Imie: "+imie+"\nNazwisko: "+nazwisko+"\nData urodzenia: "+data_urodzenia;
        }else{
            return "Dane Klienta. Imie: "+imie+"\nNazwisko: "+nazwisko+"\nData urodzenia: "+data_urodzenia;
        }
    }
}
