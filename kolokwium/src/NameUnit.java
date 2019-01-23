import java.util.List;

public class NameUnit {
    int rok;
    String imie;
    long liczba;
    String plec;

    public NameUnit(int rok, String imie, long liczba, String plec) {
        this.rok = rok;
        this.imie = imie;
        this.liczba = liczba;
        this.plec = plec;
    }

    public String toString() {
        return "NameUnit{" +
                "rok='" + rok + '\'' +
                "name='" + imie + '\'' +
                "liczba='" + liczba + '\'' +
                "plec='" + plec + '\'' +
                '}';
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setLiczba(long liczba) {
        this.liczba = liczba;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public int getRok() {
        return rok;
    }

    public String getImie() {
        return imie;
    }

    public long getLiczba() {
        return liczba;
    }

    public String getPlec() {
        return plec;
    }
}
