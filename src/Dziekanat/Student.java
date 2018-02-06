package Dziekanat;

import java.util.ArrayList;

public class Student extends Osoba{
    ArrayList<Grupa> grupy = new ArrayList<Grupa>();

    public Student(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public void dodajDoGrupy(Grupa grupa) {
        this.grupy.add(grupa);
    }

    public void usunZGrupy(Grupa grupa) {
        this.grupy.remove(grupa);
    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", grupy=" + grupy +
                '}';
    }
}
