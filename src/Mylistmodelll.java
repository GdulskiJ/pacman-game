import javax.swing.*;
import java.util.ArrayList;

public class Mylistmodelll extends AbstractListModel {
    ArrayList<Gracz> gracze;
    public Mylistmodelll(ArrayList<Gracz> gracze ) {
this.gracze=gracze;
    }

    @Override
    public int getSize() {
        return gracze.size();
    }

    @Override
    public Object getElementAt(int index) {
        return gracze.get(index);
    }
    public void remove(int index){
        gracze.remove(index);
        fireIntervalRemoved(this, index, index);
    }

}
