package Dziekanat;

import Dziekanat.ObiektyZarzadzane.*;
import Dziekanat.Zarzadzanie.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Dziekanat {
    public static final int LICZBA_PUNKTOW_ECTS_POTRZEBNA_DO_PROMOCJI = 20;
    private static final int MAX_ILOSC_PROB_LOGOWANIA = 3;

    public static void main(String[] args) throws IOException {

        zaloguj();
        przykladoweOperacje();

        int idOperacji = 0;
        while (idOperacji != 6) {
            System.out.println("Zarządzaj: \n1. Studentami, 2. Nauczycielami, 3. Przedmiotami. 4. Ocenami 5. Grupami 6. Wyjdź");
            idOperacji = WierszPolecen.INSTANCJA.wczytajLiczbeZZakresu("Podaj id kontekstu",
                    1, 6);
            switch (idOperacji) {
                case 1:
                    // 1. Zarządzanie studentami (wstaw, usuń, edytuj)
                    StudentMenadzer studentMenadzer = new StudentMenadzer();
                    zarzadzaj(studentMenadzer, "studentami");
                    break;
                case 2:
                    // 2. Zarządzanie nauczycielami
                    NauczycielMenadzer nauczycielMenadzer = new NauczycielMenadzer();
                    zarzadzaj(nauczycielMenadzer, "nauczycielami");
                    break;
                case 3:
                    // 3. Zarządzanie przedmiotami
                    PrzedmiotMenadzer przedmiotMenadzer = new PrzedmiotMenadzer();
                    zarzadzaj(przedmiotMenadzer, "przedmiotami");
                    break;
                case 4:
                    // 4. Zarządzanie ocenami w kontekście Studenta
                    OcenaMenadzer ocenaMenadzer = new OcenaMenadzer();
                    zarzadzaj(ocenaMenadzer, "ocenami");
                    break;
                case 5:
                    // 5. Zarządzanie grupami
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

    private static void przykladoweOperacje() {
        // 6. Nauczyciele są powiązani z przedmiotami, które prowadzą
        Nauczyciel nauczycielMarek = new Nauczyciel("Marek", "Pietrewicz");
        Przedmiot matematyka = new Przedmiot("matematyka", 10);
        nauczycielMarek.dodajPrzedmiot(matematyka);
        System.out.println(nauczycielMarek);
        nauczycielMarek.usunPrzedmiot(matematyka);
        System.out.println(nauczycielMarek);

        // 7. Studenci są powiązani z grupami
        Grupa grupa3b = new Grupa("grupa 3b");
        Student janek = new Student("Jan", "Nowak");
        janek.dodajGrupe(grupa3b);
        System.out.println(janek);
        janek.usunZGrupy(grupa3b);
        BazaDanych.INSTANCJA.listaStudentow.add(janek);
        System.out.println(janek);

        // 8. Grupy mają przypisane przedmioty w których uczestniczą
        Grupa grupa4c = new Grupa("4C");
        Przedmiot jPolski = new Przedmiot("język polski", 9);
        Przedmiot jAngielski = new Przedmiot("język angielski", 8);
        grupa4c.dodajPrzedmiot(jPolski);
        grupa4c.dodajPrzedmiot(jAngielski);
        grupa4c.usunPrzedmiot(jAngielski);
        Grupa grupa4d = new Grupa("4D");
        grupa4d.dodajPrzedmiot(jAngielski);
        BazaDanych.INSTANCJA.listaGrup.add(grupa4c);
        System.out.println(grupa4c);
        BazaDanych.INSTANCJA.listaGrup.add(grupa4d);
        System.out.println(grupa4d);

        // 9. Studentom można wystawiać oceny za poszczególne przedmioty
        // Zmiana założeń - przedmiot powinien mieć ocenę, a nie ocena przedmiot
        Student romek = new Student("Romek", "Jarząbek");
        Przedmiot fizyka = new Przedmiot("fizyka", 12);
        Ocena ocenaZaFizyke = new Ocena(3);
        fizyka.setOcena(ocenaZaFizyke);
        Przedmiot chemia = new Przedmiot("chemia", 9);
        chemia.setOcena(new Ocena(4));
        Grupa grupaScisla = new Grupa("ścisła");
        grupaScisla.dodajPrzedmiot(fizyka);
        grupaScisla.dodajPrzedmiot(chemia);
        romek.dodajGrupe(grupaScisla);
        BazaDanych.INSTANCJA.listaStudentow.add(romek);
        System.out.println(romek);

        // 10. Każdy przedmiot posiada ocenę oraz ilość punktów ECTS, którą student zdobywa za zaliczenie
        Student michal = new Student("Michał", "Kowal");
        Grupa grupaSportowa = new Grupa("grupaSportowa");
        Przedmiot wychFiz = new Przedmiot("Wychowanie Fizyczne", 2);
        Ocena ocenaZaWF = new Ocena(5);
        wychFiz.setOcena(ocenaZaWF);
        grupaSportowa.dodajPrzedmiot(wychFiz);
        michal.dodajGrupe(grupaSportowa);
        Przedmiot jNiemiecki = new Przedmiot("j. niemiecki", 6);
        Grupa grupaJezykowa = new Grupa("grupaJezykowa");
        grupaJezykowa.dodajPrzedmiot(jNiemiecki);
        jNiemiecki.setOcena(new Ocena(4));
        michal.dodajGrupe(grupaJezykowa);
        BazaDanych.INSTANCJA.listaStudentow.add(michal);
        System.out.println(michal);
    }

    private static void zaloguj() throws IOException {
        int iloscProbLogowania = 0;
        while (iloscProbLogowania < MAX_ILOSC_PROB_LOGOWANIA) {
            Properties daneDostepowe = new Properties();
            InputStream inputStream = Dziekanat.class.getResourceAsStream("dostep.properties");
            daneDostepowe.load(inputStream);

            String uzytkownik = WierszPolecen.INSTANCJA.wczytajTekst("Podaj nazwe uzytkownika: ");
            String haslo = WierszPolecen.INSTANCJA.wczytajTekst("Podaj hasło uzytkownika: ");

            if (uzytkownik.equals(daneDostepowe.getProperty("uzytkownik")) && haslo.equals(daneDostepowe.getProperty("haslo"))) {
                System.out.println("UDOSTĘPNIONO");
                return;
            } else {
                System.out.println("Wprowadzono bledne dane dostępowe!");
                iloscProbLogowania ++;
            }
        }
        System.exit(1);
    }

}
