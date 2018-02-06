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
    }
}
