package MP01;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie extends MainExt {
    int numer;
    double kwotaNetto, kwotaBrutto;
    List<String> listaZamowionychProduktow = new ArrayList<>();
    Kierownik kierownik;
    Dostawca dostawca;

    public Zamowienie(int numer, double kwotaNetto, double kwotaBrutto, List<String> listaZamowionychProduktow){
        this.numer = numer;
        this.kwotaNetto = kwotaNetto;
        this.kwotaBrutto = kwotaBrutto;
        this.listaZamowionychProduktow = listaZamowionychProduktow;
    }

    public void addKierownik(Kierownik kierownik){
        if(!kierownik.equals(this.kierownik)){
            this.kierownik = kierownik;
            // I odwrotnie
            kierownik.addZamowienie(this);
        }
    }

    public void addDostawca(Dostawca dostawca){
        if(!dostawca.equals(this.dostawca)){
            this.dostawca = dostawca;
            // I odwrotnie
            dostawca.addZamowienie(this);
        }
    }

    public String toString(){
        return "Zamowienie nr "+numer+" na kwote Netto: "+kwotaNetto+" (Brutto): "+kwotaBrutto+"\nLista zamowionych produktow: "+listaZamowionychProduktow.toArray();
    }
}
