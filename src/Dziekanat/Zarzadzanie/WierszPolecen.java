package Dziekanat.Zarzadzanie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public enum WierszPolecen {
    INSTANCJA;

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public final String WYRAZENIE_REGULARNE_DLA_TEKSTU = "^[A-z]+$";
    public final String WYRAZENIE_REGULARNE_DLA_LICZBY = "^[0-9]+$";

    public String wczytajTekst(String komunikat) throws IOException {
        while (true) {
            System.out.print(komunikat+": ");
            String wczytanyTekst = bufferedReader.readLine();
            if (wczytanyTekst.matches(WYRAZENIE_REGULARNE_DLA_TEKSTU)) {
                return wczytanyTekst;
            } else {
                System.out.println("Wprowadzono niepoprawnie dane!");
            }
        }
    }

    public int wczytajLiczbeZZakresu(String komunikat, int poczatekZakresu, int koniecZakresu) throws IOException {
        while (true) {
            System.out.print(komunikat+": ");
            String wczytanyTekst = bufferedReader.readLine();
            if (wczytanyTekst.matches(WYRAZENIE_REGULARNE_DLA_LICZBY)) {
                Integer wczytanaLiczba = Integer.parseInt(wczytanyTekst);
                if (wczytanaLiczba >= poczatekZakresu && wczytanaLiczba <= koniecZakresu) {
                    return wczytanaLiczba;
                }
                else {
                    System.out.println("Wprowadzona liczba jest poza zakresem");
                }
            } else {
                System.out.println("Nie wprowadzono liczby!");
            }
        }
    }


}
