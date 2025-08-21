import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Grapac extends JPanel  {

    int highscore=0;
    static Object monitor = new Object();
    int currentThread = 1;
boolean end=true;
    String nawa;
    int scoore = 0;
    static int rozmiarx=800;
    static int iloscy;
    static int iloscx;
    static int rozmiary=600;
    static Font font = new Font("Broadway", Font.BOLD, 40);
   static JTable table = new JTable();
   int predkosc=20;
static Planszagenerator planszagenerator1;
    public Grapac() {
        JFrame frame = new JFrame("Pacman");
//iloscx=10;
//iloscy=10;
        try {
            iloscx = Integer.parseInt(JOptionPane.showInputDialog("Podaj wymiar X (10-100)", ""));
            iloscy = Integer.parseInt(JOptionPane.showInputDialog("Podaj wymiar Y (10-100)", ""));
        }catch (NumberFormatException f){

        }

        frame.setLayout(new BorderLayout(0,0));


        ImageIcon icon = new ImageIcon("C:\\Users\\gduls\\IdeaProjects\\Gui_porjekt_2\\img.png");

       // Font font = new Font("Arial", Font.BOLD, 50);
        JTextArea textArea = new JTextArea();
        textArea.append("Score"+String.valueOf(scoore));
        textArea.setFont(font);
        textArea.setLineWrap(true);
        textArea.setForeground(Color.ORANGE);

        JLabel label2 = new JLabel(icon);




JPanel up = new JPanel();
up.setLayout(new BorderLayout());
       Planszagenerator planszagenerator = new Planszagenerator(iloscy, iloscx);
       planszagenerator1=planszagenerator;




        String[] columnNames = new String[planszagenerator.szeroskosc];
        for (int i = 0; i < planszagenerator.szeroskosc; i++) {
            columnNames[i] = String.valueOf(i);
        }






//WATKI DUCHOW
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor) {
                while (end) {
                    while (currentThread != 1) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    planszagenerator1.duch.move();
                    try {
                        Thread.sleep(predkosc);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentThread = 2;
                    monitor.notifyAll();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (monitor) {
                while (end) {
                    while (currentThread != 2) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    planszagenerator1.duch1.move();
                    try {
                        Thread.sleep(predkosc);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentThread = 3;
                    monitor.notifyAll();
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            synchronized (monitor) {
                while (end) {
                    while (currentThread != 3) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    planszagenerator1.duch2.move();
                    try {
                        Thread.sleep(predkosc);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentThread = 1;
                    monitor.notifyAll();
                }
            }
        });


        List<ImageIcon> imageList = new ArrayList<>();
        imageList.add(new ImageIcon("heart.png"));
        imageList.add(new ImageIcon("heart.png"));
        imageList.add(new ImageIcon("heart.png"));

        DefaultListModel<ImageIcon> listModel = new DefaultListModel<>();
        for (ImageIcon imageIcon : imageList) {
            listModel.addElement(imageIcon);
        }

        JList<ImageIcon> list = new JList<>(listModel);
        list.setCellRenderer(new MyImageIconListRenderer());
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(1);
        list.setBorder(null);
        list.setBackground(Color.BLACK);
        frame.add(list, BorderLayout.PAGE_END);
        //listModel.remove(0);
        //repaint();


        thread1.start();
        thread2.start();
        thread3.start();


        table.setModel(new MyTableModel(Planszagenerator.plansza, columnNames));
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new MyTableCellRenderer());
            table.getColumnModel().getColumn(i).setMinWidth(rozmiarx/iloscx);
            table.getColumnModel().getColumn(i).setMaxWidth(rozmiarx/iloscx);
        }
        table.setRowHeight(rozmiarx/iloscx);

        table.setBackground(Color.BLACK);
        table.setTableHeader(null);

        table.setValueAt(6, planszagenerator.znajdzpoczatek()[0], planszagenerator.znajdzpoczatek()[1]);


        JScrollPane scrollPane = new JScrollPane(table);
        rozmiary = scrollPane.getSize().height;
        rozmiarx = scrollPane.getSize().width;
        scrollPane.setBackground(Color.RED);
        scrollPane.getViewport().setBackground(Color.BLACK);
        textArea.setBackground(Color.BLACK);

        JButton b = new JButton("");
        // b.setVisible(false);
        b.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //    System.out.println(e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                char a = e.getKeyChar();

                if (e.isControlDown() && e.isAltDown() && e.getKeyCode() == KeyEvent.VK_Q) {
                    frame.dispose();
                }

                if (a == 'w') {


                    if ((int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 1 || (int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 3||(int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 8||(int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 9||(int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 10||(int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 11||(int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 12||(int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 13) {
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 1){
                            scoore++;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 9){
                            predkosc = 10;
                            scoore++;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 10){
                            predkosc = 40;
                            scoore++;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 11){
                            scoore=scoore+10;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 12){
                            scoore=scoore-10;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] == 13){
                            Planszagenerator.usuwanierandom();
                            scoore++;
                        }


                        Planszagenerator.plansza[planszagenerator.pacman.x - 1][planszagenerator.pacman.y] = 4;
                        table.setValueAt(7, planszagenerator.pacman.x - 1, planszagenerator.pacman.y);
                        table.setValueAt(3, planszagenerator.pacman.x, planszagenerator.pacman.y);
                        planszagenerator.pacman.setX(planszagenerator.pacman.x - 1);



                    }
                }
                if (a == 's') {
scoore--;
                    if ((int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 1 || (int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 3|| (int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 8|| (int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 9|| (int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 10|| (int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 11|| (int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 12|| (int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 13) {
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 1){
                            scoore++;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 9){
                            predkosc = 10;
                        } scoore++;
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 10){
                            predkosc = 40;
                            scoore++;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 11){
                           scoore=scoore+10;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 12){
                            scoore=scoore-10;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] == 13){
                            Planszagenerator.usuwanierandom();
                            scoore++;
                        }

                        Planszagenerator.plansza[planszagenerator.pacman.x + 1][planszagenerator.pacman.y] = 4;
                        table.setValueAt(4, planszagenerator.pacman.x + 1, planszagenerator.pacman.y);
                        table.setValueAt(3, planszagenerator.pacman.x, planszagenerator.pacman.y);
                        planszagenerator.pacman.setX(planszagenerator.pacman.x + 1);



                    }

                }
                if (a == 'a') {
                    if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 1 || (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 3|| (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 8|| (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 9|| (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 10|| (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 11|| (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 12|| (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 13) {
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 1){
                            scoore++;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 9){
                            predkosc=10;
                            scoore++;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 10){
                            predkosc=40;
                            scoore++;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 11){
                            scoore=scoore+10;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 12){
                            scoore=scoore-10;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] == 13){
                            Planszagenerator.usuwanierandom();
                            scoore++;
                        }
                        Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y - 1] = 4;
                        table.setValueAt(5, planszagenerator.pacman.x, planszagenerator.pacman.y - 1);
                        table.setValueAt(3, planszagenerator.pacman.x, planszagenerator.pacman.y);
                        planszagenerator.pacman.setY(planszagenerator.pacman.y - 1);


                    }
                }
                if (a == 'd') {

                    if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 1 || (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 3|| (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 8|| (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 9|| (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 10|| (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 11|| (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 12|| (int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 13) {
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 1){
                            scoore++;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 9){
                            predkosc=10;
                            scoore++;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 10){
                            predkosc=40;
                            scoore++;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 11){
                            scoore=scoore+10;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 12){
                            scoore=scoore-10;
                        }
                        if ((int) Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] == 13){
                            Planszagenerator.usuwanierandom();
                            scoore++;
                        }

                        Planszagenerator.plansza[planszagenerator.pacman.x][planszagenerator.pacman.y + 1] = 4;
                        table.setValueAt(6, planszagenerator.pacman.x, planszagenerator.pacman.y + 1);
                        table.setValueAt(3, planszagenerator.pacman.x, planszagenerator.pacman.y);
                        planszagenerator.pacman.setY(planszagenerator.pacman.y + 1);

                    }
                }
                if(highscore<=scoore){
                    highscore=scoore;
                }
                textArea.setText("Score : "+String.valueOf(scoore));
                rozmiary = scrollPane.getSize().height;
                rozmiarx = scrollPane.getSize().width;
                System.out.println(rozmiarx/iloscx);


                if(rozmiarx/iloscx<rozmiary/iloscy) {
                    for (int i = 0; i < table.getColumnCount(); i++) {
                        table.getColumnModel().getColumn(i).setCellRenderer(new MyTableCellRenderer());
                        table.getColumnModel().getColumn(i).setMinWidth(rozmiarx / iloscx);
                        table.getColumnModel().getColumn(i).setMaxWidth(rozmiarx / iloscx);
                    }
                    table.setRowHeight(rozmiarx / iloscx);
                }else {
                    for (int i = 0; i < table.getColumnCount(); i++) {
                        table.getColumnModel().getColumn(i).setCellRenderer(new MyTableCellRenderer());
                        table.getColumnModel().getColumn(i).setMinWidth(rozmiary / iloscy);
                        table.getColumnModel().getColumn(i).setMaxWidth(rozmiary / iloscy);
                    }
                    table.setRowHeight(rozmiary / iloscy);
                }



                if(!Planszagenerator.czyLiczbaWystepuje(Planszagenerator.plansza,1)){
                    frame.dispose();
                    nawa = JOptionPane.showInputDialog("koniec gry! Podaj swój nick: ", "");
                    try {

                        //najpierw zczytuje wszystko z pliku a potem zapisuje i dopisuje wynk
                        ArrayList<Gracz> odczytanaLista = new ArrayList<>();
                        try {
                            FileInputStream fileIn = new FileInputStream("gracz.txt");
                            ObjectInputStream in = new ObjectInputStream(fileIn);
                            while (true) {
                                try {
                                    Gracz gracz = (Gracz) in.readObject();
                                    odczytanaLista.add(gracz);
                                } catch (EOFException ee) {
                                    break;
                                } catch  (IOException ee) {
                                    ee.printStackTrace();
                                } catch (ClassNotFoundException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            in.close();
                            fileIn.close();
                        } catch (IOException ee) {
                            ee.printStackTrace();
                        }





                        FileOutputStream fileOut = new FileOutputStream("gracz.txt");
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);

                        for (int i = 0; i < odczytanaLista.size(); i++) {
                            out.writeObject(odczytanaLista.get(i));
                            System.out.println(odczytanaLista.get(i));
                        }

                        out.writeObject(new Gracz(nawa, scoore));
                        out.close();
                        fileOut.close();
                    } catch (IOException ee) {
                        ee.printStackTrace();
                    }
                    System.out.println(nawa);


                }

                if((planszagenerator.pacman.x==planszagenerator.duch.x&&planszagenerator.pacman.y==planszagenerator.duch.y)||(planszagenerator.pacman.x==planszagenerator.duch1.x&&planszagenerator.pacman.y==planszagenerator.duch1.y)||(planszagenerator.pacman.x==planszagenerator.duch2.x&&planszagenerator.pacman.y==planszagenerator.duch2.y)){
                  if(!listModel.isEmpty()){
                    listModel.remove(0);

                      Planszagenerator.plansza[planszagenerator.duch.x][planszagenerator.duch.y]=3;
                      Planszagenerator.plansza[planszagenerator.duch1.x][planszagenerator.duch1.y]=3;
                      Planszagenerator.plansza[planszagenerator.duch2.x][planszagenerator.duch2.y]=3;

                      planszagenerator.duch.x=1;
                      planszagenerator.duch1.x=1;
                      planszagenerator.duch2.x=1;
                      planszagenerator.duch.y=1;
                      planszagenerator.duch1.y=1;
                      planszagenerator.duch2.y=1;

try {
    thread1.start();
    thread2.start();
    thread3.start();
}catch (IllegalThreadStateException d){

}

                }
                    if(listModel.isEmpty()){
                        frame.dispose();
                        nawa = JOptionPane.showInputDialog("koniec gry! Podaj swój nick: ", "");
                        try {
                            //najpierw zczytuje wszystko z pliku a potem zapisuje i dopisuje wynk
                            ArrayList<Gracz> odczytanaLista = new ArrayList<>();
                            try {
                                FileInputStream fileIn = new FileInputStream("gracz.txt");
                                ObjectInputStream in = new ObjectInputStream(fileIn);
                                while (true) {
                                    try {
                                        Gracz gracz = (Gracz) in.readObject();
                                        odczytanaLista.add(gracz);

                                    } catch (EOFException ee) {
                                        break;
                                    } catch (IOException ee) {
                                        ee.printStackTrace();
                                    } catch (ClassNotFoundException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                                in.close();
                                fileIn.close();
                            } catch (IOException ee) {
                                ee.printStackTrace();
                            }


                            FileOutputStream fileOut = new FileOutputStream("gracz.txt");
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);

                            for (int i = 0; i < odczytanaLista.size(); i++) {
                                out.writeObject(odczytanaLista.get(i));
                                System.out.println(odczytanaLista.get(i));
                            }

                            out.writeObject(new Gracz(nawa, scoore));
                            out.close();
                            fileOut.close();
                        } catch (IOException ee) {
                            ee.printStackTrace();
                        }
                        System.out.println(nawa);
                    }
                  }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });


        frame.add(scrollPane, BorderLayout.CENTER);
        up.add(b);
        up.add(textArea);
        frame.add(up, BorderLayout.PAGE_START);


        ComponentListener componentListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                rozmiary = scrollPane.getSize().height;
                rozmiarx = scrollPane.getSize().width;
                if(rozmiarx/iloscx<rozmiary/iloscy) {
                    for (int i = 0; i < table.getColumnCount(); i++) {
                        table.getColumnModel().getColumn(i).setCellRenderer(new MyTableCellRenderer());
                        table.getColumnModel().getColumn(i).setMinWidth(rozmiarx / iloscx);
                        table.getColumnModel().getColumn(i).setMaxWidth(rozmiarx / iloscx);
                    }
                    table.setRowHeight(rozmiarx / iloscx);
                }else {
                    for (int i = 0; i < table.getColumnCount(); i++) {
                        table.getColumnModel().getColumn(i).setCellRenderer(new MyTableCellRenderer());
                        table.getColumnModel().getColumn(i).setMinWidth(rozmiary / iloscy);
                        table.getColumnModel().getColumn(i).setMaxWidth(rozmiary / iloscy);
                    }
                    try {
                        table.setRowHeight(rozmiary / iloscy);
                    }catch (IllegalArgumentException t){

                    }
                }
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }
        };
        frame.addComponentListener(componentListener);


        frame.setSize(iloscx*50, iloscx*50);



        frame.pack();
        frame.setVisible(true);
frame.setLocationRelativeTo(null);


    }

}
