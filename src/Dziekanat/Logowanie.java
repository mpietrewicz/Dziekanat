package Dziekanat;

import Dziekanat.Zarzadzanie.WierszPolecen;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.*;

public class Logowanie {
    private static final int MAX_ILOSC_PROB_LOGOWANIA = 3;


    public void zaloguj() throws IOException {

        Logger logger = Logger.getLogger("logowanie");
        Handler handler = new ConsoleHandler();
        Formatter formatter = new SimpleFormatter();

        handler.setFormatter(formatter);
        logger.addHandler(handler);
        logger.setLevel(Level.WARNING);


        int iloscProbLogowania = 0;
        while (iloscProbLogowania < MAX_ILOSC_PROB_LOGOWANIA) {
            Properties daneDostepowe = new Properties();
            InputStream inputStream = Dziekanat.class.getResourceAsStream("dostep.properties");
            daneDostepowe.load(inputStream);

            String uzytkownik = WierszPolecen.INSTANCJA.wczytajTekst("Podaj nazwe uzytkownika: ");
            String haslo = WierszPolecen.INSTANCJA.wczytajTekst("Podaj hasło uzytkownika: ");

            if (uzytkownik.equals(daneDostepowe.getProperty("uzytkownik")) && haslo.equals(daneDostepowe.getProperty("haslo"))) {
                System.out.println("UDOSTĘPNIONO");
                logger.log(Level.INFO, "Zalogowano pomyślnie");
                return;
            } else {
                System.out.println("Wprowadzono bledne dane dostępowe!");
                logger.log(Level.WARNING, "Błąd logowania! Wprowadzono bledne dane dostępowe!");
                iloscProbLogowania ++;
            }
        }
        System.exit(1);
    }
}
