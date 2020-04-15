package MP01;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;


public class Main {

    public static void main(String[] args) throws Exception {

        Osoba andrzej = new Osoba("Andrzej", "Kowalski", LocalDate.of(1991, Month.AUGUST,5));
        Kierownik janusz = new Kierownik("Janusz","Nowak",LocalDate.of(1985,Month.APRIL,1),LocalDate.of(2018,Month.JANUARY,1));
        Klient seba = new Klient("Janusz","Nowak",LocalDate.of(1999,Month.JUNE,20));
        seba.sprawdzIloscPunktow();
        janusz.sprawdzStazPracy();
        janusz.sprawdzStazPracy(LocalDate.of(2020,Month.JANUARY,2));

        File file = new File("archiwum.txt");
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        Osoba.writeExtent(out);
        out.close();
        Osoba.getExt();

    }
}
