import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MyTableModel extends AbstractTableModel {


    private Object[][]elementy;
    private String[]kolumny;

    public MyTableModel(Object[][] elementy, String[] kolumny) {
        this.elementy = elementy;
        this.kolumny = kolumny;
    }

    @Override
    public int getRowCount() {
        return elementy.length;
    }

    @Override
    public int getColumnCount() {
        return kolumny.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return elementy[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return kolumny[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        elementy[rowIndex][columnIndex]=aValue;
        fireTableCellUpdated(rowIndex,columnIndex);
    }

  //  @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        if(columnIndex>0)
//            return true;
//        return false;
//    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

            return JLabel.class;


    }





}
