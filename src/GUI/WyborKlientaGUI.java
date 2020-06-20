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
                                zacznijZakupy();
                                imie = imieField.getText();
                                nazwisko = nazwiskoField.getText();
                                Main.dispose();
                            }
                        }
                    }
                }
            }
        });
    }

    void zacznijZakupy(){
        System.out.println(imieField.getText() + " " + nazwiskoField.getText() + " rozpoczyna zakupy.");
        JFrame jZakupy = new JFrame("Zakupy");
        jZakupy.setContentPane(new ZakupyGUI().panel1);
        jZakupy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jZakupy.pack();
        jZakupy.setLocationRelativeTo(null);
        jZakupy.setVisible(true);
    }

    public void initialize(){
        listaKlientow.addAll(Klient.getAllKlients(Klient.class));
        listaStacji.addAll(Stacja.getAllStacje(Stacja.class));

        for (Klient k : listaKlientow) {
            listaImion.add(k.getImie());
            listaNazwisk.add(k.getNazwisko());
        }
        for (Stacja s : listaStacji){
            listaNazwStacji.add(s.getNazwa());
        }


    }
}
