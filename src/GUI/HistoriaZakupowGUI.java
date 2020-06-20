package GUI;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;

public class HistoriaZakupowGUI {
    public JPanel panel1;
    private JList historiaList;

    public HistoriaZakupowGUI(){
        initialize();

    }

    public void initialize(){

        DefaultListModel listModel = new DefaultListModel<>();
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader("Historia.txt"));

            while ((br.readLine()) != null){
                String s = br.readLine();
                listModel.addElement(s);
            }
            historiaList.setModel(listModel);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
