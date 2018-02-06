package Dziekanat;

public class Dziekanat {

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
        Przedmiot przedmiotInformatyka = new Przedmiot("Informatyka");
        przedmiotInformatyka.setNazwa("Inf.");
        Lista.INSTANCJA.listaPrzedmiotow.add(przedmiotInformatyka);
        System.out.println(Lista.INSTANCJA.listaPrzedmiotow.size());
        Lista.INSTANCJA.listaPrzedmiotow.remove(0);

        // 4. Zarządzanie ocenami
        Ocena ocena = new Ocena(5);
        ocena.setStopien(4);
        Lista.INSTANCJA.listaOcen.add(ocena);

        // 5. Zarządzanie grupami
        Grupa grupa1a = new Grupa("1a");
        Lista.INSTANCJA.listaGrup.add(grupa1a);
        System.out.println(Lista.INSTANCJA.listaGrup.get(0));

        // 6. Nauczyciele są powiązani z przedmiotami, które prowadzą
        Nauczyciel nauczycielMarek = new Nauczyciel("Marek", "Pietrewicz");
        Przedmiot matematyka = new Przedmiot("matematyka");
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
        Przedmiot jPolski = new Przedmiot("język polski");
        Przedmiot jAngielski = new Przedmiot("język angielski");
        grupa4c.dodajPrzedmiot(jPolski);
        grupa4c.dodajPrzedmiot(jAngielski);
        grupa4c.usunPrzedmiot(jAngielski);
        Grupa grupa4d = new Grupa("4D");
        grupa4d.dodajPrzedmiot(jAngielski);
        System.out.println(grupa4c);
        System.out.println(grupa4d);
    }
}
