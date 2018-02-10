package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Grupa;
import Dziekanat.ObiektyZarzadzane.Obiekt;
import Dziekanat.ObiektyZarzadzane.Ocena;
import Dziekanat.ObiektyZarzadzane.Student;

import java.io.IOException;
import java.util.ArrayList;

public class StudentMenadzer extends ObiektMenadzer implements Operacje{
    private ArrayList<Student> listaStudentow = BazaDanych.INSTANCJA.listaStudentow;

    @Override
    public Obiekt dodaj() throws IOException {
        Student student = new Student();
        nadajDaneOsobowe(student,"student");
        GrupaMenadzer grupaMenadzer = new GrupaMenadzer();
        student.dodajGrupe((Grupa) grupaMenadzer.dodaj());
        listaStudentow.add(student);
        return student;
    }

    @Override
    public void usun() throws IOException {
        super.usunElementZListyObiektow(listaStudentow, "student");
    }

    @Override
    public void wyswietl() {
        super.wyswietlListeObiektow(listaStudentow);
    }

}
