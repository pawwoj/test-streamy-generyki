package minmax;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MinMaxServiceTest {

    @Test
    @DisplayName("Rzuca NoSuchElementException gdy parametrem jest null")
    void getMinAndMax_NoSuchElementExceptionDlaNull() {
        assertThatThrownBy(() -> MinMaxService.getMinAndMax(null)).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("Rzuca NoSuchElementException gdy parametrem jest pusta")
    void getMinAndMax_NoSuchElementExceptionDlaPustejListy() {
        assertThatThrownBy(() -> {
            List<Integer> integerList = new ArrayList<>();
            MinMaxService.getMinAndMax(integerList);
        }).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("Zwracana  minimalna wartosc z listy Integerow jest Integerem")
    void getMinAndMax_ZwracaIntegeraZLIstyIntegerowDlaMin() {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(3, 6, -2, 21, null, -421, 2));

        assertThat(MinMaxService.getMinAndMax(integerList).getMin()).isExactlyInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("Zwracana  maksymalna wartosc z listy Integerow jest Integerem")
    void getMinAndMax_ZwracaIntegeraZLIstyIntegerowDlaMax() {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(3, 6, -2, 21, null, -421, 2));

        assertThat(MinMaxService.getMinAndMax(integerList).getMax()).isExactlyInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("Zwracana  minimalna wartosc z listy intow jest prawidlowa")
    void getMinAndMax_getMinInteger() {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(3, 6, -2, 21, null, -421, 2));

        assertThat(MinMaxService.getMinAndMax(integerList).getMin()).isEqualTo(-421);
    }

    @Test
    @DisplayName("Zwracana  maksymalna wartosc z listy intow jest prawidlowa")
    void getMinAndMax_getMaxInteger() {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(3, 6, -2, 21, null, -421, 2));

        assertThat(MinMaxService.getMinAndMax(integerList).getMax()).isEqualTo(21);
    }

    @Test
    @DisplayName("Zwracana  minimalna wartosc z listy Stringow jest Stringiem")
    void getMinAndMax_ZwracaStringaZLIstyStringowDlaMin() {
        List<String> stringList = new ArrayList<>(Arrays.asList("Rad", "Tlen", "Zloto", null, "Polon", "Azot"));

        assertThat(MinMaxService.getMinAndMax(stringList).getMin()).isExactlyInstanceOf(String.class);
    }

    @Test
    @DisplayName("Zwracana  maksymalna wartosc z listy Stringow jest Stringiem")
    void getMinAndMax_ZwracaStringaZLIstyStringowDlaMax() {
        List<String> stringList = new ArrayList<>(Arrays.asList("Rad", "Tlen", "Zloto", null, "Polon", "Azot"));

        assertThat(MinMaxService.getMinAndMax(stringList).getMax()).isExactlyInstanceOf(String.class);
    }

    @Test
    @DisplayName("Zwracana  minimalna wartosc z listy Stringow jest prawidlowa")
    void getMinAndMax_getMinString() {
        List<String> stringList = new ArrayList<>(Arrays.asList("Rad", "Tlen", "Zloto", null, "Polon", "Azot"));

        assertThat(MinMaxService.getMinAndMax(stringList).getMin()).isEqualTo("Azot");
    }

    @Test
    @DisplayName("Zwracana  maksymalna wartosc z listy Stringow jest prawidlowa")
    void getMinAndMax_getMaxString() {
        List<String> stringList = new ArrayList<>(Arrays.asList("Rad", "Tlen", "Zloto", null, "Polon", "Azot"));

        assertThat(MinMaxService.getMinAndMax(stringList).getMax()).isEqualTo("Zloto");
    }

    @Test
    @DisplayName("Zwracana  minimalna wartosc z listy Osob jest klasy Osoba")
    void getMinAndMax_ZwracaOsobeZLIstyOsobDlaMin() {
        Osoba o1 = new Osoba("Monika", "Ccc");
        Osoba o2 = new Osoba("Klaudia", "Ggg");
        Osoba o3 = new Osoba("Adam", "Bbb");
        Osoba o4 = new Osoba("Franciszek", "Lll");
        Osoba o5 = new Osoba("Aleksandra", "Zzz");
        Osoba max = new Osoba("Tomek", "Zzz");
        Osoba o7 = new Osoba("Katarzyna", "Ooo");
        Osoba o8 = new Osoba("Marek", "Aaa");
        Osoba min = new Osoba("Izabella", "Aaa");

        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4, o5, null, max, o7, o8, min));

        assertThat(MinMaxService.getMinAndMax(list).getMin()).isExactlyInstanceOf(Osoba.class);
    }

    @Test
    @DisplayName("Zwracana  maksymalna wartosc z listy Osob jest klasy Osoba")
    void getMinAndMax_ZwracaOsobaZLIstyOsobDlaMax() {
        Osoba o1 = new Osoba("Monika", "Ccc");
        Osoba o2 = new Osoba("Klaudia", "Ggg");
        Osoba o3 = new Osoba("Adam", "Bbb");
        Osoba o4 = new Osoba("Franciszek", "Lll");
        Osoba o5 = new Osoba("Aleksandra", "Zzz");
        Osoba max = new Osoba("Tomek", "Zzz");
        Osoba o7 = new Osoba("Katarzyna", "Ooo");
        Osoba o8 = new Osoba("Marek", "Aaa");
        Osoba min = new Osoba("Izabella", "Aaa");

        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4, o5, null, max, o7, o8, min));

        assertThat(MinMaxService.getMinAndMax(list).getMax()).isExactlyInstanceOf(Osoba.class);
    }

    @Test
    @DisplayName("Zwracana  minimalna wartosc z listy Osob jest prawidlowa")
    void getMinAndMax_getMinOsoba() {
        Osoba o1 = new Osoba("Monika", "Ccc");
        Osoba o2 = new Osoba("Klaudia", "Ggg");
        Osoba o3 = new Osoba("Adam", "Bbb");
        Osoba o4 = new Osoba("Franciszek", "Lll");
        Osoba o5 = new Osoba("Aleksandra", "Zzz");
        Osoba max = new Osoba("Tomek", "Zzz");
        Osoba o7 = new Osoba("Katarzyna", "Ooo");
        Osoba o8 = new Osoba("Marek", "Aaa");
        Osoba min = new Osoba("Izabella", "Aaa");

        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4, o5, null, max, o7, o8, min));

        assertThat(MinMaxService.getMinAndMax(list).getMin()).isEqualTo(min);
    }

    @Test
    @DisplayName("Zwracana  maksymalna wartosc z listy Osob jest prawidlowa")
    void getMinAndMax_getMaxOsoba() {
        Osoba o1 = new Osoba("Monika", "Ccc");
        Osoba o2 = new Osoba("Klaudia", "Ggg");
        Osoba o3 = new Osoba("Adam", "Bbb");
        Osoba o4 = new Osoba("Franciszek", "Lll");
        Osoba o5 = new Osoba("Aleksandra", "Zzz");
        Osoba max = new Osoba("Tomek", "Zzz");
        Osoba o7 = new Osoba("Katarzyna", "Ooo");
        Osoba o8 = new Osoba("Marek", "Aaa");
        Osoba min = new Osoba("Izabella", "Aaa");

        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4, o5, null, max, o7, o8, min));
        assertThat(MinMaxService.getMinAndMax(list).getMax()).isEqualTo(max);
    }
}