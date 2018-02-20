package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.*;

import java.io.IOException;
import java.util.ArrayList;

public class StudentMenadzer extends ObiektMenadzer implements Operacje{
    private ArrayList<Student> listaStudentow = BazaDanych.INSTANCJA.listaStudentow;
    private ArrayList<Grupa> listaGrup = BazaDanych.INSTANCJA.listaGrup;
    private String kontekst = "studenta";
    private GrupaMenadzer grupaMenadzer = new GrupaMenadzer();

    @Override
    public Obiekt dodaj() throws IOException {
        Student student = new Student();
        nadajDaneOsobowe(student, kontekst);
        student.dodajGrupe(grupaMenadzer.wybierzGrupeZListy(listaGrup));
        listaStudentow.add(student);
        return student;
    }

    @Override
    public Object edytuj() throws IOException {
        int indexZListyStudentow = wybierzIndexObiektuZListyObiektow(listaStudentow, kontekst);
        Student studentDoEdycji = listaStudentow.get(indexZListyStudentow);
        nadajDaneOsobowe(studentDoEdycji, kontekst);
        int idOperacji = 0;
        while (idOperacji != 3) {
            super.wyswietlListeObiektow(studentDoEdycji.getGrupy());
            System.out.println("Zarządzanie " + kontekst + ": \n1. Dodaj, 2. Usuń, 3. Wyjdź");
            idOperacji = WierszPolecen.INSTANCJA.wczytajLiczbeZZakresu("Podaj id operacji",
                    1, 3);
            switch (idOperacji) {
                case 1:
                    studentDoEdycji.dodajGrupe(grupaMenadzer.wybierzGrupeZListy(listaGrup));
                    break;
                case 2:
                    studentDoEdycji.usunZGrupy(grupaMenadzer.wybierzGrupeZListy(studentDoEdycji.getGrupy()));
                    break;
            }
        }
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

}
