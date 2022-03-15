package kalkulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KalkulatorTest {

    @Test
    @DisplayName("Zwracana wartosc sumowania intow jest prawidlowa")
    void licz_dodawanieInt() {
        Kalkulator kalkulator = new Kalkulator();

        assertThat(kalkulator.licz("+", 10, 20)).isEqualTo(30);
    }

    @Test
    @DisplayName("Zwracana wartosc sumowania doubli jest prawidlowa")
    void licz_dodawanieDouble() {
        Kalkulator kalkulator = new Kalkulator();

        assertThat(kalkulator.licz("+", 10.5, 20.2)).isEqualTo(30.7);
    }

    @Test
    @DisplayName("Zwracana wartosc roznicy intow jest prawidlowa")
    void licz_odejmowanieInt() {
        Kalkulator kalkulator = new Kalkulator();

        assertThat(kalkulator.licz("-", 10, 20)).isEqualTo(-10);
    }

    @Test
    @DisplayName("Zwracana wartosc roznicy doubli jest prawidlowa")
    void licz_odejmowanieDouble() {
        Kalkulator kalkulator = new Kalkulator();

        assertThat(kalkulator.licz("-", 10.5, 20.2)).isEqualTo(-9.7);
    }

    @Test
    @DisplayName("Zwracana wartosc iloczynu intow jest prawidlowa")
    void licz_mnozenieInt() {
        Kalkulator kalkulator = new Kalkulator();

        assertThat(kalkulator.licz("*", 10, 20)).isEqualTo(200);
    }

    @Test
    @DisplayName("Zwracana wartosc iloczynu doubli jest prawidlowa")
    void licz_mnozenieDouble() {
        Kalkulator kalkulator = new Kalkulator();
        double wynik = Math.round(kalkulator.licz("*", 10.5, 20.2) * 100.0) / 100.0;
        assertThat(wynik).isEqualTo(212.1);
    }

    @Test
    @DisplayName("Zwracana wartosc ilorazu intow jest prawidlowa")
    void licz_dzielenieInt() {
        Kalkulator kalkulator = new Kalkulator();
        double wynik = Math.round(kalkulator.licz("/", 10, 20) * 100.0) / 100.0;
        assertThat(wynik).isEqualTo(0.5);
    }

    @Test
    @DisplayName("Zwracana wartosc ilorazu doubli jest prawidlowa")
    void licz_dzielenieDouble() {
        Kalkulator kalkulator = new Kalkulator();
        double wynik = Math.round(kalkulator.licz("/", 10.5, 20.6) * 100.0) / 100.0;
        assertThat(wynik).isEqualTo(0.51);
    }
}