package Dziekanat;

import Dziekanat.ObiektyZarzadzane.*;
import Dziekanat.Zarzadzanie.*;

import java.io.IOException;

public class Dziekanat {
    public static final int LICZBA_PUNKTOW_ECTS_POTRZEBNA_DO_PROMOCJI = 20;

    public static void main(String[] args) throws IOException {
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
                    // 4. Zarządzanie ocenami
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
        System.out.println(grupa4c);
        System.out.println(grupa4d);

        // 9. Studentom można wystawiać oceny za poszczególne przedmioty
        Student romek = new Student("Romek", "Jarząbek");
        Przedmiot fizyka = new Przedmiot("fizyka", 12);
        Ocena ocenaZaFizyke = new Ocena(3, fizyka);
        romek.dodajOcene(ocenaZaFizyke);
        Przedmiot chemia = new Przedmiot("chemia", 9);
        romek.dodajOcene(new Ocena(4, chemia));
        ocenaZaFizyke.setStopien(5);
        System.out.println(romek);

        // 10. Każdy przedmiot posiada ilość punktów ECTS, którą student zdobywa za zaliczenie
        Student michal = new Student("Michał", "Kowal");
        Przedmiot wychFiz = new Przedmiot("Wychowanie Fizyczne", 2);
        Ocena ocenaZaWF = new Ocena(5, wychFiz);
        michal.dodajOcene(ocenaZaWF);
        Przedmiot jNiemiecki = new Przedmiot("j. niemiecki", 6);
        michal.dodajOcene(new Ocena(4, jNiemiecki));
        michal.dodajOcene(new Ocena(2, new Przedmiot("j. francuski", 9)));
        System.out.println(michal);
    }

    private static void zarzadzaj(ObiektMenadzer obiektMenadzer, final String kontekst) throws IOException {
        int idOperacji = 0;
        while (idOperacji != 4) {
            System.out.println("Zarządzanie " + kontekst + ": \n1. Dodaj, 2. Usuń, 3. Wyświetl. 4. Wyjdź");
            idOperacji = WierszPolecen.INSTANCJA.wczytajLiczbeZZakresu("Podaj id operacji",
                    1, 4);
            switch (idOperacji) {
                case 1:
                    obiektMenadzer.dodaj();
                    break;
                case 2:
                    obiektMenadzer.usun();
                    break;
                case 3:
                    obiektMenadzer.wyswietl();
                    break;
            }
        }
    }
}
