package Dziekanat;

public class Dziekanat {
    public static final int LICZBA_PUNKTOW_ECTS_POTRZEBNA_DO_PROMOCJI = 20;

    public static void main(String[] args) {
        // 1. Zarządzanie studentami (wstaw, usuń, edytuj)
        Student studentJan = new Student("Jan", "Kowalski");
        Lista.INSTANCJA.listaStudentow.add(studentJan);
        Student studentAnna = new Student("Anna", "Nowak");
        Lista.INSTANCJA.listaStudentow.add(studentAnna);
        Lista.INSTANCJA.listaStudentow.remove(0);
        studentAnna.setImie("Magda");
        studentAnna.setNazwisko("Kowalska");
        for (Student student : Lista.INSTANCJA.listaStudentow) {
            System.out.println(student);
        }

        // 2. Zarządzanie nauczycielami
        Nauczyciel nauczycielAdam = new Nauczyciel("Adam", "Nowak");
        Lista.INSTANCJA.listaNauczycieli.add(nauczycielAdam);
        Lista.INSTANCJA.listaNauczycieli.get(0).setImie("Wojciech");
        for (Nauczyciel nauczyciel : Lista.INSTANCJA.listaNauczycieli) {
            System.out.println(nauczyciel);
        }
        Lista.INSTANCJA.listaNauczycieli.remove(0);
        System.out.println(Lista.INSTANCJA.listaNauczycieli.size());

        // 3. Zarządzanie przedmiotami
        Przedmiot przedmiotInformatyka = new Przedmiot("Informatyka", 8);
        przedmiotInformatyka.setNazwa("Inf.");
        Lista.INSTANCJA.listaPrzedmiotow.add(przedmiotInformatyka);
        System.out.println(Lista.INSTANCJA.listaPrzedmiotow.size());
        Lista.INSTANCJA.listaPrzedmiotow.remove(0);

        // 4. Zarządzanie ocenami
        Przedmiot geografia = new Przedmiot("geografia", 6);
        Ocena ocena = new Ocena(5, geografia);
        ocena.setStopien(4);
        Lista.INSTANCJA.listaOcen.add(ocena);

        // 5. Zarządzanie grupami
        Grupa grupa1a = new Grupa("1a");
        Lista.INSTANCJA.listaGrup.add(grupa1a);
        System.out.println(Lista.INSTANCJA.listaGrup.get(0));

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
        janek.dodajDoGrupy(grupa3b);
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
}
