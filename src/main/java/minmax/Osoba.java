package minmax;

public class Osoba implements Comparable<Osoba> {
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }

    @Override
    public int compareTo(Osoba o) {
        if (this.nazwisko.compareTo(o.getNazwisko()) == 0) {
            return this.imie.compareTo(o.getImie());
        } else {
            return this.nazwisko.compareTo(o.getNazwisko());
        }
    }
}
