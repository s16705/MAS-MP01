package MP01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pracownik extends Osoba {

    LocalDate data_zatrudnienia;
    //Atrybut pochodny
    static int staz;
    static LocalDate data_zatrudnienia_static;
    int id;
    List<Stacja> stacjaList = new ArrayList<>(); // *


    public Pracownik(String imie, String nazwisko, LocalDate data_urodzenia, LocalDate data_zatrudnienia, int id) throws Exception {
        super(imie, nazwisko, data_urodzenia);
        this.data_zatrudnienia = data_zatrudnienia;
        this.data_zatrudnienia_static = data_zatrudnienia;
        this.id = id;
        if (data_zatrudnienia.isBefore(data_urodzenia))
            throw new Exception("Data zatrudnienia nie może być przed urodzinami");
    }

    //Przeciążanie metod
    public static void sprawdzStazPracy(){
        //Atrybut pochodny
        staz = LocalDate.now().compareTo(data_zatrudnienia_static);
        System.out.println("Staz pracy, w latach, wynosi "+staz);
    }

    public static void sprawdzStazPracy(LocalDate data){
        if(data.isAfter(data_zatrudnienia_static)){
            System.out.println("W podanej dacie, sprawdzana osoba pracowała na stacji");

        }else{
            System.out.println("W podanej dacie, sprawdzana osoba nie pracowała na stacji");

        }
    }

    // Zwykla asocjacja
    public void addStacja(Stacja stacja){
        if(!stacjaList.contains(stacja)){
            stacjaList.add(stacja);
            // I odwrotnie
            stacja.addPracownik(this);
        }
    }

    public String toString(){
        String info = "Dane Pracownika. Imie: "+imie+"\nNazwisko: "+nazwisko+"\nData urodzenia: "+data_urodzenia+"\nData zatrudnienia: "+data_zatrudnienia+"\n";
        for(Stacja s : stacjaList) {
            info += "Stacja na ktorej pracuje: " + s.nazwa +" Adres: "+s.adres + "\n";
        }
        return info;
    }
}
