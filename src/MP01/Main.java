package MP01;

import GUI.*;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("archiwum.txt");


        if(file.exists()){
            Klient seba = new Klient("Sebastian","Majczyna");
            Klient jan = new Klient("Jan","Kowalski");
            Stacja orlen = new Stacja("Orlen","Warszawa, 02-405 Złota 12");
            Stacja shell = new Stacja("Shell","Sochaczew, 02-405 Grunwaldzka 122Seba");

            //Tylko wyświetlamy dane jeżeli plik istnieje
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            MainExt.readExtent(in);
            MainExt.getExt();

            JFramesController.start();



            in.close();
        }else{
            //Wpisujemy dane do pliku
            Osoba andrzej = new Osoba("Andrzej", "Kowalski");
            Pracownik filip = new Pracownik("Filip","Smosna",LocalDate.of(1996,Month.APRIL,14),LocalDate.of(2019,Month.JANUARY,1));
            Kierownik janusz = new Kierownik("Janusz","Nowak",LocalDate.of(1985,Month.APRIL,1),LocalDate.of(2018,Month.JANUARY,1),LocalDate.of(2019,Month.JANUARY,1));
            Klient seba = new Klient("Sebastian","Majczyna");
            Klient jan = new Klient("Jan","Kowalski");
            Kierowca pawel = new Kierowca("Paweł","Ziąb");
            Samochod fabia = new Samochod("WPR 04635",1995,"Hatchback","GE5HJA4532FB43");

            Klient test = new Klient("t","t");
            Stacja test2 = new Stacja("t","Lódź, 43-405 1-maja 22");

            //MP2 asocjacja zwykłą
            Stacja orlen = new Stacja("Orlen","Warszawa, 02-405 Złota");
            Faktura faktura = new Faktura(LocalDate.now(),8201193,"Warszawa 02-670, Złota 12",199.99,19);

            filip.addStacja(orlen);
            janusz.addStacja(orlen);

            System.out.println(orlen);
            System.out.println(janusz);

            Zakupy ks = new Zakupy(seba,orlen);
            pawel.addSamochod(fabia);
            pawel.createKarta(112,"Pruszkow, 90-456 ul. Piastowska 13/42");

            seba.addFakturaQualif(faktura);
            seba.findFakturaQualif(8201193);

            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            Osoba.writeExtent(out);
            //MainExt.getExt();
            out.close();
        }

    }
}
