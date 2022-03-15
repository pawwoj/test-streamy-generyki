package osoba;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import osoba.exception.NoWomenException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OsobaServiceTest {

    @Test
    @DisplayName("najstarszaKobieta rzuca wyjatek NoWomenException gdy nie ma kobiet na liscie")
    void najstarszaKobieta_NoWomanException() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<osoba.Osoba> list = new ArrayList<>(Arrays.asList(o1, o4));

        assertThatThrownBy(() -> service.najstarszaKobieta(list)).isInstanceOf(NoWomenException.class);
    }

    @Test
    @DisplayName("Zwracana najstarsza kobieta nie jest nullem")
    void najstarszaKobieta_NotNull() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Warszawa");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Krakow");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.najstarszaKobieta(list)).isNotNull();

    }

    @Test
    @DisplayName("Zwracana najstarsza kobieta jest klasy Osoba")
    void najstarszaKobieta_KlasyOsoba() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Warszawa");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Krakow");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.najstarszaKobieta(list)).isExactlyInstanceOf(Osoba.class);
    }

    @Test
    @DisplayName("Zwracana najstarsza kobieta jest zgodna z oczekiwana")
    void najstarszaKobieta_Oczekiwana() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.najstarszaKobieta(list)).isEqualTo(o3);
    }

    @Test
    @DisplayName("Zwracany sredni wiek osob nie jest nullem")
    void sredniaWieku_NotNull() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.sredniaWieku(list)).isNotNull();
    }

    @Test
    @DisplayName("Zwracany sredni wiek osob jest klasy Double")
    void sredniaWieku_Double() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.sredniaWieku(list)).isExactlyInstanceOf(Double.class);
    }

    @Test
    @DisplayName("Zwracany sredni wiek osob jest zgodny z oczekiwanym")
    void sredniaWieku_Oczekiwana() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.sredniaWieku(list)).isEqualTo(42.5);
    }

    @Test
    @DisplayName("Zwracany sredni wiek mezczyzn nie jest nullem")
    void sredniaWiekuMezczyzn_NotNull() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.sredniaWiekuMezczyzn(list)).isNotNull();
    }

    @Test
    @DisplayName("Zwracany sredni wiek mezczyzn jest klasy Double")
    void sredniaWiekuMezczyzn_Double() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.sredniaWiekuMezczyzn(list)).isExactlyInstanceOf(Double.class);
    }

    @Test
    @DisplayName("Zwracany sredni wiek mezczyzn jest zgodny z oczekiwanym")
    void sredniaWiekuMezczyzn_Oczekiwany() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.sredniaWiekuMezczyzn(list)).isEqualTo(25);
    }

    @Test
    @DisplayName("Zwracany sredni wiek kobiet nie jest nullem")
    void sredniaWiekuKobiet_NotNull() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.sredniaWiekuKobiet(list)).isNotNull();
    }

    @Test
    @DisplayName("Zwracany sredni wiek kobiet jest klasy Double")
    void sredniaWiekuKobiet_Double() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.sredniaWiekuKobiet(list)).isExactlyInstanceOf(Double.class);
    }

    @Test
    @DisplayName("Zwracany sredni wiek kobiet jest zgodny z oczekiwanym")
    void sredniaWiekuKobiet_Oczekiwany() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.sredniaWiekuKobiet(list)).isEqualTo(60);
    }

    @Test
    @DisplayName("Zwracany sredni wiek z parametrem nie jest nullem")
    void sredniaWiekuParam_NotNull() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));
        Predicate<Osoba> kobiety = o -> o.getImie().endsWith("a");

        assertThat(service.sredniaWiekuParam(list, kobiety)).isNotNull();
    }

    @Test
    @DisplayName("Zwracany sredni wiek z parametrem jest klasy Double")
    void sredniaWiekuParam_Double() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));
        Predicate<Osoba> kobiety = o -> o.getImie().endsWith("a");

        assertThat(service.sredniaWiekuParam(list, kobiety)).isExactlyInstanceOf(Double.class);
    }

    @Test
    @DisplayName("Zwracany sredni wiek z parametrem kobiety jest zgodna z oczekiwanym")
    void sredniaWiekuParam_OczekiwanyDlaKobiet() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));
        Predicate<Osoba> kobiety = o -> o.getImie().endsWith("a");

        assertThat(service.sredniaWiekuParam(list, kobiety)).isEqualTo(60);
    }

    @Test
    @DisplayName("Zwracany sredni wiek z parametrem merzczyzni jest zgodna z oczekiwanym")
    void sredniaWiekuParam_OczekiwanyDlaMezczyzn() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));
        Predicate<Osoba> mezczyzni = o -> !o.getImie().endsWith("a");

        assertThat(service.sredniaWiekuParam(list, mezczyzni)).isEqualTo(25);
    }

    @Test
    @DisplayName("Zwracana nazwa miasta nie jest nullem")
    void miastoZNajwiekszaIlosciaLudzi_NotNull() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.miastoZNajwiekszaIlosciaLudzi(list)).isNotNull();
    }

    @Test
    @DisplayName("Zwracana nazwa miasta jest klasy String")
    void miastoZNajwiekszaIlosciaLudzi_String() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.miastoZNajwiekszaIlosciaLudzi(list)).isExactlyInstanceOf(String.class);
    }

    @Test
    @DisplayName("Zwracana nazwa miasta jest zgodna z oczekiwana")
    void miastoZNajwiekszaIlosciaLudzi_Oczekiwany() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.miastoZNajwiekszaIlosciaLudzi(list)).isEqualTo("Warszawa");
    }

    @Test
    @DisplayName("Zwracana lista miast nie jest nullem")
    void wszystkieMiasta_NotNull() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.wszystkieMiasta(list)).isNotNull();
    }

    @Test
    @DisplayName("Zwracana lista miast nie jest pusta")
    void wszystkieMiasta_NotEmpty() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.wszystkieMiasta(list)).isNotEmpty();
    }

    @Test
    @DisplayName("Zwracana lista miast ma oczekiwany rozmiar")
    void wszystkieMiasta_MaOczekiwanyRozmiar() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

        assertThat(service.wszystkieMiasta(list)).hasSize(3);
    }

    @Test
    @DisplayName("Zwracana lista miast zawiera oczekiwane miasta")
    void wszystkieMiasta_ZawieraOczekiwaneWartosci() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));
        List<String> oczekiwana = new ArrayList<>(Arrays.asList("Krakow", "Warszawa", "Opole"));

        assertThat(service.wszystkieMiasta(list)).containsAll(oczekiwana);
    }

    @Test
    @DisplayName("Zwracana lista miast jest jak oczekiwana lista")
    void wszystkieMiasta_Oczekiwana() {
        OsobaService service = new OsobaService();
        Osoba o1 = new Osoba("Adam", "Nazwisko1", 10, "Krakow");
        Osoba o2 = new Osoba("Klaudia", "Nazwisko2", 20, "Warszawa");
        Osoba o3 = new Osoba("Aleksandra", "Nazwisko3", 100, "Warszawa");
        Osoba o4 = new Osoba("Marek", "Nazwisko4", 40, "Opole");
        List<Osoba> list = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));
        List<String> oczekiwana = new ArrayList<>(Arrays.asList("Krakow", "Warszawa", "Opole"));

        assertThat(service.wszystkieMiasta(list)).isEqualTo(oczekiwana);
    }
}