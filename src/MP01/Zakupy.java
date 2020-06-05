package MP01;

import java.time.LocalDate;
import java.util.*;

public class Zakupy extends MainExt {


    int iloscPaliwa;
    String paliwo;
    boolean czyFaktura;

    Klient klient;
    Stacja stacja;
    private LocalDate dataTankowania;

    public Zakupy(){
        this.dataTankowania = LocalDate.now();
    }

    public Zakupy(Klient klient, Stacja stacja, int iloscPaliwa, String paliwo){
        this.klient = klient;
        this.stacja = stacja;
        this.dataTankowania = LocalDate.now();
        this.iloscPaliwa = iloscPaliwa;
        this.paliwo = paliwo;

    }

    //Asocjacja z atrybutem
    /*
    public KlientStacja(int iloscPaliwa, String paliwo, boolean czyFaktura){
        this.iloscPaliwa = iloscPaliwa;
        this.paliwo = paliwo;
        this.czyFaktura = czyFaktura;
    }
     */
    public void addTankowanieS(Klient klient) {
        if(this.klient != klient){
            this.klient = klient;
            klient.addTankowanieK(this);
        }
    }

    public void addTankowanieK(Stacja stacja) {
        if(this.stacja != stacja){
            this.stacja = stacja;
            stacja.addTankowanieS(this);
        }
    }


    public String toString(){
        return "Klient "+klient+" zatankował dnia "+dataTankowania+" na stacji "+stacja+"\n"+iloscPaliwa+" litrów paliwa "+paliwo+"\n";
    }


}

