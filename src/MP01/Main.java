package MP01;

import GUI.*;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    static JFrame jWybor;

    public static void main(String[] args) throws Exception {
        File file = new File("archiwum.txt");


        if(file.exists()){
            Klient seba = new Klient("Sebastian","Majczyna");
            Klient jan = new Klient("Jan","Kowalski");
            Klient test = new Klient("t","t");
            Stacja test2 = new Stacja("t","Lódź, 43-405 1-maja 22");
            Stacja orlen = new Stacja("Orlen","Warszawa, 02-405 Złota 12");

            //Tylko wyświetlamy dane jeżeli plik istnieje
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            MainExt.readExtent(in);
            MainExt.getExt();


            //Implementacja GUI
//            JFrame jZakupy = new JFrame("Zakupy");
//            jZakupy.setContentPane(new ZakupyGUI().panel1);
//            jZakupy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jZakupy.pack();
//            jZakupy.setVisible(true);
//
//            JFrame jKlient = new JFrame("Klient");
//            jKlient.setContentPane(new KlientGUI().panel1);
//            jKlient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jKlient.pack();
//            jKlient.setVisible(true);
//
//            JFrame jStacja = new JFrame("Stacja");
//            jStacja.setContentPane(new StacjaGUI().panel1);
//            jStacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jStacja.pack();
//            jStacja.setVisible(true);
//
//            JFrame jFaktura = new JFrame("Faktura");
//            jFaktura.setContentPane(new FakturaGUI().panel1);
//            jFaktura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jFaktura.pack();
//            jFaktura.setVisible(true);
//
//            JFrame jPracownik = new JFrame("Pracownik");
//            jPracownik.setContentPane(new PracownikGUI().panel1);
//            jPracownik.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jPracownik.pack();
//            jPracownik.setVisible(true);



            jWybor = new JFrame("Wybor klienta");
            jWybor.setContentPane(new HistoriaZakupowGUI().panel1);
            jWybor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jWybor.pack();
            jWybor.setVisible(true);


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

    public static void dispose(){
        jWybor.dispose();
    }
}
