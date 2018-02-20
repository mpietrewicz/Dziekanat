package Dziekanat;

import Dziekanat.ObiektyZarzadzane.*;
import Dziekanat.Zarzadzanie.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.*;

public class Dziekanat {
    public static final int LICZBA_PUNKTOW_ECTS_POTRZEBNA_DO_PROMOCJI = 20;
    private static final boolean WYMAGANE_LOGOWANIE = false;

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
                    zarzadzaj(studentMenadzer, "studentami");
                    break;
                case 2:
                    NauczycielMenadzer nauczycielMenadzer = new NauczycielMenadzer();
                    zarzadzaj(nauczycielMenadzer, "nauczycielami");
                    break;
                case 3:
                    PrzedmiotMenadzer przedmiotMenadzer = new PrzedmiotMenadzer(false);
                    zarzadzaj(przedmiotMenadzer, "przedmiotami");
                    break;
                case 4:
                    GrupaMenadzer grupaMenadzer = new GrupaMenadzer();
                    zarzadzaj(grupaMenadzer, "grupami");
                    break;
            }
        }
    }

    private static void zarzadzaj(ObiektMenadzer obiektMenadzer, final String kontekst) throws IOException {
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
                    obiektMenadzer.usun();
                    break;
                case 3:
                    obiektMenadzer.edytuj();
                    break;
                case 4:
                    obiektMenadzer.wyswietl();
                    break;
            }
        }
    }

}
