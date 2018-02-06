package Dziekanat;

import java.util.ArrayList;

public class Student extends Osoba{
    ArrayList<Grupa> grupy = new ArrayList<Grupa>();
    ArrayList<Ocena> oceny = new ArrayList<Ocena>();

    public Student(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public void dodajDoGrupy(Grupa grupa) {
        this.grupy.add(grupa);
    }

    public void usunZGrupy(Grupa grupa) {
        this.grupy.remove(grupa);
    }

    public void dodajOcene(Ocena ocena) {
        this.oceny.add(ocena);
    }

    public int policzLiczbePunktowECTS() {
        int punktyECTS = 0;
        for (Ocena ocena : this.oceny) {
            if (ocena.stopien > 2) {
                punktyECTS += ocena.przedmiot.punktyECTS;
            }
        }
        return punktyECTS;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", grupy=" + grupy +
                " oceny=" + oceny +
                " uzyskane punkty ECTS=" + policzLiczbePunktowECTS() +
                '}';
    }
}
