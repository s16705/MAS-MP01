package MP01;

import java.time.LocalDate;

public class Pracownik extends Osoba {

    LocalDate data_zatrudnienia;
    //Atrybut pochodny
    static int staz;
    static LocalDate data_zatrudnienia_static;

    public Pracownik(String imie, String nazwisko, LocalDate data_urodzenia, LocalDate data_zatrudnienia) throws Exception {
        super(imie, nazwisko, data_urodzenia);
        this.data_zatrudnienia = data_zatrudnienia;
        this.data_zatrudnienia_static = data_zatrudnienia;
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

    public String toString(){
        return "Dane Pracownika. Imie: "+imie+"\nNazwisko: "+nazwisko+"\nData urodzenia: "+data_urodzenia+"\nData zatrudnienia: "+data_zatrudnienia;
    }
}
