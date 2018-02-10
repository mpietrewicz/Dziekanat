package Dziekanat.Zarzadzanie;

import java.util.ArrayList;

public class ObiektMenadzer {

    public void wyswietlListeObiektow(ArrayList listaObiektow) {
        int index = 0;
        for (Object obiekt : listaObiektow) {
            System.out.println(index +": " +obiekt);
            index++;
        }
    }
}
