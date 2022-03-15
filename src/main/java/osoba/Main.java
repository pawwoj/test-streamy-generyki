package osoba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    /*
    3. Stworz sobie klase Osoba (imie, nazwisko, miasto, wiek)
- metoda co zwraca najstarsza kobiete (imie konczy sie na 'a') - lub NoWomenException jesli brak kobiet na liscie
- metode ktora zwraca sredni wiek wszystkich osob
- metode ktora zwraca sredni wiek mezczyzn
- metode ktora zwrca sredni wiek kobiet
- metode ktora agreguje dwie metody powyzej (tzn: jako drugi parametr przyjmuje funkcje ktora okresla plec)
- metode ktora znajdze miasto w ktorym zyje najwiecej ludzi
- metode ktora zwroci wszystkie rozne miasta z listy osob (rozne tzn: bez powtorzen)*/
    public static void main(String[] args) {

        Osoba o1 = new Osoba("Monika", "Nazwisko1", 21, "Warszawa");
        Osoba o2 = new Osoba("Adam", "Nazwisko2", 22, "Warszawa");
        Osoba o3 = new Osoba("Klaudia", "Nazwisko3", 23, "Warszawa");
        Osoba o4 = new Osoba("Franciszek", "Nazwisko4", 24, "Krakow");
        Osoba o5 = new Osoba("Aleksandra", "Nazwisko5", 99, "Krakow");
        Osoba o6 = new Osoba("Tomek", "Nazwisko6", 26, "Krakow");
        Osoba o7 = new Osoba("Katarzyna", "Nazwisko7", 27, "Krakow");
        Osoba o8 = new Osoba("Marek", "Nazwisko8", 28, "Opole");
        Osoba o9 = new Osoba("Izabella", "Nazwisko9", 29, "Opole");

        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4, o5, null, o6, o7, o8, o9));

        OsobaService service = new OsobaService();

        System.out.println(service.najstarszaKobieta(list));
        System.out.println(service.sredniaWieku(list));
        System.out.println(service.sredniaWiekuMezczyzn(list));
        System.out.println(service.sredniaWiekuKobiet(list));

        Predicate<Osoba> kobiety = o -> o.getImie().endsWith("a");
        Predicate<Osoba> mezczyzni = o -> !o.getImie().endsWith("a");
        System.out.println(service.sredniaWiekuParam(list, kobiety));
        System.out.println(service.sredniaWiekuParam(list, mezczyzni));

        System.out.println(service.miastoZNajwiekszaIlosciaLudzi(list));
        System.out.println(service.wszystkieMiasta(list));
    }
}
