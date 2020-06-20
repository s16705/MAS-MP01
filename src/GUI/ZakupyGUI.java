package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZakupyGUI {
    public JPanel panel1;
    private JButton zakupButton;
    private JTextField dataField;
    private JList<String> jLista;
    private JButton plusButton;
    private JLabel counter;
    private JLabel cena;
    Integer counterInt = 0;
    static Integer suma = 0;
    LocalDate data;
    HashMap<String, Integer> cennik = new HashMap<String, Integer>();
    static List<String> wybraneProdukty = new ArrayList<>();
    public static JFrame jPotwierdzenie;

    public ZakupyGUI(){
        ArrayList<String> dostepneProdukty = new ArrayList<>();
        dostepneProdukty.add("Płyn do spryskiwaczy");
        cennik.put("Płyn do spryskiwaczy",39);
        dostepneProdukty.add("Snikers");
        cennik.put("Snikers",3);
        dostepneProdukty.add("Paczka Lays");
        cennik.put("Paczka Lays",7);
        dostepneProdukty.add("Olej silnikowy");
        cennik.put("Olej silnikowy",49);
        dostepneProdukty.add("Papierosy");
        cennik.put("Papierosy",15);


        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < dostepneProdukty.size(); i++)
        {
            listModel.addElement(dostepneProdukty.get(i));
        }
        jLista.setModel(listModel);

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = jLista.getSelectedValue();
                System.out.println("Zaznaczono: "+s);
                wybraneProdukty.add(s);
                counterInt++;
                cena.setText((suma += cennik.get(s)).toString());
                counter.setText(counterInt.toString());
            }
        });

        zakupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(suma != 0){
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
        });
    }

    public String getSuma(){
        return suma.toString();
    }
}
