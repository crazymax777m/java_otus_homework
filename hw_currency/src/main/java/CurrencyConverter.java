import com.github.moneytostr.MoneyToStr;

import java.util.Arrays;
import java.util.Scanner;

public class CurrencyConverter {
    private final MoneyToStr moneyToStr;

    public CurrencyConverter() {
        moneyToStr = new MoneyToStr(MoneyToStr.Currency.RUR, MoneyToStr.Language.RUS, MoneyToStr.Pennies.NUMBER);
    }

    public String convert(double amount) {
        String[] temp = moneyToStr.convert(amount).split(" ");
        return joinStrings(temp, " ", temp.length - 2);
    }

    private String joinStrings(String[] array, String delimiter, int endIndex) {
        String[] subArray = Arrays.copyOfRange(array, 0, endIndex);
        return String.join(delimiter, subArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();

        CurrencyConverter converter = new CurrencyConverter();
        String result = converter.convert(amount);

        System.out.println(result);
    }
}
