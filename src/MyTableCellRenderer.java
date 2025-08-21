import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MyTableCellRenderer implements TableCellRenderer{


    public MyTableCellRenderer() {

    }


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {


       //
        // component.setBackground(Color.CYAN);
//        if((int)value==3){
//            ImageIcon icon = new ImageIcon("pacmandol.jpg");
//            Component  component = new JLabel(icon);
//            return component;
//        }
         int x = 0;
        if(Grapac.rozmiarx/ Grapac.iloscx< Grapac.rozmiary/ Grapac.iloscy) {
             x = Grapac.rozmiarx / Grapac.iloscx;
            if (x == 0) {
                x = 100;
            }

        }else {
            x = Grapac.rozmiary / Grapac.iloscy;
            if (x == 0) {
                x = 100;
            }

        }
        int y = x;
        if((int)value==3){
            ImageIcon icon = new ImageIcon("pole.png");
            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            Component  component = new JLabel(icon);
            return component;
        }
        if((int)value==1){

            ImageIcon icon = new ImageIcon("punkt.png");
            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT);
            Component  component = new JLabel(icon);
            return component;
        }
        if((int)value==2){
            ImageIcon icon = new ImageIcon("bariera.png");
            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            Component  component = new JLabel(icon);
            return component;
        }
        if((int)value==4){
            ImageIcon icon = new ImageIcon("pacmandol.jpg");
            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            Component  component = new JLabel(icon);
            return component;
        }
        if((int)value==5){
            ImageIcon icon = new ImageIcon("pacmanlewo.jpg");
            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            Component  component = new JLabel(icon);
            return component;
        }
        if((int)value==6){
            ImageIcon icon = new ImageIcon("pacmanprawo.jpg");
            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            Component  component = new JLabel(icon);
            return component;
        }
        if((int)value==7){
            ImageIcon icon = new ImageIcon("pacmangora.jpg");
            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            Component  component = new JLabel(icon);
            return component;
        }
        if((int)value==8){
            ImageIcon icon = new ImageIcon("duch.png");

            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            Component  component = new JLabel(icon);
            return component;
        }
        if((int)value==9){
            ImageIcon icon = new ImageIcon("truskawa.png");

            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            Component  component = new JLabel(icon);
            return component;
        }
        if((int)value==10){
            ImageIcon icon = new ImageIcon("jablko.png");

            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            Component  component = new JLabel(icon);
            return component;
        }
        if((int)value==11){
            ImageIcon icon = new ImageIcon("wisnia.png");

            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            Component  component = new JLabel(icon);
            return component;
        }
        if((int)value==12){
            ImageIcon icon = new ImageIcon("gruszka.png");

            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            Component  component = new JLabel(icon);
            return component;
        }
        if((int)value==13){
            ImageIcon icon = new ImageIcon("klucz.png");

            Image scaledImage = icon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            Component  component = new JLabel(icon);
            return component;
        }
else {
    JLabel sciana = new JLabel(){

    };
    sciana.setBackground(Color.CYAN);
            return sciana;
         }


    }


}

//import javax.swing.*;
//        import javax.swing.table.DefaultTableCellRenderer;
//        import javax.swing.table.TableCellRenderer;
//        import java.awt.*;
//
//public class MyTableCellRenderer extends DefaultTableCellRenderer {
//
//
//    public MyTableCellRenderer() {
//    }
//
//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//        JPanel panel
//    }
//}