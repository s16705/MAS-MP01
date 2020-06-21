package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    static Double suma = 0.00;
    LocalDate data;
    HashMap<String, Double> cennik = new HashMap<String, Double>();
    static List<String> wybraneProdukty = new ArrayList<>();
    static LocalDate dataZakupow;

    public ZakupyGUI(){
        ArrayList<String> dostepneProdukty = new ArrayList<>();
        dostepneProdukty.add("Płyn do spryskiwaczy");
        cennik.put("Płyn do spryskiwaczy",39.99);
        dostepneProdukty.add("Snikers");
        cennik.put("Snikers",2.99);
        dostepneProdukty.add("Paczka Lays");
        cennik.put("Paczka Lays",6.99);
        dostepneProdukty.add("Olej silnikowy");
        cennik.put("Olej silnikowy",49.99);
        dostepneProdukty.add("Papierosy");
        cennik.put("Papierosy",15.50);


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
                Double tmp1 = suma += cennik.get(s);
                suma = (double) Math.round(tmp1 * 100.0)/100;
                cena.setText(suma.toString());
                counter.setText(counterInt.toString());
            }
        });

        zakupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter dataformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dataZakupow = LocalDate.parse(dataField.getText(), dataformat);
                JFramesController.potwierdzenie();
            }
        });
    }

    public String getSuma(){
        return suma.toString();
    }
}
