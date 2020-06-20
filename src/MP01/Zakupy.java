package MP01;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Zakupy extends MainExt {

    Klient klient;
    Stacja stacja;
    private LocalDate dataZakupow;
    public List<String> dostepneProdukty;

    public Zakupy(Klient klient, Stacja stacja){
        this.klient = klient;
        this.stacja = stacja;
        this.dataZakupow = LocalDate.now();
        dostepneProdukty = Arrays.asList("Płyn do spryskiwaczy", "Batonik");
    }

    public List<String> getDostepneProdukty(){
        return dostepneProdukty;
    }

//    public void dostepneProdukty(){
//        this.dostepneProdukty.add("Płyn do spryskiwaczy");
//        this.dostepneProdukty.add("Batonik");
//    }

    //Asocjacja z atrybutem
    /*
    public KlientStacja(int iloscPaliwa, String paliwo, boolean czyFaktura){
        this.iloscPaliwa = iloscPaliwa;
        this.paliwo = paliwo;
        this.czyFaktura = czyFaktura;
    }
     */

    //Potrzeba zmienic na zakupy zamiast tankowania

//    public void addTankowanieS(Klient klient) {
//        if(this.klient != klient){
//            this.klient = klient;
//            klient.addTankowanieK(this);
//        }
//    }
//
//    public void addTankowanieK(Stacja stacja) {
//        if(this.stacja != stacja){
//            this.stacja = stacja;
//            stacja.addTankowanieS(this);
//        }
//    }

    public String toString(){
        return "Klient "+klient+" zatankował dnia "+ dataZakupow +" na stacji "+stacja+"\nLista produktow: "+"\n";
    }
}