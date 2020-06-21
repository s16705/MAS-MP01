package GUI;

import MP01.Klient;
import MP01.Main;
import MP01.Stacja;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WyborKlientaGUI {
    public JPanel panel1;
    JTextField imieField;
    static String imie;
    JTextField nazwiskoField;
    static String nazwisko;
    private JButton wprowadźDaneButton;
    private JTextField nazwaStacjiField;
    private JButton historiaButton;
    ArrayList<Klient> listaKlientow = new ArrayList<>();
    ArrayList<String> listaImion = new ArrayList<>();
    ArrayList<String> listaNazwisk = new ArrayList<>();
    ArrayList<Stacja> listaStacji = new ArrayList<>();
    ArrayList<String> listaNazwStacji = new ArrayList<>();

    public WyborKlientaGUI(){
        initialize();
        wprowadźDaneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Klient k : listaKlientow) {
                    if(k.getImie().equals(imieField.getText()) && k.getNazwisko().equals(nazwiskoField.getText())) {
                        System.out.println("Dane klienta poprawne!");
                        for (Stacja s : listaStacji) {
                            if (s.getNazwa().equals(nazwaStacjiField.getText())){
                                System.out.println("Nazwa stacji prawidlowa!");
                                JFramesController.zacznijZakupy();
                                imie = imieField.getText();
                                nazwisko = nazwiskoField.getText();
                                JFramesController.jWybor.dispose();
                            }
                        }
                    }
                }
            }
        });

        historiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFramesController.historia();
            }
        });
    }

    public void initialize(){
        listaKlientow.addAll(Klient.getAllKlients());
        listaStacji.addAll(Stacja.getAllStacje());

        for (Klient k : listaKlientow) {
            listaImion.add(k.getImie());
            listaNazwisk.add(k.getNazwisko());
        }
        for (Stacja s : listaStacji){
            listaNazwStacji.add(s.getNazwa());
        }


    }

}
