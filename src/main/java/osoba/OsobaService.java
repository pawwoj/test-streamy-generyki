package osoba;

import osoba.exception.NoWomenException;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OsobaService {
    //- metoda co zwraca najstarsza kobiete (imie konczy sie na 'a') - lub NoWomenException jesli brak kobiet na liscie
    public Osoba najstarszaKobieta(List<Osoba> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(o -> Objects.nonNull(o.getImie()))
                .filter(o -> o.getImie().endsWith("a"))
                .max(Comparator.comparingInt(Osoba::getWiek))
                .orElseThrow(NoWomenException::new);
    }

    //- metode ktora zwraca sredni wiek wszystkich osob
    public double sredniaWieku(List<Osoba> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.averagingDouble(Osoba::getWiek));
    }

    //- metode ktora zwraca sredni wiek mezczyzn
    public double sredniaWiekuMezczyzn(List<Osoba> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(o -> Objects.nonNull(o.getImie()))
                .filter(o -> !o.getImie().endsWith("a"))
                .collect(Collectors.averagingDouble(Osoba::getWiek));
    }

    //- metode ktora zwrca sredni wiek kobiet
    public double sredniaWiekuKobiet(List<Osoba> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(o -> Objects.nonNull(o.getImie()))
                .filter(o -> o.getImie().endsWith("a"))
                .collect(Collectors.averagingDouble(Osoba::getWiek));
    }

    //- metode ktora agreguje dwie metody powyzej (tzn: jako drugi parametr przyjmuje funkcje ktora okresla plec)
    public double sredniaWiekuParam(List<Osoba> list, Predicate<Osoba> plec) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(o -> Objects.nonNull(o.getImie()))
                .filter(plec)
                .collect(Collectors.averagingDouble(Osoba::getWiek));
    }

    //- metode ktora znajdze miasto w ktorym zyje najwiecej ludzi
    public String miastoZNajwiekszaIlosciaLudzi(List<Osoba> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(Osoba::getMiasto)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    //- metode ktora zwroci wszystkie rozne miasta z listy osob (rozne tzn: bez powtorzen)
    public List<String> wszystkieMiasta(List<Osoba> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(Osoba::getMiasto)
                .filter(Objects::nonNull)
                .distinct()
                .toList();
    }
}
