package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class HistoriaZakupowGUI {
    public JPanel panel1;
    private JList historiaList;
    private JButton zamknijOknoButton;
    private JButton noweZakupyButton;

    public HistoriaZakupowGUI(){
        initialize();

        zamknijOknoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFramesController.jHistoria.dispose();
            }
        });

        noweZakupyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFramesController.jHistoria.dispose();
                JFramesController.start();
            }
        });
    }

    public void initialize(){

        DefaultListModel listModel = new DefaultListModel<>();
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader("Historia.txt"));
            String s;
            while ((s = br.readLine()) != null){
                System.out.println(s);
                listModel.addElement(s);
            }
            historiaList.setModel(listModel);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
