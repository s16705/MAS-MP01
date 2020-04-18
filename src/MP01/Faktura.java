package MP01;

public class Faktura extends MainExt {

    String nazwa, miasto, ulica, kodPocztowy;
    int NIP;

    public Faktura(String nazwa, int NIP, String miasto, String ulica, String kodPocztowy){
        this.nazwa = nazwa;
        this.NIP = NIP;
        this.miasto = miasto;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
    }

    public String toString(){

        return "Dane faktury. Nazwa firmy: "+nazwa+"\nNIP: "+NIP+"\nMiasto: "+miasto+"\nUlica: "+ulica+"\nKod Pocztowy: "+kodPocztowy;
    }



}
