public class Duch {
    int x;
    int y;


    public Duch(int x, int y) {
        this.x = x;
        this.y = y;
    }
    int p = 3;
    public void move() {
        int a = (int) (Math.random() * 4);
        ;
 p = (int) Planszagenerator.plansza[x][y];
 int xprzed=x;
 int yprzed=y;
        //   System.out.println(e.getKeyChar());
        if (a == 0) {
            if ((int) Planszagenerator.plansza[x - 1][y] == 1 || (int) Planszagenerator.plansza[x - 1][y] == 3) {
                int b = (int) Planszagenerator.plansza[x - 1][y];
//                int pozx=x-1;
//                int pozy=y;
               // Planszagenerator.plansza[x - 1][y] = 4;
                Grapac.table.setValueAt(8, x - 1, y);
                Grapac.table.setValueAt(b, x, y);

                x = (x - 1);
                Planszagenerator.plansza[x][y] = 8;
            }
        }
        if (a == 1) {
            //   System.out.println(1);
            if ((int) Planszagenerator.plansza[x + 1][y] == 1 || (int) Planszagenerator.plansza[x + 1][y] == 3) {
                int b = (int) Planszagenerator.plansza[x + 1][y];
              //  Planszagenerator.plansza[x + 1][y] = 4;
                Grapac.table.setValueAt(8, x + 1, y);
                Grapac.table.setValueAt(b, x, y);

                x = (x + 1);
                Planszagenerator.plansza[x][y] = 8;
            }

        }
        if (a == 2) {
            if ((int) Planszagenerator.plansza[x][y - 1] == 1 || (int) Planszagenerator.plansza[x][y - 1] == 3) {
                int b = (int) Planszagenerator.plansza[x][y - 1];
               // Planszagenerator.plansza[x][y - 1] = 4;
                Grapac.table.setValueAt(8, x, y - 1);
                Grapac.table.setValueAt(b, x, y);

                y = y - 1;
                Planszagenerator.plansza[x][y] = 8;
            }
        }
        if (a == 3) {
            if ((int) Planszagenerator.plansza[x][y + 1] == 1 || (int) Planszagenerator.plansza[x][y + 1] == 3) {
                int b = (int) Planszagenerator.plansza[x][y + 1];
             //   Planszagenerator.plansza[x][y + 1] = 4;
                Grapac.table.setValueAt(8, x, y + 1);
                Grapac.table.setValueAt(b, x, y);

                y = y + 1;
                Planszagenerator.plansza[x][y] = 8;
            }
        }
    }
    }

