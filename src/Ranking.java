import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ranking {
JFrame rankingframe = new JFrame("ranking");
   static  List<String> gracze = new ArrayList<>();

    public Ranking() {

        ArrayList<Gracz> odczytanaLista=new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("gracz.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (true) {
                try {
                    Gracz gracz2 = (Gracz) in.readObject();
                    odczytanaLista.add((gracz2));

                } catch (EOFException e) {
                    break;
                } catch ( IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        JList jList = new JList<>(odczytanaLista.toArray());

        jList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Font font = new Font("Broadway", Font.BOLD, 15);
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setText(((Gracz) value).nazwa + " (Wynik : " + ((Gracz) value).wynik + ")");
                label.setBackground(Color.BLACK);
                label.setForeground(Color.ORANGE);
                return label;
            }
        });
Mylistmodelll mylistmodelll = new Mylistmodelll(odczytanaLista);
jList.setModel(mylistmodelll);
        JScrollPane jScrollPane = new JScrollPane(jList);

jList.setBackground(Color.BLACK);
        JPanel jPanel = new JPanel();
        JButton b1 =new JButton("Usun");



        jScrollPane.setBackground(Color.BLACK);


jScrollPane.add(b1);
        rankingframe.add(jScrollPane);
       rankingframe.setSize(200,200);
        rankingframe.setVisible(true);
       rankingframe.setLocationRelativeTo(null);



    }
}

