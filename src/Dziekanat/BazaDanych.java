package Dziekanat;
import Dziekanat.ObiektyZarzadzane.*;

import java.util.ArrayList;

public enum BazaDanych {
    INSTANCJA;

    public ArrayList<Student> listaStudentow =  new ArrayList<Student>();
    public ArrayList<Nauczyciel> listaNauczycieli =  new ArrayList<Nauczyciel>();
    public ArrayList<Przedmiot> listaPrzedmiotow =  new ArrayList<Przedmiot>();
    public ArrayList<Ocena> listaOcen =  new ArrayList<Ocena>();
    public ArrayList<Grupa> listaGrup =  new ArrayList<Grupa>();
}
