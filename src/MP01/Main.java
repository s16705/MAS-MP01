package MP01;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;


public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("archiwum.txt");

        if(file.exists()){
            //Tylko wyświetlamy dane jeżeli plik istnieje
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            MainExt.readExtent(in);
            MainExt.getExt();
            //Osoba.policzWiek();
            in.close();
        }else{
            //Wpisujemy dane do pliku
            Osoba andrzej = new Osoba("Andrzej", "Kowalski", LocalDate.of(1991, Month.AUGUST,5));
            Pracownik filip = new Pracownik("Filip","Smosna",LocalDate.of(1996,Month.APRIL,14),LocalDate.of(2019,Month.JANUARY,1),1);
            Kierownik janusz = new Kierownik("Janusz","Nowak",LocalDate.of(1985,Month.APRIL,1),LocalDate.of(2018,Month.JANUARY,1),2);
            Klient seba = new Klient("Sebastian","Majczyna",LocalDate.of(1999,Month.JUNE,20));

            //MP1
            seba.sprawdzIloscPunktow();
            janusz.sprawdzStazPracy();
            janusz.sprawdzStazPracy(LocalDate.of(2020,Month.JANUARY,2));
            seba.podajDaneDoFaktury(new Faktura("Seba company",8201193,"Warszawa","Daleka","02-670"));
            seba.policzWiek();

            //MP2
            Stacja orlen = new Stacja("Orlen","Warszawa, 02-405 Złota");

            filip.addStacja(orlen);
            janusz.addStacja(orlen);

            System.out.println(orlen);
            System.out.println(janusz);

            //Tankowanie - asocjacja z atrybutem
            orlen.addTankowanieS(50,"diesel",false,seba);
            //seba.addTankowanieK(50,"diesel",false,orlen);
    //      System.out.println(KlientStacja);


            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            Osoba.writeExtent(out);
            //MainExt.getExt();
            out.close();
        }

    }
}
