package MP01;
import java.util.ArrayList;
import java.util.List;

public class Stacja extends MainExt {

    String nazwa, adres;
    List<Pracownik> pracownikList = new ArrayList<>(); // *
    //Asocjacja z atrybutem
    //KlientStacja ks;
    List<Zakupy> klientList;

    public Stacja(String nazwa, String adres){
        this.nazwa = nazwa;
        this.adres = adres;
        this.klientList = new ArrayList<Zakupy>();

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
    public void addTankowanieS(Zakupy ks){
        if(!klientList.contains(ks)){
            klientList.add(ks);
            ks.addTankowanieK(this);
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
        for(Zakupy k : klientList){
            info += "KlientStacja: "+k.klient+k.stacja+k.iloscPaliwa;
        }
        return info;
    }


}
