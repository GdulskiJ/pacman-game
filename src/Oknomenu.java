import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Oknomenu extends JFrame {
    public Oknomenu() {
        JFrame framemenu = new JFrame("Pacman");
framemenu.setLayout(new BorderLayout());
framemenu.setLayout(new BorderLayout());
        framemenu.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("pacman-game.jpg");

        JLabel tlo = new JLabel(icon);

framemenu.add(tlo);
            framemenu.setBackground(Color.BLACK);

        JPanel przyciski = new JPanel(new  GridLayout(0, 1));
     //przyciski.setLayout(new BoxLayout(przyciski, BoxLayout.Y_AXIS));
            Font font = new Font("Broadway", Font.BOLD, 30);
        JButton b1 = new JButton("New Game  ");
        b1.setBackground(Color.BLACK);
        b1.setFont(font);
        b1.setForeground(Color.ORANGE);
        b1.setBorder(null);

        JButton b2 = new JButton("High Scores  ");
            b2.setBackground(Color.BLACK);
            b2.setFont(font);
            b2.setForeground(Color.ORANGE);
            b2.setBorder(null);
        JButton b3 = new JButton("Exit");
            b3.setBackground(Color.BLACK);
            b3.setFont(font);
            b3.setForeground(Color.ORANGE);
            b3.setBorder(null);



            b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            SwingUtilities.invokeLater(()->new Grapac());
                    }
            });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(()->new Ranking());
            }
        });
           b3.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                           System.exit(0);
                   }
           });

        przyciski.add(b1);
        przyciski.add(b2);
        przyciski.add(b3);
        przyciski.setBackground(Color.BLACK);




//tloooo.add(tlo);
//przyciski.add(tloooo);
     //   framemenu.add(przyciski);

            framemenu.getContentPane().setBackground(Color.BLACK);
            framemenu.add(przyciski,BorderLayout.PAGE_END);
framemenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
framemenu.setLocationRelativeTo(null);
        framemenu.setSize(460, 500);
    }
}
