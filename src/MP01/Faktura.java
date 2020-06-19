package MP01;

import java.time.LocalDate;

public class Faktura extends MainExt {

    String daneNabywcy;
    int NIP;
    int podatek_VAT = 19;
    double kwota;
    LocalDate dataWystawienia;
    //Asocjacja kwalifikowana
    private Klient klient;

    public Faktura(LocalDate dataWystawienia, int NIP, String daneNabywcy, double kwota, int podatek_VAT){
        this.dataWystawienia = dataWystawienia;
        this.NIP = NIP;
        this.daneNabywcy = daneNabywcy;
        this.kwota = kwota;
        this.podatek_VAT = podatek_VAT;
    }

    public void addKlientQualif(Klient klient) {
        if(this.klient != klient){
            this.klient = klient;
            // reverse
            klient.addFakturaQualif(this);
        }
    }

    public String toString(){
        return "Dane faktury. :\nNIP: "+NIP+"\nDane nabywcy: "+daneNabywcy+"\nKwota: "+kwota+"\nWysokosc podatku VAT: "+podatek_VAT+"\n";
    }



}
