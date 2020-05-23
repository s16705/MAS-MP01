package MP01;
import java.util.ArrayList;
import java.util.List;

public class Stacja extends MainExt {

    String nazwa, adres;
    List<Pracownik> pracownikList = new ArrayList<>(); // *
    KlientStacja ks = new KlientStacja(0,"",false);

    public Stacja(String nazwa, String adres){
        this.nazwa = nazwa;
        this.adres = adres;

    }

    //Zwykla asocjacja
    public void addPracownik(Pracownik pracownik) {
        if(!pracownikList.contains(pracownik)){
            pracownikList.add(pracownik);
            // I odwrotnie
            pracownik.addStacja(this);
        }
    }

    //Asocjacja z atrybutem
    public void addTankowanieS(int iloscPaliwa, String paliwo, boolean czyFaktura, Klient klient){
        if(!ks.klientSet.contains(klient)){
            ks.klientSet.add(klient);
            klient.addTankowanieK(iloscPaliwa,paliwo,czyFaktura,this);
        }
    }

    /*
    public Stacja findStacja(int id) throws Exception {
        for(Stacja s : ){
            if(p.id == id){
                return p;
            }
        }
        throw new Exception("Nie udało się znaleźć pracownika"+id);
    }

     */

    public String toString() {
        String info = "Stacja: " + nazwa + "\n";
        for(Pracownik p : pracownikList) {
            info += "Pracownicy stacji: " + p.imie +" "+p.nazwisko + "\n";
        }
        return info;
    }


}
