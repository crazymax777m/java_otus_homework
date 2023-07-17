import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    private CurrencyConverter currencyConverter;

    @BeforeEach
    void setUp() {
        currencyConverter = new CurrencyConverter();
    }

    @Test
    void convert1568() {
        String expected = "одна тысяча пятьсот шестьдесят восемь рублей";
        String actual = currencyConverter.convert(1568);
        assertEquals(expected, actual);
    }

    @Test
    void convertMinus1568() {
        String expected = "минус одна тысяча пятьсот шестьдесят восемь рублей";
        String actual = currencyConverter.convert(-1568);
        assertEquals(expected, actual);
    }

    @Test
    void convertZero() {
        String expected = "ноль рублей";
        String actual = currencyConverter.convert(0);
        assertEquals(expected, actual);
    }

    @Test
    void convertMinusZero() {
        String expected = "ноль рублей";
        String actual = currencyConverter.convert(-0);
        assertEquals(expected, actual);
    }

    @Test
    void convertMultipleZeroes() {
        String expected = "ноль рублей";
        String actual = currencyConverter.convert(0000000000000);
        assertEquals(expected, actual);
    }

    @Test
    void convertMinusMultipleZeroes() {
        String expected = "ноль рублей";
        String actual = currencyConverter.convert(-0000000000000);
        assertEquals(expected, actual);
    }

    @Test
    void convert456546321() {
        String expected = "четыреста пятьдесят шесть миллионов пятьсот сорок шесть тысяч триста двадцать один рубль";
        String actual = currencyConverter.convert(456546321);
        assertEquals(expected, actual);
    }

    @Test
    void convertMinus956549684623() {
        String expected = "минус девятьсот пятьдесят шесть миллиардов пятьсот сорок девять миллионов шестьсот восемьдесят четыре тысячи шестьсот двадцать три рубля";
        String actual = currencyConverter.convert(-956549684623L);
        assertEquals(expected, actual);
    }

    @Test
    void convert0123() {
        String expected = "сто двадцать три рубля";
        String actual = currencyConverter.convert(0123D);
        assertEquals(expected, actual);
    }

    @Test
    void convert41051() {
        String expected = "сорок одна тысяча пятьдесят один рубль";
        String actual = currencyConverter.convert(41051);
        assertEquals(expected, actual);
    }
}