package Dziekanat;

public class Nauczyciel {
    String imie;
    String nazwisko;

    public Nauczyciel(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Nauczyciel{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}
