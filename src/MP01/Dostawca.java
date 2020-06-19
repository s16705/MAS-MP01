package MP01;

import java.util.ArrayList;
import java.util.List;

public class Dostawca {
    String nazwa, adres;
    List<String> artykuly = new ArrayList<>();
    List<Zamowienie> listaZamowien = new ArrayList<>();

    public Dostawca(String nazwa, String adres){
        this.nazwa = nazwa;
        this.adres = adres;
    }

    public void addZamowienie(Zamowienie zamowienie) {
        if(!listaZamowien.contains(zamowienie)){
            listaZamowien.add(zamowienie);
            // I odwrotnie
            zamowienie.addDostawca(this);
        }
    }

    public String toString(){
        return "Nazwa dostawcy: "+nazwa+" Adres firmy:"+adres+"\nLista artykulow: "+artykuly.toArray();
    }
}
