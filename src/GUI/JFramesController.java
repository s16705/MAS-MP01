package GUI;

import MP01.Zakupy;

import javax.swing.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class JFramesController {
    static JFrame jWybor;
    static JFrame jZakupy;
    static JFrame jPotwierdzenie;
    static JFrame jHistoria;


    public static void start(){
        jWybor = new JFrame("Wybor klienta");
        jWybor.setContentPane(new WyborKlientaGUI().panel1);
        jWybor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jWybor.pack();
        jWybor.setVisible(true);
    }

    public static void zacznijZakupy(){
        System.out.println(WyborKlientaGUI.imie + " " + WyborKlientaGUI.nazwisko + " rozpoczyna zakupy.");
        jZakupy = new JFrame("Zakupy");
        jZakupy.setContentPane(new ZakupyGUI().panel1);
        jZakupy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jZakupy.pack();
        jZakupy.setLocationRelativeTo(null);
        jZakupy.setVisible(true);
    }

    public static void potwierdzenie(){
        if(ZakupyGUI.suma != 0){
            jPotwierdzenie = new JFrame("Potwierdzenie zakupow");
            jPotwierdzenie.setContentPane(new PotwierdzenieGUI().panel1);
            jPotwierdzenie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jPotwierdzenie.pack();
            jPotwierdzenie.setLocationRelativeTo(null);
            jPotwierdzenie.setVisible(true);
        }else{
            System.out.println("Wybierz conajmniej 1 produkt");
        }
    }

    public static void historia(){
        jHistoria = new JFrame("Historia zakupow");
        jHistoria.setContentPane(new HistoriaZakupowGUI().panel1);
        jHistoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jHistoria.pack();
        jHistoria.setLocationRelativeTo(null);
        jHistoria.setVisible(true);
    }

    public static void zapisDoPliku(){
        int val = ZakupyGUI.wybraneProdukty.size();
        PrintWriter writer = null;
        String result = null;
        try{
            writer = new PrintWriter(new FileWriter("Historia.txt",true));
            result = "\nKlient "+WyborKlientaGUI.imie+" "+WyborKlientaGUI.nazwisko+" zakupił produkty ";
            for (int i=0;i<val;i++){
                result += ZakupyGUI.wybraneProdukty.get(i)+", ";
            }
            result += "za kwotę "+ZakupyGUI.suma+"zł. Data zakupów: "+ZakupyGUI.dataZakupow.toString();
            writer.append(result);

        }catch (Exception e){

        }finally {
            writer.close();
        }
    }

}
