package MP01;

public class Faktura extends MainExt {

    String nazwa, miasto, ulica, kodPocztowy;
    int NIP;
    //Asocjacja kwalifikowana
    private Klient klient;

    public Faktura(String nazwa, int NIP, String miasto, String ulica, String kodPocztowy){
        this.nazwa = nazwa;
        this.NIP = NIP;
        this.miasto = miasto;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
    }

    public void addKlientQualif(Klient klient) {
        if(this.klient != klient){
            this.klient = klient;
            // reverse
            klient.addFakturaQualif(this);
        }
    }

    public String toString(){

        return "Dane faktury. Nazwa firmy: "+nazwa+"\nNIP: "+NIP+"\nMiasto: "+miasto+"\nUlica: "+ulica+"\nKod Pocztowy: "+kodPocztowy+"\n";
    }



}
