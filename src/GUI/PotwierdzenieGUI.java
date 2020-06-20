package GUI;

import com.sun.deploy.panel.ExceptionListDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class PotwierdzenieGUI {
    public JPanel panel1;
    private JLabel kwotaLabel;
    private JList wybraneList;
    private JButton anulujButton;
    private JButton potwierdzButton;
    public JFrame jHistoria;

    public PotwierdzenieGUI(){
        initialize();
        //Anulacja
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZakupyGUI.jPotwierdzenie.dispose();
            }
        });

        potwierdzButton.addActionListener(new ActionListener() {
            //Otoworzenie historii zakupow
            @Override
            public void actionPerformed(ActionEvent e) {
                zapisDoPliku();

                jHistoria = new JFrame("Historia zakupow");
                jHistoria.setContentPane(new HistoriaZakupowGUI().panel1);
                jHistoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jHistoria.pack();
                jHistoria.setLocationRelativeTo(null);
                jHistoria.setVisible(true);
            }
        });

    }
    public void initialize(){
        System.out.println(ZakupyGUI.suma);
        kwotaLabel.setText(ZakupyGUI.suma.toString());

        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < ZakupyGUI.wybraneProdukty.size(); i++)
        {
            listModel.addElement(ZakupyGUI.wybraneProdukty.get(i));
        }
        wybraneList.setModel(listModel);
    }

    public void zapisDoPliku(){
        int val = ZakupyGUI.wybraneProdukty.size();
        PrintWriter writer = null;
        try{
            writer = new PrintWriter("Historia.txt");

            writer.println(WyborKlientaGUI.imie);
            writer.println(WyborKlientaGUI.nazwisko);

            for (int i=0;i<val;i++){
                writer.println(ZakupyGUI.wybraneProdukty.get(i));
            }
        }catch (Exception e){

        }finally {
            writer.close();
        }
    }
}
