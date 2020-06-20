package MP01;

import javax.sound.midi.SysexMessage;
import java.sql.SQLOutput;
import java.util.*;

public class Klient extends Osoba {

    int iloscOdwiedzinStacji;
    //Atrybut złożony i opcjonalny
    Faktura daneDoFaktury;
    //Asocjacja z atrybutem
    List<Zakupy> stacjaList;
    //Asocjacja kwalifikowana
    private Map<Integer, Faktura> fakturaQualif = new TreeMap<>();
    private static Map<Class, List<Klient>> mapaKlientow = new Hashtable<>();
    List<Klient> listaKlientow = new ArrayList<>();

    //Przeciążenie metod
    public Klient(String imie, String nazwisko) {
        super(imie, nazwisko);
        this.stacjaList = new ArrayList<Zakupy>();
        listaKlientow.add(this);
        mapaKlientow.put(Klient.class, listaKlientow);
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

//    public static <T> List<T> getListaKlientow(Class klasa){
//        List<Klient> klientList = null;
//        if (listaKlientow.containsKey(klasa)){
//            klientList = listaKlientow.get(klasa);
//            for (Klient kl : klientList){
//                System.out.println(klasa.toString() + " " + kl);
//            }
//        }else{
//            System.out.println("Brak klientow");
//        }
//        return (List<T>) klientList;
//    }

    public Faktura findFakturaQualif(int NIP) throws Exception{
        if(!fakturaQualif.containsKey(NIP)){
            throw new Exception("Nie udalo sie znaleźć podanego NIPu" + NIP);
        }
        return fakturaQualif.get(NIP);
    }

    public static List<Klient> getAllKlients(Class klasa){
        List<Klient> result = null;
        if (mapaKlientow.containsKey(klasa)) {
            result = mapaKlientow.get(klasa);
            for (Klient k : result) {
                System.out.println("All klients " + klasa.toString() + " " + k);
            }
        }else{
            System.out.println("Brak klientow");
        }
        return result;
    }

    public String getImie(){
        return imie;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    //Przesłonięcie metody
    public String toString() {
        return "Dane Klienta. Imie: "+imie+"\nNazwisko: "+nazwisko+"\n";

    }


}
