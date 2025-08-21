import javax.swing.*;
import java.awt.*;

public class MyImageIconListRenderer extends DefaultListCellRenderer {



    @Override


    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        int a=0;
        if(Grapac.rozmiarx/ Grapac.iloscx> Grapac.rozmiary/ Grapac.iloscy) {
            a  = Grapac.rozmiarx/ Grapac.iloscx;
        }else {
            a  = Grapac.rozmiary/ Grapac.iloscy;
        }
        if(a==0){
            a=40;
        }
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        ImageIcon imageIcon = (ImageIcon) value;
        Image image = imageIcon.getImage().getScaledInstance(a,a, Image.SCALE_SMOOTH);
        ImageIcon przeskalowana = new ImageIcon(image);
        label.setIcon(przeskalowana);
        label.setBackground(Color.BLACK);

        return label;
    }
}
