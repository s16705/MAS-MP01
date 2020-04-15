package MP01;

import java.time.LocalDate;

public class Klient extends Osoba {

    static int pktNaKarcie = 0;

    public Klient(String imie, String nazwisko, LocalDate data_urodzenia) {
        super(imie, nazwisko, data_urodzenia);
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
}
