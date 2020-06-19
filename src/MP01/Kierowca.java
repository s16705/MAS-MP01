package MP01;

import java.util.ArrayList;
import java.util.List;

public class Kierowca extends Klient {

    boolean posiada_karte = false;
    //Kompozycja
    private List<KartaLojalnosciowa> listaKart = new ArrayList<>();
    List<Samochod> listaSamochodow = new ArrayList<>();


    public Kierowca(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    //Kompozycja
    public KartaLojalnosciowa createKarta(int numerKarty, String dane_wlasciciela){
        KartaLojalnosciowa karta = new KartaLojalnosciowa(numerKarty, dane_wlasciciela);
        listaKart.add(karta);
        this.posiada_karte = true;

        return karta;
    }

    public void addSamochod(Samochod samochod) {
        if(!listaSamochodow.contains(samochod)){
            listaSamochodow.add(samochod);
            // I odwrotnie
            samochod.addKierowca(this);
        }
    }

    public String toString(){
        return "Dane kierowcy: "+imie+" "+nazwisko+" Czy posiada karte: "+posiada_karte+"\n";
    }


    public class KartaLojalnosciowa extends MainExt {
        private int numerKarty;
        private int ilosc_punktow;
        private String dane_wlasciciela;

        public KartaLojalnosciowa(int numerKarty, String dane_wlasciciela){
            this.numerKarty = numerKarty;
            this.dane_wlasciciela = dane_wlasciciela;
        }

        public void dodajPunktyDoKarty(int iloscPunktow){
            ilosc_punktow += iloscPunktow;
        }

        public void sprawdzIloscPunktow(){
            System.out.println("Kierowca posiada "+ ilosc_punktow+" punktow na karcie lojanościowej zarejestrowanej na dane: "+dane_wlasciciela+ ". Numer karty: "+numerKarty+"\n");
        }

        public String toString(){
            return "Numer karty lojalnościowej: "+numerKarty+"\nIlosc punktow: "+ilosc_punktow+"\nDane wlasciciela: "+dane_wlasciciela+"\n";
        }

    }

}
