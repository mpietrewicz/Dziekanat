package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.*;

import java.io.IOException;
import java.util.ArrayList;

public class StudentMenadzer extends ObiektMenadzer implements Operacje{
    private ArrayList<Student> listaStudentow = BazaDanych.INSTANCJA.listaStudentow;
    private String kontekst = "studenta";

    @Override
    public Obiekt dodaj() throws IOException {
        Student student = new Student();
        nadajDaneOsobowe(student, kontekst);
        GrupaMenadzer grupaMenadzer = new GrupaMenadzer();
        student.dodajGrupe((Grupa) grupaMenadzer.dodaj());
        listaStudentow.add(student);
        return student;
    }

    @Override
    public Object edytuj() throws IOException {
        int indexZListyStudentow = wybierzIndexObiektuZListyObiektow(listaStudentow, kontekst);
        Student studentDoEdycji = listaStudentow.get(indexZListyStudentow);
        nadajDaneOsobowe(studentDoEdycji,kontekst);
        return studentDoEdycji;
    }

    @Override
    public void usun() throws IOException {
        super.usunElementZListyObiektow(listaStudentow, kontekst);
    }

    @Override
    public void wyswietl() {
        super.wyswietlListeObiektow(listaStudentow);
    }

    Przedmiot wybierzPrzedmiotStudenta() throws IOException {
        ObiektMenadzer obiektMenadzer = new ObiektMenadzer();

        if (!obiektMenadzer.wyswietlListeObiektow(listaStudentow)) {
            System.out.println("Brak studentów");
            return null;
        }
        int indexStudenta = wierszPolecen.wczytajLiczbeZZakresu("Wybierz index studenta",
                0, listaStudentow.size()-1);
        Student student = listaStudentow.get(indexStudenta);

        ArrayList<Grupa> grupyStudenta = student.getGrupy();
        if (!obiektMenadzer.wyswietlListeObiektow(grupyStudenta)) {
            System.out.println("Brak grup studenta");
            return null;
        }
        int indexGrupy = wierszPolecen.wczytajLiczbeZZakresu("Wybierz index grupy",
                0, grupyStudenta.size()-1);
        Grupa grupa = grupyStudenta.get(indexGrupy);

        ArrayList<Przedmiot> przedmiotyZGrupyStudenta = grupa.getPrzedmioty();
        if (!obiektMenadzer.wyswietlListeObiektow(przedmiotyZGrupyStudenta)) {
            System.out.println("Brak przedmiotów studenta");
            return null;
        }
        int indexPrzedmiotu = wierszPolecen.wczytajLiczbeZZakresu("Wybierz index przedmiotu",
                0, przedmiotyZGrupyStudenta.size()-1);
        Przedmiot przedmiot = przedmiotyZGrupyStudenta.get(indexPrzedmiotu);

        return przedmiot;
    }

}
