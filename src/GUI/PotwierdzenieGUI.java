package GUI;

import com.sun.deploy.panel.ExceptionListDialog;
import oracle.jrockit.jfr.JFR;

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

    public PotwierdzenieGUI(){
        initialize();
        //Anulacja
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFramesController.jPotwierdzenie.dispose();
            }
        });

        potwierdzButton.addActionListener(new ActionListener() {
            //Otoworzenie historii zakupow
            @Override
            public void actionPerformed(ActionEvent e) {
                JFramesController.zapisDoPliku();
                JFramesController.jPotwierdzenie.dispose();
                JFramesController.jZakupy.dispose();

                JFramesController.historia();
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


}
