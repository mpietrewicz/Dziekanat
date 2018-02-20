package Dziekanat;

import Dziekanat.ObiektyZarzadzane.*;
import Dziekanat.Zarzadzanie.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.*;

public class Dziekanat {
    public static final int LICZBA_PUNKTOW_ECTS_POTRZEBNA_DO_PROMOCJI = 20;
    private static final boolean WYMAGANE_LOGOWANIE = false;

    private static ArrayList<Student> listaStudentow = BazaDanych.INSTANCJA.listaStudentow;
    private static ArrayList<Nauczyciel> listaNauczycieli = BazaDanych.INSTANCJA.listaNauczycieli;
    private static ArrayList<Grupa> listaGrup = BazaDanych.INSTANCJA.listaGrup;
    private static ArrayList<Przedmiot> listaPrzedmiotow = BazaDanych.INSTANCJA.listaPrzedmiotow;


    public static void main(String[] args) throws IOException {

        if (WYMAGANE_LOGOWANIE) {
            Logowanie logowanie = new Logowanie();
            logowanie.zaloguj();
        }

        int idOperacji = 0;
        while (idOperacji != 5) {
            System.out.println("Zarządzaj: \n1. Studentami, 2. Nauczycielami, 3. Przedmiotami. 4. Grupami 5. Wyjdź");
            idOperacji = WierszPolecen.INSTANCJA.wczytajLiczbeZZakresu("Podaj id kontekstu",
                    1, 5);
            switch (idOperacji) {
                case 1:
                    StudentMenadzer studentMenadzer = new StudentMenadzer();
                    zarzadzaj(studentMenadzer, listaStudentow, "studentami");
                    break;
                case 2:
                    NauczycielMenadzer nauczycielMenadzer = new NauczycielMenadzer();
                    zarzadzaj(nauczycielMenadzer, listaNauczycieli, "nauczycielami");
                    break;
                case 3:
                    PrzedmiotMenadzer przedmiotMenadzer = new PrzedmiotMenadzer(false);
                    zarzadzaj(przedmiotMenadzer, listaPrzedmiotow, "przedmiotami");
                    break;
                case 4:
                    GrupaMenadzer grupaMenadzer = new GrupaMenadzer();
                    zarzadzaj(grupaMenadzer, listaGrup, "grupami");
                    break;
            }
        }
    }

    private static void zarzadzaj(ObiektMenadzer obiektMenadzer, ArrayList listaObiektow, final String kontekst) throws IOException {
        int idOperacji = 0;
        while (idOperacji != 5) {
            System.out.println("Zarządzanie " + kontekst + ": \n1. Dodaj, 2. Usuń, 3. Edytuj 4. Wyświetl 5. Wyjdź");
            idOperacji = WierszPolecen.INSTANCJA.wczytajLiczbeZZakresu("Podaj id operacji",
                    1, 5);
            switch (idOperacji) {
                case 1:
                    obiektMenadzer.dodaj();
                    break;
                case 2:
                    obiektMenadzer.usun(listaObiektow, kontekst);
                    break;
                case 3:
                    obiektMenadzer.edytuj();
                    break;
                case 4:
                    obiektMenadzer.wyswietl(listaObiektow);
                    break;
            }
        }
    }

}
