package Dziekanat.Zarzadzanie;

import Dziekanat.ObiektyZarzadzane.Obiekt;

import java.io.IOException;
import java.util.ArrayList;

public interface Operacje {

    Obiekt dodaj() throws IOException;

    Object edytuj() throws IOException;

    void usun(ArrayList listaObiektow, String kontekst) throws IOException;

    void wyswietl(ArrayList listaObiektow);
}
