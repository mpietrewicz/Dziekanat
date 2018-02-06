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

    }
}
