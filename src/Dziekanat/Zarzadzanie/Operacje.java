package Dziekanat.Zarzadzanie;

import Dziekanat.ObiektyZarzadzane.Obiekt;

import java.io.IOException;

public interface Operacje {

    Obiekt dodaj() throws IOException;

    Object edytuj() throws IOException;

    void usun() throws IOException;

    void wyswietl();
}
