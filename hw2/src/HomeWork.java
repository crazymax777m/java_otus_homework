import java.util.Base64;
import java.util.Scanner;

// Зарегистрироваться на github.com
// Установить git
// Установить JDK и среду разработки
// Открыть данный класс в IDE
// Скомпилировать данный класс с помощью команды javac.
// Запустить программу на выполнение с помощью команды java
// Запустить программу на выполнение с помощью среды разработки
// Когда программа запросит - введите свое имя латиницей
// Сделайте pull-request с программой.
// Отправить в чат задания ссылку на pull-request
public class HomeWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter you full name");
        String fullName = sc.nextLine();
        String encodedFullName = Base64.getEncoder().encodeToString(fullName.getBytes());
        System.out.println("Program result: " + encodedFullName);
    }
}
