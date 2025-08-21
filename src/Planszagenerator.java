import java.util.List;

public class Planszagenerator {

    static Object[][] plansza;
    static Vertex[][] plansza11;
    static Object[][] planszadoporownania;
    static int dlugosc;
    static int szeroskosc;
    Pacman pacman;
    Duch duch;
    Duch duch1;
    Duch duch2;


    public Planszagenerator(int dlugosc, int szeroskosc) {
        this.dlugosc = dlugosc;
        this.szeroskosc = szeroskosc;
        plansza = new Object[dlugosc][szeroskosc];
        plansza11 = new Vertex[dlugosc][szeroskosc];
        do {
            if (Grapac.iloscx < 26 && Grapac.iloscy < 26) {
                random();
            }
            else if (Grapac.iloscx < 60 && Grapac.iloscy < 60) {
                random1();
            }
           else {
                random2();
            }
            zapelnienei();
            tworzenievertex();
            tworzenieedges();
            List<Vertex> ph = Cell.findPath(plansza11[1][1], plansza11[3][5]);
            List<Vertex> hp = Cell.findPath(plansza11[3][5], plansza11[1][1]);
            //System.out.println(plansza11[2][2].edges.toString());
//           System.out.println(ph);
            System.out.println("--------");
//           System.out.println(hp);
//           System.out.println(akcepacjaplanszy());
//           System.out.println(hp.isEmpty());
            int[] a = znajdzpoczatek();
            pacman = new Pacman(a[0], a[1]);
            int[] b = znajdzkoniec();
            duch = new Duch(b[0], b[1]);
            duch1 = new Duch(b[0], b[1]);
            duch2 = new Duch(b[0], b[1]);
//           System.out.println(a[0]);
//           System.out.println(a[1]);

            int xx = liczbanie(szeroskosc);
            int yy = liczbanie(dlugosc);
            int x1 = liczbanie(szeroskosc);
            int y1 = liczbanie(dlugosc);
            int x2 = liczbanie(szeroskosc);
            int y2 = liczbanie(dlugosc);
            int x3 = liczbanie(szeroskosc);
            int y3 = liczbanie(dlugosc);
            int x4 = liczbanie(szeroskosc);
            int y4 = liczbanie(dlugosc);

            plansza[yy][xx] = 9;
            plansza[y1][x1] = 10;
            plansza[y2][x2] = 11;
            plansza[y3][x3] = 12;
            plansza[y4][x4] = 13;
            planszadoporownania=plansza;
        } while (akcepacjaplanszy());
    }

    public int liczbanie(int a) {
        int x = 3;
        do {
            x = (int) (Math.random() * a) + 1;
        } while (x > a - 2);
        return x;
    }

    public void tworzenievertex() {
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {

                plansza11[i][j] = new Vertex();
            }
        }
    }

    public void tworzenieedges() {
        for (int i = 1; i < plansza.length - 1; i++) {
            for (int j = 1; j < plansza[i].length - 1; j++) {
                if (plansza[i][j].equals(1)) {

                    if (plansza[i][j + 1].equals(1))
                        plansza11[i][j].addEdge(plansza11[i][j + 1]);
                    plansza11[i][j + 1].addEdge(plansza11[i][j]);
                    if (plansza[i][j - 1].equals(1))
                        plansza11[i][j].addEdge(plansza11[i][j - 1]);
                    plansza11[i][j - 1].addEdge(plansza11[i][j]);
                    if (plansza[i + 1][j].equals(1))
                        plansza11[i][j].addEdge(plansza11[i + 1][j]);
                    plansza11[i + 1][j].addEdge(plansza11[i][j]);
                    if (plansza[i - 1][j].equals(1))
                        plansza11[i][j].addEdge(plansza11[i - 1][j]);
                    plansza11[i - 1][j].addEdge(plansza11[i][j]);
                }

            }
        }
    }

    public boolean akcepacjaplanszy() {
        int[] a = znajdzpoczatek();
        List<Vertex> pathh;
        boolean wyjscie = false;
        for (int i = 1; i < plansza.length - 1; i++) {
            for (int j = 1; j < plansza[i].length - 1; j++) {


                if (plansza[i][j].equals(1) && (!plansza11[i][j].equals(plansza11[a[0]][a[1]]))) {

                    pathh = Cell.findPath(plansza11[i][j], plansza11[a[0]][a[1]]);
                    if ((pathh.isEmpty() && (!plansza11[i][j].equals(plansza11[a[0]][a[1]])))) {
                        wyjscie = true;
                        break;

                    }


                }

            }

        }

        return wyjscie;
    }


    public int[] znajdzpoczatek() {
        int[] tab = new int[2];
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                if (plansza[i][j].equals(1)) {
                    tab[0] = i;
                    tab[1] = j;
                    return tab;
                }
            }
        }
        return tab;
    }

    public int[] znajdzkoniec() {
        int[] tab = new int[2];
        for (int i = plansza.length - 1; i >= 0; i--) {
            for (int j = plansza[0].length - 1; j >= 0; j--) {
                if (plansza[i][j].equals(1)) {
                    tab[0] = i;
                    tab[1] = j;
                    return tab;
                }
            }
        }

        return tab;
    }


    public void zapelnienei() {
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                if ((int) plansza[i][j] == 1) {

                    plansza[i][j] = 1;
                    if (i == 0) {
                        plansza[i][j] = 2;
                    }
                    if (i == dlugosc - 1) {
                        plansza[i][j] = 2;
                    }
                    if (j == 0) {
                        plansza[i][j] = 2;
                    }
                    if (j == szeroskosc - 1) {
                        plansza[i][j] = 2;
                    }
                }
            }
        }
    }

    public void random() {
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                int dl = (int) (Math.random() * 6);
                if ((i) % 2 == 0 && (j) % 2 == 0) {
                    plansza[i][j] = 2;
                } else {
                    if (dl == 5) {
                        plansza[i][j] = 2;
                    } else {
                        plansza[i][j] = 1;
                    }
                }
            }
        }
    }

    public void random1() {
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                int dl = (int) (Math.random() * 20);
                if ((i) % 2 == 0 && (j) % 2 == 0) {
                    plansza[i][j] = 2;
                } else {
                    if (dl == 19) {
                        plansza[i][j] = 2;
                    } else {
                        plansza[i][j] = 1;
                    }

                }
            }
        }
    }

    public void random2() {
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                int dl = (int) (Math.random() * 20);
                if ((i) % 2 == 0 && (j) % 2 == 0) {
                    plansza[i][j] = 2;
                } else {
                    plansza[i][j] = 1;
                }
            }
        }
    }
    public static void usuwanierandom() {
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                if ((int) plansza[i][j] == 2) {
                        int dl = (int) (Math.random() * 20);
                        if(dl==10||dl==11){

                            if (!(i == 0)&&!(i == dlugosc - 1)&&!(j == 0)&&!(j == szeroskosc - 1)) {
                                plansza[i][j] = 3;
                            }
                        }
                    }
                }
            }
        }


    public static boolean czyLiczbaWystepuje(Object[][] tablica, int liczba) {
        for (Object[] wiersz : tablica) {
            for (Object element : wiersz) {
                if ((int) element == liczba) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setposition(Duch d) {
        int[] a = znajdzpoczatek();
        duch.x = a[0];
        duch.y = a[1];
    }

}