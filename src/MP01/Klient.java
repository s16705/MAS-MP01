package MP01;

import java.util.*;

public class Klient extends Osoba {

    int iloscOdwiedzinStacji;
    //Atrybut złożony i opcjonalny
    Faktura daneDoFaktury;
    //Asocjacja z atrybutem
    List<Zakupy> stacjaList;
    //Asocjacja kwalifikowana
    private Map<Integer, Faktura> fakturaQualif = new TreeMap<>();


    //Przeciążenie metod
    public Klient(String imie, String nazwisko) {
        super(imie, nazwisko);
        this.stacjaList = new ArrayList<Zakupy>();
    }

    public void podajDaneDoFaktury(Faktura faktura){
        this.daneDoFaktury = faktura;
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

    //Przesłonięcie metody
    public String toString() {
        return "Dane Klienta. Imie: "+imie+"\nNazwisko: "+nazwisko+"\n";

    }


}
