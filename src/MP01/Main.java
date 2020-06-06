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
            //Tylko wyświetlamy dane jeżeli plik istnieje
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            MainExt.readExtent(in);
            MainExt.getExt();


            //Implementacja GUI
            JFrame jZakupy = new JFrame("Zakupy");
            jZakupy.setContentPane(new ZakupyGUI().panel1);
            jZakupy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jZakupy.pack();
            jZakupy.setVisible(true);

            JFrame jKlient = new JFrame("Klient");
            jKlient.setContentPane(new KlientGUI().panel1);
            jKlient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jKlient.pack();
            jKlient.setVisible(true);

            JFrame jStacja = new JFrame("Stacja");
            jStacja.setContentPane(new StacjaGUI().panel1);
            jStacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jStacja.pack();
            jStacja.setVisible(true);

            JFrame jFaktura = new JFrame("Faktura");
            jFaktura.setContentPane(new FakturaGUI().panel1);
            jFaktura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFaktura.pack();
            jFaktura.setVisible(true);

            JFrame jPracownik = new JFrame("Pracownik");
            jPracownik.setContentPane(new PracownikGUI().panel1);
            jPracownik.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jPracownik.pack();
            jPracownik.setVisible(true);


            in.close();
        }else{
            //Wpisujemy dane do pliku
            Osoba andrzej = new Osoba("Andrzej", "Kowalski", LocalDate.of(1991, Month.AUGUST,5));
            Pracownik filip = new Pracownik("Filip","Smosna",LocalDate.of(1996,Month.APRIL,14),LocalDate.of(2019,Month.JANUARY,1),1);
            Kierownik janusz = new Kierownik("Janusz","Nowak",LocalDate.of(1985,Month.APRIL,1),LocalDate.of(2018,Month.JANUARY,1),2);
            Klient seba = new Klient("Sebastian","Majczyna",LocalDate.of(1999,Month.JUNE,20));
            Klient pawel = new Klient("Paweł","Ziąb",LocalDate.of(1977,Month.JUNE,15));


            //MP1
            seba.sprawdzIloscPunktow();
            janusz.sprawdzStazPracy();
            janusz.sprawdzStazPracy(LocalDate.of(2020,Month.JANUARY,2));
            //seba.podajDaneDoFaktury(new Faktura("Seba company",8201193,"Warszawa","Daleka","02-670"));
            seba.policzWiek();

            //MP2 asocjacja zwykłą
            Stacja orlen = new Stacja("Orlen","Warszawa, 02-405 Złota");
            Faktura faktura = new Faktura("Seba company",8201193,"Warszawa","Daleka","02-670");

            filip.addStacja(orlen);
            janusz.addStacja(orlen);

            System.out.println(orlen);
            System.out.println(janusz);

            //Tankowanie - asocjacja z atrybutem
            //orlen.addTankowanieS(35,"LPG",false,seba);
            Zakupy ks = new Zakupy(seba,orlen,40,"diesel");
            seba.addTankowanieK(ks);



            seba.addFakturaQualif(faktura);
            seba.findFakturaQualif(8201193);
            //Kompozycja
            seba.createKarta(112);

            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            Osoba.writeExtent(out);
            //MainExt.getExt();
            out.close();
        }

    }
}
