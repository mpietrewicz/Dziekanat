package Dziekanat.Zarzadzanie;

import Dziekanat.BazaDanych;
import Dziekanat.ObiektyZarzadzane.Student;

import java.io.IOException;
import java.util.ArrayList;

public class StudentMenadzer extends ObiektMenadzer{
    private ArrayList<Student> listaStudentow = BazaDanych.INSTANCJA.listaStudentow;

    public void dodajStudenta() throws IOException {
        Student student = new Student();
        nadajDaneOsobowe(student,"student");
        listaStudentow.add(student);
    }

    public void usunStudenta() throws IOException {
        int indexZListyStudentowDoUsuniecia = wybierzIndexObiektuZListyObiektow(listaStudentow, "student");
        listaStudentow.remove(indexZListyStudentowDoUsuniecia);
    }

    public void wyswietlListeObiektow() {
        super.wyswietlListeObiektow(listaStudentow);
    }

}
