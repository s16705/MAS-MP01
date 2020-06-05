package MP01;

import java.time.LocalDate;
import java.util.*;

public class Klient extends Osoba {

    //Atrybut klasowy
    static int pktNaKarcie = 0;
    //Atrybut złożony i opcjonalny
    Faktura daneDoFaktury;
    //Asocjacja z atrybutem
    List<Zakupy> stacjaList;
    //Asocjacja kwalifikowana
    private Map<Integer, Faktura> fakturaQualif = new TreeMap<>();
    //Kompozycja
    private List<KartaLojalnosciowa> listaKart = new ArrayList<>();

    //Przeciążenie metod
    public Klient(String imie, String nazwisko, LocalDate data_urodzenia) {
        super(imie, nazwisko, data_urodzenia);
        this.stacjaList = new ArrayList<Zakupy>();
    }

    /*
    public Klient(String imie, String nazwisko, LocalDate data_urodzenia, Faktura faktura) {
        super(imie, nazwisko, data_urodzenia);
        this.daneDoFaktury = faktura;
        this.ks = new KlientStacja();
    }

     */

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

    //Asocjacja z atrybutem
    public void addTankowanieK(Zakupy ks) {

        if(!stacjaList.contains(ks)){
            stacjaList.add(ks);
            ks.addTankowanieS(this);
        }
    }

    //Asocjacja kwalifikowana
    public void addFakturaQualif(Faktura faktura){
        if(!fakturaQualif.containsKey(faktura.NIP)){
            fakturaQualif.put(faktura.NIP, faktura);
            // reverse
            faktura.addKlientQualif(this);
        }
    }

    public Faktura findFakturaQualif(int NIP) throws Exception{
        if(!fakturaQualif.containsKey(NIP)){
            throw new Exception("Nie udalo sie znaleźć podanego NIPu" + NIP);
        }
        return fakturaQualif.get(NIP);
    }

    //Kompozycja
    public KartaLojalnosciowa createKarta(int numerKarty){
        KartaLojalnosciowa karta = new KartaLojalnosciowa(numerKarty);
        listaKart.add(karta);

        return karta;
    }

    //Przesłonięcie metody
    public String toString() {
        if (daneDoFaktury == null){
            return "Dane Klienta. Imie: "+imie+"\nNazwisko: "+nazwisko+"\nData urodzenia: "+data_urodzenia+"\n";

        }else{
            return "Dane Klienta. Imie: "+imie+"\nNazwisko: "+nazwisko+"\nData urodzenia: "+data_urodzenia+"\n";
        }
    }




    public class KartaLojalnosciowa extends MainExt {
        private int numerKarty;

        public KartaLojalnosciowa(int numerKarty){
            this.numerKarty = numerKarty;
        }

        public String toString(){
            return "Numer karty lojalnościowej: "+numerKarty;
        }

    }

}
