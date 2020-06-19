package MP01;

public class Osoba extends MainExt {

    String imie, nazwisko;

    public Osoba(String imie, String nazwisko){
        this.imie=imie;
        this.nazwisko=nazwisko;
    }

//    //Metoda klasowa
//    public static void policzWiek(){
//        System.out.println("Wiek wynosi (w latach): "+LocalDate.now().compareTo(data_urodzenia_static));
//    }

    public String toString(){
        return "Dane Osoby. Imie: "+imie+" Nazwisko: "+nazwisko+"\n";
    }
}
