package Dziekanat.ObiektyZarzadzane;


import Dziekanat.Dziekanat;
import Dziekanat.Status;

import java.util.ArrayList;

public class Student extends Osoba{
    private ArrayList<Grupa> grupy = new ArrayList<Grupa>();

    public Student(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public Student() {
        super();
    }

    public void dodajGrupe(Grupa grupa) {
        this.grupy.add(grupa);
    }

    public void usunZGrupy(Grupa grupa) {
        this.grupy.remove(grupa);
    }

    public int policzLiczbePunktowECTS() {
        int punktyECTS = 0;
        for (Grupa grupa : this.grupy) {
            for (Przedmiot przedmiot : grupa.getPrzedmioty()) {
                if (przedmiot.getOcena().getStopien() > 2) {
                    punktyECTS += przedmiot.getPunktyECTS();
                }
            }
        }
        return punktyECTS;
    }

    public Status wyznaczStatusStudenta() {
        if (policzLiczbePunktowECTS() >= Dziekanat.LICZBA_PUNKTOW_ECTS_POTRZEBNA_DO_PROMOCJI) {
            return Status.PROMOCJA;
        } else {
            return Status.BRAK_PROMOCJI;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                ", imie='" + super.getImie() + '\'' +
                ", nazwisko='" + super.getNazwisko() + '\'' +
                ", grupy=" + grupy +
                " uzyskane punkty ECTS=" + policzLiczbePunktowECTS() +
                " status studenta=" + wyznaczStatusStudenta() +
                '}';
    }
}
