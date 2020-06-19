package MP01;

import java.time.LocalDate;

public class Pracownik extends Osoba {

    final LocalDate data_urodzenia;
    //Atrybut pochodny
    static int staz;
    static LocalDate data_zatrudnienia;
    Stacja stacja;


    public Pracownik(String imie, String nazwisko, LocalDate data_urodzenia, LocalDate data_zatrudnienia) throws Exception {
        super(imie, nazwisko);
        this.data_urodzenia = data_urodzenia;
        this.data_zatrudnienia = data_zatrudnienia;
        if (data_zatrudnienia.isBefore(data_urodzenia))
            throw new Exception("Data zatrudnienia nie może być przed urodzinami");
    }

    //Przeciążanie metod
    public static void sprawdzStazPracy(){
        //Atrybut pochodny
        staz = LocalDate.now().compareTo(data_zatrudnienia);
        System.out.println("Staz pracy, w latach, wynosi "+staz);
    }

    // Zwykla asocjacja
    public void addStacja(Stacja stacja){
        if(!stacja.equals(this.stacja)){
            this.stacja = stacja;
            // I odwrotnie
            stacja.addPracownik(this);
        }
    }

    public void wystawFakture(Klient klient, Faktura faktura){
        klient.addFakturaQualif(faktura);
    }

    public String toString(){
        return "Dane Pracownika. Imie: "+imie+"\nNazwisko: "+nazwisko+"\nData urodzenia: "+data_urodzenia+"\nData zatrudnienia: "+data_zatrudnienia+"\nStacja na ktorej pracuje: "+stacja.nazwa+" Adres: "+stacja.adres + "\n";
    }
}
