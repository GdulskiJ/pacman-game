import java.io.Serializable;

public class Gracz implements Serializable {
    String nazwa;
    int wynik;

    public Gracz(String nazwa, int wynik) {
        this.nazwa = nazwa;
        this.wynik = wynik;
    }
}
