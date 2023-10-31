import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    @ParameterizedTest
    @CsvSource({"1568, одна тысяча пятьсот шестьдесят восемь рублей",
            "-1568, минус одна тысяча пятьсот шестьдесят восемь рублей",
            "0, ноль рублей",
            "-0, ноль рублей",
            "0000000000000, ноль рублей",
            "-0000000000000, ноль рублей",
            "456546321, четыреста пятьдесят шесть миллионов пятьсот сорок шесть тысяч триста двадцать один рубль",
            "-956549684623, минус девятьсот пятьдесят шесть миллиардов пятьсот сорок девять миллионов шестьсот восемьдесят четыре тысячи шестьсот двадцать три рубля",
            "0123, сто двадцать три рубля",
            "-0123, минус сто двадцать три рубля",
            "41051, сорок одна тысяча пятьдесят один рубль"
    })
    public void testNum2strWithoutKopeks(String number, String expected) {
        CurrencyConverter currencyConverter = new CurrencyConverter(number);
        String result = currencyConverter.num2str(true);
        assertEquals(expected, result);
    }
}