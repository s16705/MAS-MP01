package MP01;

import java.time.LocalDate;

public class Pracownik extends Osoba {

    static LocalDate data_zatrudnienia;

    public Pracownik(String imie, String nazwisko, LocalDate data_urodzenia, LocalDate data_zatrudnienia) throws Exception {
        super(imie, nazwisko, data_urodzenia);
        this.data_zatrudnienia = data_zatrudnienia;
        if (data_zatrudnienia.isBefore(data_urodzenia))
            throw new Exception("Data zatrudnienia nie może być przed urodzinami");
    }

    //Przeciążanie metod
    public static void sprawdzStazPracy(){
        System.out.println("Staz pracy, w latach, wynosi "+LocalDate.now().compareTo(data_zatrudnienia));
    }

    public static void sprawdzStazPracy(LocalDate data){
        if(data.isAfter(data_zatrudnienia)){
            System.out.println("W podanej dacie, sprawdzana osoba pracowała na stacji");

        }else{
            System.out.println("W podanej dacie, sprawdzana osoba nie pracowała na stacji");

        }
    }
}
