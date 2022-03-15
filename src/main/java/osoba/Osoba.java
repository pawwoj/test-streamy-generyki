package osoba;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Osoba {
    private static List<Osoba> ekstensja = new ArrayList<>();
    private String imie;
    private String nazwisko;
    private int wiek;
    private String miasto;

    public Osoba(String imie, String nazwisko, int wiek, String miasto) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.miasto = miasto;
        ekstensja.add(this);
    }

    public static List<Osoba> getEkstensja() {
        return ekstensja;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public String getMiasto() {
        return miasto;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " " + wiek + " " + miasto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return wiek == osoba.wiek
                && Objects.equals(imie, osoba.imie)
                && Objects.equals(nazwisko, osoba.nazwisko)
                && Objects.equals(miasto, osoba.miasto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, wiek, miasto);
    }
}
