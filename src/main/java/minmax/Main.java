package minmax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*1: Stworz klase MinMax<T extends Comparable> ktora jako pola klasy pobiera instancje T max oraz T min
Nastepnie stworz klase MinMaxService ktora bedzie miala statyczna metode
MinMax<cos tutaj> getMinAndMax(List<cos tutaj> elements)
zadaniem tej metody jest zwracanie mina i maxa z listy w tym jednym obiekcie
wg naturalnego porządku jaki gwarantuje komparator,
klasa MinMax powinna byc generyczna i metody getMin
oraz getMax powinny zwraca instancje tego co bedzie na liscie elements,
czyli jak przekazemy liste stringow to getMax ma zwraca String,
getMin tez stringa a jak damy liste osob to ma getMax
zwraca osobe, itp itd.*/
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(3, 6, -2, 21, null, -421, 2));
        List<String> stringList = new ArrayList<>(Arrays.asList("Rad", "Tlen", "Złoto", null, "Polon", "Azot"));
        Osoba o1 = new Osoba("Monika", "Ccc");
        Osoba o2 = new Osoba("Klaudia", "Ggg");
        Osoba o3 = new Osoba("Adam", "Bbb");
        Osoba o4 = new Osoba("Franciszek", "Lll");
        Osoba o5 = new Osoba("Aleksandra", "Zzz");
        Osoba o6 = new Osoba("Tomek", "Zzz");
        Osoba o7 = new Osoba("Katarzyna", "Ooo");
        Osoba o8 = new Osoba("Marek", "Aaa");
        Osoba o9 = new Osoba("Izabella", "Ppp");

        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4, o5, null, o6, o7, o8, o9));
        System.out.println(list);

        System.out.println(MinMaxService.getMinAndMax(integerList));
        System.out.println(MinMaxService.getMinAndMax(integerList).getMin());
        System.out.println(MinMaxService.getMinAndMax(integerList).getMax());
        System.out.println(MinMaxService.getMinAndMax(stringList));
        System.out.println(MinMaxService.getMinAndMax(list));
    }
}
